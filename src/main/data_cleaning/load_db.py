import sqlite3
import os
import json


def main():
    # connect to DB
    directory_path = os.getcwd()
    dbpath = os.path.join(directory_path, 'mtl_parking.db')
    connection = sqlite3.connect(dbpath)
    cursor = connection.cursor()

    load_signs(connection, cursor, directory_path)
    load_voie(connection, cursor, directory_path)

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
    pass

if __name__ == '__main__':
    main()
