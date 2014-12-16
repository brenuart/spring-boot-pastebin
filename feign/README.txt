
sample-eurekaserver
-------------------
Starts an Eureka server on port 8761


sample-helloservice
-------------------
Sample Hello service instance running port 8081 (can be overridden using -Dserver.port=<port>)
Simply returns a "Hello" string with the instanceId appended to identify which service instance replied:
    http://localhost:8081/

Application can be started using "mvm spring-boot:run")


sample-helloclient
------------------
Sample Hello client application making use of both SpringTemplate and Feign to access the HelloService.
The HelloService instance is located using Eureka.
The application starts on port 8080 by default (can be overridden using -Dserver.port=<port>)

http://localhost:8080/rt --> makes use of Spring RestTemplate combined with an Eureka Ribbon to locate
                             and access the service instance.

http://localhost:8080/feign --> makes use of a Feign client to access and locate the service instance.


Scenario
--------
Start the Eureka server.
Start the HelloService and wait until it is successfully registered with the Eureka service.

* Case 1
Start the HelloClient.
Invoke http://localhost:8080/feign
--> Feign client is unable to locate the hello service instance.

* Case 2
Restart the HelloClient
Invoke http://localhost:8080/rt
--> The RestTemplate successfully locate and access the hello service instance.

* Case 3
Restart the HelloClient
Invoke http://localhost:8080/rt
--> The RestTemplate successfully locate and access the hello service instance.
Invoke http://localhost:8080/feign
--> The Feign client now successfully locate and connects to the hello service instance
