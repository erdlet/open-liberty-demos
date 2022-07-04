# Open Liberty samples

In this repository I want to implement a simple web application using different technologies for accessing the application (UI, HTTP API, ...). It uses the `jakarta.*` namespace.

## Maven modules

### common

Contains the `data model`, `data access layer` and `service layer` for the following application modules. Also it provides security and logging as far as possible.

Logging will be handled by Java Util Logging (JUL) and SLF4J as facade, because the application doesn't need a fine logging concept. Using the console should be enough.

From a security point of view, the applications should be able to determine if a person is logged in and has the correct rights for performing actions on / viewing resources. For simplicity, there is only a `user`, `admin` and anonymous role.

### liberty-jsf

This module contains an application using JSF as frontend technology.

### liberty-mvc

 This module contains an application using Jakarta MVC as frontend technology.
 
### liberty-rest

This module contains an application using Jakarta REST for making the data accessible.
