# Configuration

## Data sample

For the use I will consider using 3 databases.

- A `central` database that contains a list of cities, with their localization, either `EU` or `US`.
- A `EU` database that contains the cities with general informations (country, area, population)
- A `US` database that contains the cities with general informations (country, area, population)

## Databases installation

To quickly have a constistent environment I use Docker and MongoDB to prepare my data samples.

> You need to have [Docker](https://docs.docker.com/install/) installed

To (pull and) start a new MongoDB instance we need to run the following command

 > $ docker run -p 37017:27017 -v ~/data:/data/db --name my-mongo -d mongo

Where:

- `-p` redirect the port 37017 to 27017 of the container
- `-v` mount external volume for the container, where `~/data` will be used as `/data/db` inside the container
- `--name` give a specific name to the running container
- `-d` specify that we want to run the container in the background

If you already have run this instance just start it with the command:

 > $ docker start my-mongo

For more details I invite you to visit the [Docker Hub](https://hub.docker.com/_/mongo/)'s page.

### Central database

To start a new instance of the `central` database, run the command:

 > $ docker run -p 1111:27017 -v /opt/mongo/db/central:/data/db --name central-mongo -d mongo

Before populate, you need a connection to the database. You can either use a mongo client, with:
> mongo localhost:1111/centralshard

Or, connect directly to the Docker container, with:
> docker exec -it central-mongo mongo
> use centralshard

To population the database you can execute the following code:

```json
db.cities_directory.insert([
    {"city" : "London",        "region" : "EU"},
    {"city" : "Paris",         "region" : "EU"},
    {"city" : "Brussels",      "region" : "EU"},
    {"city" : "Berlin",        "region" : "EU"},
    {"city" : "Barcelona",     "region" : "EU"},
    {"city" : "Roma",          "region" : "EU"},
    {"city" : "Olso",          "region" : "EU"},
    {"city" : "Praha",         "region" : "EU"},
    {"city" : "New-York",      "region" : "US"},
    {"city" : "Washington",    "region" : "US"},
    {"city" : "Seatle",        "region" : "US"},
    {"city" : "Dallas",        "region" : "US"},
    {"city" : "Chicago",       "region" : "US"},
    {"city" : "Miami",         "region" : "US"},
    {"city" : "San Fransisco", "region" : "US"}
])
```

To check the data run:
> db.cities_directory.find()

### European database

To start a new instance of the `EU` database, run the command:

 > $ docker run -p 1112:27017 -v /opt/mongo/db/eu:/data/db --name eu-mongo -d mongo

Before populate, you need a connection to the database. You can either use a mongo client, with:
> mongo localhost:1112/eushard

Or, connect directly to the Docker container, with:
> docker exec -it eu-mongo mongo
> use eushard

To population the database you can execute the following code:

```json
db.cities_directory.insert([
    {"city" : "London",     "country": "England", "area":"1737.9", "population" : "8787892", "region" : "EU"},
    {"city" : "Paris",      "country": "France", "area":"2845", "population" : "2206488", "region" : "EU"},
    {"city" : "Brussels",   "country": "Belgium", "area":"161.38", "population" : "1175173", "region" : "EU"},
    {"city" : "Berlin",     "country": "Germany", "area":"891.7", "population" : "3711930", "region" : "EU"},
    {"city" : "Barcelona",  "country": "Spain", "area":"101.4", "population" : "1620809", "region" : "EU"},
    {"city" : "Rome",       "country": "Italy", "area":"1285", "population" : "2873874", "region" : "EU"},
    {"city" : "Olso",       "country": "Norway", "area":"480.76", "population" : "673469", "region" : "EU"},
    {"city" : "Praha",      "country": "Czech Republic", "area":"496", "population" : "1280508", "region" : "EU"}
])
```

### US database

To start a new instance of the `US` database, run the command:

 > $ docker run -p 1113:27017 -v /opt/mongo/db/us:/data/db --name us-mongo -d mongo
 
Before populate, you need a connection to the database. You can either use a mongo client, with:
> mongo localhost:1113/usshard

Or, connect directly to the Docker container, with:
> docker exec -it us-mongo mongo
> use usshard

To population the database you can execute the following code:

```json
db.cities_directory.insert([
    {"city" : "New-York",      "country": "United-States", "area":"1213.37", "population" : "8622698", "region" : "US"},
    {"city" : "Washington",    "country": "United-States", "area":"177",     "population" : "693972",  "region" : "US"},
    {"city" : "Seatle",        "country": "United-States", "area":"369.2",   "population" : "713700",  "region" : "US"},
    {"city" : "Dallas",        "country": "United-States", "area":"999.3",   "population" : "1317929", "region" : "US"},
    {"city" : "Chicago",       "country": "United-States", "area":"606.42",  "population" : "2704958", "region" : "US"},
    {"city" : "Miami",         "country": "United-States", "area":"145.20",  "population" : "453579",  "region" : "US"},
    {"city" : "San Fransisco", "country": "United-States", "area":"600.59",  "population" : "884363",  "region" : "US"}
])
```