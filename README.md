# Currency Service
____

## Description
This project is created to convert one currency to another. It is using API of https://freecurrencyapi.com/, but you can add your own.
The project is devided into three services, that are connected by REST API. All of this services are returning the simple json, so you can easily integrate  each of them into your system.


Note that in this project I worked with H2 database, so for your peoject you will need to do this steps:
1. Add PostgreSQL dependency to pom.xml
2. Download PostgreSQL driver, simular as for JDBC
3. Make changes in application.properties
   
Note that here is just example of dockerfile, so you need to create the simular one for each of services if you need 



