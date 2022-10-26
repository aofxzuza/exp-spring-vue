# exp-spring
Experimental Spring with VueJS

## Development

### Run test
```bash
./gradlew test
```

### Compiles, tests and assembles the code into JAR file
```bash
./gradlew build
```

### Run an application
#### Database
Run docker-compose contain postgresql
```bash
docker compose up -d
```
Run database migration
```bash
cd liquibase
liquibase update
```

#### Service A
The api on http://localhost:8081/table
```bash
./gradlew :service-a:bootRun
```
#### Service B
The api on http://localhost:8082/table
```bash
./gradlew :service-b:bootRun
```
### Usage
Get table from service A
```bash
curl -i "http://localhost:8081/table"
```
Get table from service B
```bash
curl -i "http://localhost:8082/table"
```
