# exp-spring
Experimental Spring with VueJS

## Development
### Setup
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
### Run test
```bash
./gradlew test
```

### Compiles, tests and assembles the code into JAR file
```bash
./gradlew build
```
### Clean up
remove containers and volumes
```bash
docker compose down -v
```
### Run an application

#### Service A
The api on http://localhost:8081/user
```bash
./gradlew :service-a:bootRun
```
#### Service B
The api on http://localhost:8082/table
```bash
./gradlew :service-b:bootRun
```
### Usage
#### API usage for service A
```bash
# get all users
curl -i "http://localhost:8081/user"

# get a single user
curl -i "http://localhost:8081/user/1"

# create user
curl -i -X POST "http://localhost:8081/user" \
      -H "Content-Type:application/json" \
      -d '{ "name": "rtpk", "country": "TH" }'
      
# delete user
curl -i -X DELETE "http://localhost:8081/user/7"
```

