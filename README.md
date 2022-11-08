# exp-spring
Experimental Spring with VueJS
## Tech Stacks
* Service-A
  * [Spring Boot Rest](https://spring.io/guides/tutorials/rest/)
  * [JDBC / Postgresql](https://spring.io/projects/spring-data-jdbc)
  * [Spock](https://spockframework.org/)
* Service-B
  * [Spring Boot Rest](https://spring.io/guides/tutorials/rest/)
  * [OpenFeign](https://github.com/OpenFeign/feign)
  * [Keycloak Spring Security](https://www.keycloak.org/docs/latest/securing_apps/#_spring_security_adapter)
* Client
  * [VueJS](https://vuejs.org/)
  * [Axios](https://github.com/axios/axios)
* Dev Environment
  * [Liquibase](https://www.liquibase.org/)
  * [Docker & Docker compose](https://www.docker.com/)
  * [Keycloak](www.keycloak.org)


## Development

#### [Keycloak Usage](./realm/README.md)
#### 
### Setup Environments
Create and start containers
```bash
docker compose up -d
```

Stop and remove containers, networks and volumns
```bash
docker compose down -v
```

Run database migration - [Liquibase Usage](./liquibase/README.md)
```bash
cd liquibase
liquibase update
```

Install the dependencies - [Vue-client Usage](./vue-client/README.md)
```bash
cd vue-client
npm install
```

### Run test
```bash
./gradlew test
```

### Compiles, tests and assembles the code into JAR file
```bash
./gradlew build
```

## Run applications
### Service A
Start the service A.
```bash
./gradlew :service-a:bootRun
```
The api is available on http://localhost:8081/products
#### API usage for service A
Get all products
```bash
curl -v -X GET "http://localhost:8081/product" \
-u "service-a:password" | jq .
```

Add new product
```bash
curl -v -X POST "http://localhost:8081/product" \
      -H "Content-Type:application/json" \
      -u "service-a:password" \
      -d '{ "name": "rtpk", "price": 100 }' | jq .
```

Get a product
```bash
curl -v -X GET "http://localhost:8081/product/1" \
-u "service-a:password" | jq .
```

Delete product
```bash
curl -v -X DELETE "http://localhost:8081/product/1" \
-u "service-a:password" | jq .
```
### Service B
Start the service B.
```bash
./gradlew :service-b:bootRun
```
Open a browser to http://localhost:8082.
#### API usage for service A
Store access token in environment
```bash
export TOKEN=$(curl -X POST "http://localhost:8180/realms/myrealm/protocol/openid-connect/token" \
-d "client_id=spring-app" \
-d "username=myuser" \
-d "password=password" \
-d "grant_type=password" | jq -r '.access_token')
```

Get all products
```bash
curl -v -X GET "http://localhost:8082/product" \
-H "Authorization: Bearer $TOKEN" | jq .
````

Add new product
```bash
curl -v -X POST "http://localhost:8082/product" \
      -H "Content-Type:application/json" \
      -H "Authorization: Bearer $TOKEN" \
      -d '{ "name": "rtpk", "price": 100 }' | jq .
```

Get a product
```bash
curl -v -X GET "http://localhost:8082/product/1" \
-H "Authorization: Bearer $TOKEN" | jq .
```

Delete product
```bash
curl -v -X DELETE "http://localhost:8082/product/1" \
-H "Authorization: Bearer $TOKEN" | jq .
```
### Vue Client [Vue-client Usage](./vue-client/README.md)
Start the client.
```bash
npm run dev
```
Open a browser to http://localhost:8080.

Login page, try login with these credentials
```
# myuser - allow to add/delete product
username: myuser
password: password

# myuser2 - does not allow to add/delete product
username: myuser2
password: password
```
![vue-client-login](./img/vue-client-login.png)

Products page
![vue-client-product](./img/vue-client-products.png)


