# Montreal Street Parking Finder

This app is under development. 

The general idea is to build a web application using Spring Boot abd SQLite. It's mostly a demo project, but if you notice any error please feel free to raise it in the Issues.

## Raw data

Data files are gathered from the following sources:
- https://www.kaggle.com/datasets/mnabaee/mtlstreetparking?resource=download
- https://donnees.montreal.ca/ville-de-montreal/stationnement-sur-rue-signalisation-courant

There are some typos/text mismatch in the original data that was manually fixed before processing with script as it makes my life easier. The following are the changes (case insensitive):
- avil -> avril
- mrs -> mars
- déc -> dec

You can use `replace all` to get the same base data as mine to use for the scripts. 

The data folder will be removed from GitHub after the data processing branch is done, as they will be outdated at some point. 

## Data processing
As my French skill is limited, there may be misinterpretation during my data processing. Feel free to raise it if you notice anything. 

## Web application
So far there is not much yet, but I will be using Bootstrap 5 / Thymeleaf for the frontend. 
