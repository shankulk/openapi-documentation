# openapi-documentation

Use this Spring Boot project as an example to generate openapi documentation from `openapi.yaml`. 
I have used a standard openapi.yaml from OpenAPI Editor [example](https://editor.swagger.io/)

## Compiling and building the project
```sh
./gradlew clean build
./gradlew bootJar
```
## Accessing openapi specification and Swagger UI
[api-docs](http://localhost:8080/v3/api-docs)
[swagger-ui](http://localhost:8080/swagger-ui/index.html)
