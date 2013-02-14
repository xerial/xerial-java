# xerial-java
Data managment libraries for Java. This project already has been finished, and now has moved to [Xerial for Scala](https://github.com/xerial/xerial). 
The current version 2.1 would be the final release and the source codes are kept here only for maintenance. 

## Components

* xerial-core
  * Core library without dependencies other than Java
  * Logger, OptionParser, etc.
* xerial-lens
  * Data-object mapping library
    * Object <--> xml, silk, JDBC, etc.
* xerial-silk
  * Silk text format parser and object mapper
* xerial-xml
  * XML parser and indexing library
* xerial-storage
  * Database connection management library

## Usage 
### Using with Maven

Replace the module name `xerial-core` appropriately (e.g., `xerial-lens`, `xerial-silk`, etc.)

	<dependency>
	   <groupId>org.xerial.java</groupId>
	   <artifactId>xerial-core</artifactId>
	   <version>2.1</version>
	</dependency>
	
### Using with sbt

	libraryDependencies += "org.xerial.java" % "xerial-core" % "2.1"
	
## For developers

### Building xerial-java

	bin/sbt publish-local
	
### Deploying to sonatype

	bin/sbt publish-signed
	
### Run tests
	
	bin/sbt test

	