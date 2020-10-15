To run the example with postgres database use the below command


1. Use below command to start Postgres docker instance

```docker run -d --name postgres -p 5432:5432 -e POSTGRES_USER="demouser" -e POSTGRES_PASSWORD="demopwd" -e POSTGRES_DB="demodb" postgres```

2. Use below command to connect to Postgres database

```docker exec -it postgres psql -U demouser demodb```

3. Use the script in the resources folder to create database table.

4. Use the below curl command to invoke the API code

```
curl -X GET \
  'http://localhost:8080/employees' \
  -H 'Content-Type: application/json' 
```

```
curl -X POST \
  http://localhost:8080/employees \
  -H 'Content-Type: application/json' \
  -d '{
    "firstName": "pack",
    "lastName" : "row",
    "age": 23,
    "martialStatus" : "married"

}' 


