# money-transfer
Money Transfer API

# How to build and run
mvn package
java -jar dropwizard-money-transfer-1.0-SNAPSHOT.jar server ../config.yml

# Requirements

Avoid heavy frameworks__
Framework should allow creating executable as a standalone program__
Framework should not require a pre-installed container/server__
Demonstrate with tests that the API works as expected__

## Framework decision
Options for micro RESTful frameworks. A microframework is a term used to refer to minimalistic web application frameworks:__

DropWizzard - stand-alone mode, lightweight, easy to set-up__
Ninja Web Framework - stand-alone mode, as a self-executing jar package bundled with Jetty.__
Spark Framework - Lack of documentation is missing__

## Micro frameworks
https://www.gajotres.net/best-available-java-restful-micro-frameworks/
https://raygun.com/blog/popular-java-frameworks/

## Java Money and Currency Classes
http://www.javapractices.com/topic/TopicAction.do?Id=13__
https://www.baeldung.com/java-money-and-currency__
