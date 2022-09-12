CREATE TABLE IF NOT EXISTS signs(id INTEGER PRIMARY KEY, longitude REAL NOT NULL, latitude REAL NOT NULL, nom_arrond TEXT, description_rpa TEXT, start_month INTEGER NOT NULL, start_date INTEGER NOT NULL, end_month INTEGER NOT NULL, end_date INTEGER NOT NULL);

CREATE TABLE IF NOT EXISTS voie(id_voie INTEGER PRIMARY KEY, nom_voie TEXT NOT NULL, nom_ville TEXT, sens_cir INTEGER, type_f TEXT);
CREATE INDEX index_voie_nom ON voie (nom_voie);
CREATE TABLE IF NOT EXISTS line_segments(
    id INTEGER PRIMARY KEY, string_type TEXT, coordinates TEXT NOT NULL, 
    id_voie INTEGER NOT NULL, 
    FOREIGN KEY(id_voie) REFERENCES voie(id_voie)
);
CREATE INDEX index_line_segments_voie ON line_segments (id_voie);