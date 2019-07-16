# papafoodBackend

Setup backend Papafood by spring boot and jdbc mysql

#How to use

Project has been built by Spring Framework (which associate to JDBC Template - MySQL). So, it is distributed to 3 layouts:
- Controller: Receive and fire RESTFull API. Using ```@RestController``` annotation to listen request and navigate to correct business processing. Controller is assigned to process access request (attaching access permission in Header Request).

- Business - Services: This place is handling business of project. We use ```@Service``` annotation to recognize them and wire to a bean configuration.

- Repository: This layout's mission is communicating to Database and wrap data model before providing to Service. Using ```@Repository``` annotation to handle it.

- ```application.properties```: Main configuration file of project. We have set up Datasoucre connection successfully with MySQL. We can config more other if we need in the future.

- ```log4j.properties```: Configuring log file - where save all logs of system in project.

- ```pom.xml```: Configuring file manage all dependencies of projects and plugins, builds.