# Money Transfer API using DropWizzard micro framework
Money Transfer API

# How to build and run
### Build with unit test
mvn package

### Build without unit tests
If you get unit test error for rate calculation, skip the entire test cases. Money rates are retrieved on real time:  
mvn package -DskipTests

### Run
java -jar target\dropwizard-money-transfer-1.0-SNAPSHOT.jar server .\config.yml

# REST APIs

    POST    /transfer/{amount}/from/{from}/to/{to} (com.money.service.TransferService)
    GET     /account/all (com.money.service.AccountService)
    GET     /account/get/{id} (com.money.service.AccountService)
    GET     /account/remove (com.money.service.AccountService)
    POST    /account/save (com.money.service.AccountService)
    GET     /user/all (com.money.service.UserService)
    GET     /user/get/{id} (com.money.service.UserService)
    GET     /user/remove (com.money.service.UserService)
    POST    /user/save (com.money.service.UserService)
    
 Sample Access URI: http://localhost:8080/user/all

# Requirements

Avoid heavy frameworks  
Framework should allow creating executable as a standalone program  
Framework should not require a pre-installed container/server  
Demonstrate with tests that the API works as expected  

## Framework decision
Options for micro RESTful frameworks. A microframework is a term used to refer to minimalistic web application frameworks:  

DropWizzard - stand-alone mode, lightweight, easy to set-up, similar to Spring Boot, it uses existing Jetty HTTP library embedding it directly into your project, this way external application server is not needed.  
Ninja Web Framework - stand-alone mode, as a self-executing jar package bundled with Jetty.  
Spark Framework - Lack of documentation is missing  

## Micro frameworks
https://www.gajotres.net/best-available-java-restful-micro-frameworks/  
https://raygun.com/blog/popular-java-frameworks/  

## Java Money and Currency Classes
http://www.javapractices.com/topic/TopicAction.do?Id=13  
https://www.baeldung.com/java-money-and-currency  
