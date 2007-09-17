

* How to deploy a new jar file to our maven repository
mvn deploy:deploy-file -Dfile=antlr/antlr-3.0b7.jar -DgroupId=org.antlr -DartifactId=antlr -Dversion=3.0b7 -Dpackaging=jar -DrepositoryId=xerial -Durl=scp://www.xerial.org/home/web/xerial.org/maven/artifact
