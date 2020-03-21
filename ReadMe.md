# Karaf Service Discovery

This project is designed for micro-service architect based on OSGi.

One of important sections in micro-service is <b>Service Discovery</b>. One of popular service discovery in
microservice architecture is Eureka, specially Spring-Eureka. This application is designed to register karaf
as a service in Spring-Eureka service. For registering karaf in Eureka this code can used in your application
(this code can be used after install bundles of this project)

## How to register Karaf as Service
```$xslt
eurekaService.registerServiceInEurekaService(
                applicationName,
                applicationPortNum,
                healthCheckURL,
                statusPageURL,
                homePageURL
        );
``` 

## How to install bundles of project

```$xslt
$ feature:repo-add mvn:com.khtm.osgi/service-discovery-feature/1.0-SNAPSHOT/xml
$ feature:install karaf-service-discovery-eureka-provider
```
## Result

```$xslt
        __ __                  ____      
       / //_/____ __________ _/ __/      
      / ,<  / __ `/ ___/ __ `/ /_        
     / /| |/ /_/ / /  / /_/ / __/        
    /_/ |_|\__,_/_/   \__,_/_/         

  Apache Karaf (4.2.8)

Hit '<tab>' for a list of available commands
and '[cmd] --help' for help on a specific command.
Hit '<ctrl-d>' or type 'system:shutdown' or 'logout' to shutdown Karaf.

karaf@root()> feature:repo-add mvn:com.khtm.osgi/service-discovery-feature/1.0-SNAPSHOT/xml                                                      
Adding feature url mvn:com.khtm.osgi/service-discovery-feature/1.0-SNAPSHOT/xml
karaf@root()> feature:install karaf-service-discovery-eureka-provider                                                                            
karaf@root()> feature:list | grep -i eureka
karaf-service-discovery-eureka-init     │ 1.0.0.SNAPSHOT   │          │ Started     │ karaf-service-discovery-eureka-1.0-SNAPSHOT │
karaf-service-discovery-eureka-api      │ 1.0.0.SNAPSHOT   │          │ Started     │ karaf-service-discovery-eureka-1.0-SNAPSHOT │
karaf-service-discovery-eureka-provider │ 1.0.0.SNAPSHOT   │ x        │ Started     │ karaf-service-discovery-eureka-1.0-SNAPSHOT │
karaf@root()>                                                                                                                                    
```

