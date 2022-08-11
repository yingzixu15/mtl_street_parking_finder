import os
import pandas as pd

directory_path = os.getcwd()
data_path = os.path.join(directory_path, 'data', 'signalisation_stationnement.csv')
df = pd.read_csv(data_path)
df_projected = df[ (df['DESCRIPTION_REP'] == 'Réel') & (df['DESCRIPTION_CAT'] == 'STATIONNEMENT')]
df_projected = df_projected[['DESCRIPTION_RPA', 'Longitude', 'Latitude', 'NOM_ARROND']]

destination_path = os.path.join(directory_path, 'data', 'signalisation_stationnement_clean.csv')
df_projected.to_csv(destination_path)