# Spring Boot 2 JWT Rest API

This project is a starting point for later use, serving as a skeleton.

Technologies used:
* Spring Boot
* Spring Data Rest
* Spring Security + JWT
* Liquibase

## Prerequisites
* Maven
* JDK 8

> For the PostgreSQL docker included, see below.

## Build and Run

> Before you begin, copy the contents of the file `.env.docker.skeleton` to `.env` and set the values according to your needs.

> Don't forget to check the config in the `src/main/resources/application.yml` file.

``` bash
# build
$ mvn clean install

# start
$ mvn spring-boot:run
```

## Tests

To run the tests for the application:

``` bash
$ mvn test
```

## Docker for PostgreSQL database

The project has a docker with a PostgreSQL database. 

To set your variables, copy the `.env.docker.skeleton` to `.env` file in the project root.

To use it, simply run the following command:

``` bash
$ docker-compose up -d
```

> You have to have Docker and Docker Compose installed.

## Configuration files

* Spring Boot config file: `src/main/resources/application.yml`
* Liquibase config file: `src/main/resources/liquibase.properties`
* For the docker configuration: `.env` (`.env.docker.skeleton`, see above)