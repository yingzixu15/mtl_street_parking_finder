import sqlite3
import os
import json


def main(db_path: str):
    months = ['jan', 'fevr', 'mars', 'avr', 'mai',
          'juin', 'juil', 'aout', 'sept', 'oct', 'nov', 'dec']
    
    connection = sqlite3.connect(db_path)
    cursor = connection.cursor()
    directory_path = os.getcwd()

    for m in months:
        data_path = os.path.join(directory_path, 'data', f'sign_{m}.json')
        with open(data_path, 'r') as read_file:
            items = json.load(read_file)
            for row in items:
                pass
    pass

if __name__ == '__main__':
    main()