# SubCas

`Springboot 2.7.5` + `JPA` + `SpringSecurity` + `MariaDB` + `Redis`

## about application.yaml
`src/main/resources/application.yaml` template
```yaml
server:
  port: 5000
spring:
  datasource:
    url: jdbc:mariadb://localhost:3306/subcas
    username: test
    password: 123456
    driver-class-name: org.mariadb.jdbc.Driver

  redis:
    host: localhost
    port: 6379
    timeout: 10
    database: 0
  jpa:
    show-sql: true
    hibernate:
      ddl-auto: update
subcas:
  jwt:
    type: Bearer
    expired: 7200000
    secret: 123456

```
