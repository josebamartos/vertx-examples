# vertx-examples
Vert.x examples for reactive microservices

## Example projects
| Language | Name                                                                                          | Description         |
|:-------- |:--------------------------------------------------------------------------------------------- |:------------------- |
| Java     | [minimal-project](https://github.com/josebamartos/vertx-examples/tree/master/minimal-project) | Minimal project     |
| Java     | [rest-server](https://github.com/josebamartos/vertx-examples/tree/master/rest-server)         | REST server project |

## Running examples

Run appication:

```
$ mvn clean install vertx:run
```
Build uber jar and run application:

```
$ mvn clean package
$ java -jar target/application.jar
```
