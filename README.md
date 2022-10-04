# Montreal Street Parking Finder

This app is under development. However, part of the API function is ready to use. 

## Raw data

Data files are gathered from the following sources:
- https://www.kaggle.com/datasets/mnabaee/mtlstreetparking?resource=download
- https://donnees.montreal.ca/ville-de-montreal/stationnement-sur-rue-signalisation-courant

There are some typos/text mismatch in the original data that was manually fixed before processing with script as it makes my life easier. The following are the changes (case insensitive):
- avil -> avril
- mrs -> mars
- déc -> dec

You can use `replace all` to get the same base data as mine to use for the scripts. 

## Database

If you wish to run this app locally, you will need to have the DB file under the root of this folder. 

You need to have `sqlite3` installed on your machine (Linux). 

The file needs to have the name `mtl_parking.db`. The scripts for creating tables and loading the database can be found in the `src/main/data_cleaning` folder. 
- In the SQLite3 console, run `.read src/main/data_cleaning/create_tables.sql`. 
- In your terminal, run `python3 src/main/data_cleaning/load_db.py` to load the DB.

## API

For the time being, you can run the Spring Boot application locally and try out the API function. 
- `/api/signs/show-all`: list all parking signs. This will likely freeze the API as the dataset is large. 
- `/api/signs/show-limit/{n}`: list the first `n` parking signs in the DB. 
- `/show-radius/long/{long}/lat/{lat}/distance/{dist}`: list all parking signs around `(long, lat)` within distance range `dist` (in kilometers).
- `/show-radius-on-date/long/{longStr}/lat/{latStr}/distance/{distStr}/month/{m}/day/{d}`: list all parking signs 
around `(long, lat)` within distance range `dist` (in kilometers) that are valid in the month `m` on the date `d`. 
