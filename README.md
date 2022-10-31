# exp-spring
Experimental Spring with VueJS
## Tech Stacks
* Service-A
  * [Spring Boot Rest](https://spring.io/guides/tutorials/rest/)
  * [JDBC / Postgresql](https://spring.io/projects/spring-data-jdbc)
  * [Spock](https://spockframework.org/)
* Service-B
  * [Spring MVC / Thymeleaf](https://spring.io/guides/gs/serving-web-content/)
  * [OpenFeign](https://github.com/OpenFeign/feign)
* Client
  * [VueJS](https://vuejs.org/)
  * [Axios](https://github.com/axios/axios)
* Dev Environment
  * [Liquibase](https://www.liquibase.org/)
  * [docker & docker compose](https://www.docker.com/)
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
Start the service A.
```bash
./gradlew :service-a:bootRun
```
The api is available on http://localhost:8081/user
#### Service B

Start the service B.
```bash
./gradlew :service-b:bootRun
```
Open a browser to http://localhost:8082.
![Service-B](./img/service-b-html.png)
#### Client
To start the client, open another Bash shell and navigate to the `vue-client` subdirectory.

Install the dependencies.
```bash
npm install
```
Start the client.
```bash
npm run dev
```

Open a browser to http://localhost:8080.
![vue-clien](./img/vue-client.png)

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

