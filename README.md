# TODO List Backend : Kotlin - DynamoDB - SpringBoot

## Generate Jar 
Requirement :
- [Maven](https://maven.apache.org/download.cgi)

Command :
- `mvn clean install -DskipDocker`

## Lauch local instance (default http://localhost:8080/)
Requirements :
- [DynamoDB](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBLocal.html)
- [Cli AWS](https://aws.amazon.com/fr/cli/) 

Commands
- `aws configure`
- `mvn -DcreateTables=true test`
- `java -jar target\test-kotlin-1.0-SNAPSHOT.jar`

