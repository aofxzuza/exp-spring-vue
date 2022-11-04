# Keycloak Usage
## Prerequisite
* [jq](https://stedolan.github.io/jq/)
## Export realm
```bash
# access keycloak container
docker exec -it keycloak_container bash  

# export a specific realm
cd /opt/keycloak/
./bin/kc.sh export --file myrealm.json --realm myrealm
exit

# copy realm from the container
docker cp keycloak_container:/opt/keycloak/myrealm.json .
```

## Rest API Usage
```bash
# Discovery endpoints
curl -X GET "http://localhost:8180/realms/myrealm/.well-known/uma2-configuration" | jq .

# Get access token
export TOKEN=$(curl -X POST "http://localhost:8180/realms/myrealm/protocol/openid-connect/token" \
-d "client_id=spring-app" \
-d "username=myuser" \
-d "password=password" \
-d "grant_type=password" | jq -r '.access_token')

# Get token
env | grep TOKEN
```