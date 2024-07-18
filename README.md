# spring-ticket
Development exercise to explore language and library capabilities by building a simple ticketing application.

Requires Java version 21.

Ideas explored:

- Layered/clean architecture

- REST API design

- REST API query implementation

- Common repository pattern

- Error handling

- Cloud ready deployment

## Running

Set required environment variables:

```
source .env
```

Run the server with all service dependencies using docker-compose:

```
docker-compose --profile include_app up --build
```

Run the service dependencies only using docker-compose:

```
docker-compose up
```

Run the server only without Docker:

```
export $(grep -v '^#' .env | xargs)
./mvnw clean package
java -jar target/spring-ticket-0.0.1-SNAPSHOT.jar
```


## Troubleshooting

### Test that postgres is running and has the application database and tables.

Open pgAdmin at `http://localhost:8900` (see [docker-compose.yml](./docker-compose.yml) for credentials). 

Open the application database (see [.env](./.env) for password)
