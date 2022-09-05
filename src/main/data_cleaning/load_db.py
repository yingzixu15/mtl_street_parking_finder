import sqlite3
import os
import json


def main():
    # connect to DB
    directory_path = os.getcwd()
    dbpath = os.path.join(directory_path, 'mtl_parking.db')
    connection = sqlite3.connect(dbpath)
    cursor = connection.cursor()
    
    load_signs_by_month(connection, cursor, directory_path)
    load_voie(connection, cursor, directory_path)
    
    connection.close()

def load_signs_by_month(connection: sqlite3.Connection, cursor: sqlite3.Cursor, directory_path: str):
    months = ['jan', 'fevr', 'mars', 'avr', 'mai',
          'juin', 'juil', 'aout', 'sept', 'oct', 'nov', 'dec']
    
    for e,m in enumerate(months):
        data_path = os.path.join(directory_path, 'data', f'sign_{m}.json')
        with open(data_path, 'r') as read_file:
            print('opening file {data_path}...')
            items = json.load(read_file)
            print(f'For month {e+1}, {len(items)} record(s) loaded.')
            items = map(lambda row: (row['Longitude'], row['Latitude'], 
                                     row['NOM_ARROND'], row['DESCRIPTION_RPA'], 
                                     row['start_month'], row['start_date'], 
                                     row['end_month'], row['end_date']), items)
            cursor.executemany(f'INSERT INTO sign_{e+1} VALUES (NULL,?,?,?,?,?,?,?,?)', items)
            connection.commit()
            
            cursor.execute(f'SELECT COUNT(*) FROM sign_{e+1}')
            num_rows_added = cursor.fetchone()
            print(f'Number of rows in sign_{e+1} after loading: {num_rows_added[0]}')

def load_voie(connection: sqlite3.Connection, cursor: sqlite3.Cursor, directory_path: str):
    pass

if __name__ == '__main__':
    main()
