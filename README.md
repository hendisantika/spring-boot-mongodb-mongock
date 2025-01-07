# Spring Boot with MongoDB and Mongock

### Things to do list:

1. Clone this repository: `git clone https://github.com/hendisantika/spring-boot-mongodb-mongock.git'
2. Go to the folder: `cd spring-boot-mongodb-mongock`
3. Run the application: `mvn clean spring-boot:run`
4. Open your favorite browser: http://localhost:8080/api/expenses
5. Check the console logs
6. Enjoy the result!

### Console Logs

```shell
2025-01-07T10:47:49.702+07:00  INFO 44992 --- [spring-boot-mongock-demo] [127.0.0.1:27017] org.mongodb.driver.cluster               : Monitor thread successfully connected to server with description ServerDescription{address=127.0.0.1:27017, type=STANDALONE, cryptd=false, state=CONNECTED, ok=true, minWireVersion=0, maxWireVersion=25, maxDocumentSize=16777216, logicalSessionTimeoutMinutes=30, roundTripTimeNanos=8522958, minRoundTripTimeNanos=0}
2025-01-07T10:47:49.754+07:00  INFO 44992 --- [spring-boot-mongock-demo] [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
2025-01-07T10:47:50.050+07:00  INFO 44992 --- [spring-boot-mongock-demo] [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
2025-01-07T10:47:50.054+07:00  INFO 44992 --- [spring-boot-mongock-demo] [  restartedMain] i.m.h.m.SpringBootMongockDemoApplication : Started SpringBootMongockDemoApplication in 3.307 seconds (process running for 3.604)
2025-01-07T10:47:50.087+07:00  INFO 44992 --- [spring-boot-mongock-demo] [  restartedMain] c.g.c.m.r.c.executor.MigrationExecutor   : Mongock skipping the data migration. All change set items are already executed or there is no change set item.
2025-01-07T10:47:50.087+07:00  INFO 44992 --- [spring-boot-mongock-demo] [  restartedMain] c.g.c.m.d.core.lock.DefaultLockManager   : Mongock releasing the lock
2025-01-07T10:47:50.094+07:00  INFO 44992 --- [spring-boot-mongock-demo] [  restartedMain] c.g.c.m.d.core.lock.DefaultLockManager   : Mongock released the lock
2025-01-07T10:47:50.094+07:00  INFO 44992 --- [spring-boot-mongock-demo] [  restartedMain] c.g.c.m.r.c.executor.MigrationExecutor   : Mongock has finished

```
