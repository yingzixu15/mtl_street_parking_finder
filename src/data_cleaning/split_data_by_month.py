import re
import os.path
import pandas as pd


directory_path = os.getcwd()
data_path = os.path.join(directory_path, 'data',
                         'signalisation_stationnement_clean.csv')
df = pd.read_csv(data_path)
df['DESCRIPTION_RPA'] = df['DESCRIPTION_RPA'].str.lower()
months = ['jan', 'fevr', 'mars', 'avr', 'mai',
          'juin', 'juil', 'aout', 'sept', 'oct', 'nov', 'dec']
days = ['lun', 'mar.', 'mardi', 'mer', 'jeu', 'ven', 'sam', 'dim']
numbers_pattern = '[0-9]+'


def get_date_range(input: str) -> dict:
    result = {
        'all': False,
        'start_month': -1,
        'start_date': -1,
        'end_month': -1,
        'end_date': -1
    }
    month_indices = []
    for e, m in enumerate(months):
        if m in input:
            month_indices.append((input.index(m), e, m))

    if len(month_indices) == 0:
        result['all'] = True
        return result

    month_indices.sort(key=lambda t: t[0])
    result['start_month'] = month_indices[0][1]
    result['end_month'] = month_indices[1][1]
    start_date1 = input.split(month_indices[0][2])[0].split()[-1]
    start_date2 = ''.join(re.findall(numbers_pattern, start_date1))
    if len(start_date2) > 0:
        result['start_date'] = int(start_date2)
    else:
        result['start_date'] = 1
    end_date1 = input.split(month_indices[1][2])[0].split()[-1]
    end_date2 = ''.join(re.findall(numbers_pattern, end_date1))
    if len(end_date2) > 0:
        result['end_date'] = int(end_date2)
    else:
        result['end_date'] = 1
    return result


month_to_sign_dict = {}
for m in months:
    month_to_sign_dict[m] = []

for i in df.index:
    row = df.loc[i]
    date_range = get_date_range(str(row['DESCRIPTION_RPA']))
    if date_range['all']:
        for m in months:
            month_to_sign_dict[m].append(i)
    else:
        for mindex in range(date_range['start_month'], date_range['end_month'] + 1):
            month_to_sign_dict[months[mindex]].append(i)

for m in months:
    df_month = df.loc[month_to_sign_dict[m]]
    destination_path = os.path.join(directory_path, 'data', f'sign_{m}.csv')
    df_month.to_csv(destination_path)
