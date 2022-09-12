import sqlite3
import os
import json


def main():
    directory_path = os.getcwd()
    dbpath = os.path.join(directory_path, 'mtl_parking.db')
    connection = sqlite3.connect(dbpath)
    cursor = connection.cursor()

    load_signs(connection, cursor, directory_path)
    load_voie(connection, cursor, directory_path)
    load_line_segments(connection, cursor, directory_path)

    connection.close()


def load_signs(connection: sqlite3.Connection, cursor: sqlite3.Cursor, directory_path: str):
    data_path = os.path.join(directory_path, 'data', 'signs_all.json')
    with open(data_path, 'r') as read_file:
        items = json.load(read_file)
        items = map(lambda row: (row['Longitude'], row['Latitude'],
                                 row['NOM_ARROND'], row['DESCRIPTION_RPA'],
                                 row['start_month'], row['start_date'],
                                 row['end_month'], row['end_date']), items)
        cursor.executemany(
            'INSERT INTO signs VALUES (NULL,?,?,?,?,?,?,?,?)', items)
        connection.commit()

        cursor.execute('SELECT COUNT(*) FROM signs')
        num_rows_added = cursor.fetchone()
        print(f'Number of rows in signs after loading: {num_rows_added[0]}')


def load_voie(connection: sqlite3.Connection, cursor: sqlite3.Cursor, directory_path: str):
    def map_feature(feature: dict):
        property = feature['properties']
        if 'TYPE_F' not in property:
            property['TYPE_F'] = None
        if 'NOM_VILLE' not in property:
            property['NOM_VILLE'] = None
        return (property['ID_VOIE'], property['NOM_VOIE'], property['NOM_VILLE'], property['SENS_CIR'], property['TYPE_F'])
    
    data_path = os.path.join(directory_path, 'data', 'gbdouble.json')
    with open(data_path, 'r') as read_file:
        features = json.load(read_file)['features']
        voie_list = map(lambda row: map_feature(row), features)
        cursor.executemany('INSERT OR IGNORE INTO voie VALUES (?,?,?,?,?)', voie_list)
        connection.commit()
        
        cursor.execute('SELECT COUNT(*) FROM voie')
        num_rows_added = cursor.fetchone()
        print(f'Number of rows in voie after loading: {num_rows_added[0]}')
        
        
        
def load_line_segments(connection: sqlite3.Connection, cursor: sqlite3.Cursor, directory_path: str):
    def map_feature(feature: dict):
        return (feature['geometry']['type'], json.dumps(feature['geometry']['coordinates']), feature['properties']['ID_VOIE'])
        
    data_path = os.path.join(directory_path, 'data', 'gbdouble.json')
    with open(data_path, 'r') as read_file:
        items = json.load(read_file)['features']
        items = map(lambda row: map_feature(row), filter(lambda row: row['geometry'] is not None, items))
        cursor.executemany('INSERT INTO line_segments VALUES (NULL,?,?,?)', items)
        connection.commit()
        
        cursor.execute('SELECT COUNT(*) FROM line_segments')
        num_rows_added = cursor.fetchone()
        print(f'Number of rows in line_segments after loading: {num_rows_added[0]}')
        

if __name__ == '__main__':
    main()
