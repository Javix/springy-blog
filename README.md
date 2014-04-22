Spring MVC, JPA CRUD blog application
---

The web application using Spring MVC and JPA.

#### Used frameworks
- Spring
- JPA/Hibernate
- Apache Tomcat 7 server

#### Database

- The project uses the H2 embedded database (see http://www.h2database.com/html/main.html for more details).
- `shema.sql` file contains the database creation script
- `test-data.sql` creates some data fixtures
- both `schema.sql` and `test-data.sql` are referenced in `app-context.xml`, **their declaration order is IMPORTANT !**

Run `mvn clean install` to download all the dependencies and initialize the project.
To run an example, use `RunPostSample` class.

To run on Tomcat server, either copy the generated `war` into webapp folder(or deploy it in a standard way)
or run the project from your favorite IDE.


#### TODO
- use partials (e.g.Tiles to DRY the views code)
- implement optimistic locking (actually commented)
- tests

