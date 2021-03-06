# Yildiz-Engine module-database.

This is the official repository of the Database Module, part of the Yildiz-Engine project.
The database module is a component meant to access and use the database.

## Features

* Mysql support.
* C3P0 pooling support.
* Model construction from physical model with JOOQ.
* ...

## Requirements

To build this module, you will need a java 8 JDK, and Maven 3.

## Coding Style and other information

Project website:
http://www.yildiz-games.be

Issue tracker:
https://yildiz.atlassian.net

Wiki:
https://yildiz.atlassian.net/wiki

Quality report:
https://sonarqube.com/overview?id=be.yildiz-games:module-database

## License

All source code files are licensed under the permissive MIT license
(http://opensource.org/licenses/MIT) unless marked differently in a particular folder/file.

## Build instructions

Go to your root directory, where you POM file is located.

Then invoke maven

	mvn clean install

This will compile the source code, then run the unit tests, and finally build a jar file.

## Usage

In your maven project, add the dependency

```xml
<dependency>
    <groupId>be.yildiz-games</groupId>
    <artifactId>module-database</artifactId>
    <version>1.2.0</version>
</dependency>
```
## Contact
Owner of this repository: Grégory Van den Borre