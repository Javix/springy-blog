Spring MVC, JPA blog CRUD application
======================================

The web application using Spring MVC and JPA.

#### Used frameworks:
* Spring
* JPA/Hibernate
* Apache Tomcat 7 server

#### Database

- The project uses the H2 embedded database (see http://www.h2database.com/html/main.html for more details).
- `shema.sql` file contains the database creation script
- `test-data.sql` creates some data fixtures
- both `schema.sql` and `test-data.sql` are referenced in `app-context.xml`, **their declaration order is IMPORTANT !**

Run `mvn clean install` to download all the dependencies and initialize the project.
To run an example, use `RunPostSample` class.

To run on Tomcat server, either deploy the geenerated `war` or run the projet from your favorite IDE.
Navigate to `localhost:8080/posts`


#### TODO
- update action
- delete action
- tests

