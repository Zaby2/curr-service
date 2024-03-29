Bank MicroService

This service was made using Spring Boot

It stores values of different currencies, so you can get them by simple GET: /cur-ex/from/EUR/to/INR
It will return the object of type ExchangeData (or json if we r talking about html output)
Currently it storing data in H2, however we need to make it store data in postgreSQL
So TODO:
1) PostgreSql support
2) We need to create another service, that will work /w central bank API, and put it to db
