# Test application to test springboot apps using thin jars

This repository shows an example application called _copland_ with a _'/'_ endpoint that returns a Greeting.
The project was originally created using _Spring boot_ starters.

# Requirements

* Maven >= 3.3.9
* Java version: 1.8.0_201, vendor: Oracle Corporation

# Building a Thin jar

In order to build a thin jar you may take a look to the following documentation:

* [Spring thin launcher jar repository](https://github.com/spring-projects-experimental/spring-boot-thin-launcher)
* [Baeldung tutorial for thin jars](https://www.baeldung.com/spring-boot-thin-jar)

In short you should add the following configuration to your pom.xml. The _dependencies_ configuration is the one that enables thin jar building. 

```
      <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
        <dependencies>
          <dependency>
            <groupId>org.springframework.boot.experimental</groupId>
            <artifactId>spring-boot-thin-layout</artifactId>
            <version>${wrapper.version}</version>
          </dependency>
        </dependencies>
      </plugin>
```

## Downloading dependencies

You may configure your project to download the jar dependencies to a specific folder, which is _/target/thin_ by default.
In order to do so, you should add the following plugin configuration to your pom.xml

```
      <plugin>
        <groupId>org.springframework.boot.experimental</groupId>
        <artifactId>spring-boot-thin-maven-plugin</artifactId>
        <version>${wrapper.version}</version>
        <executions>
          <execution>
            <id>resolve</id>
            <goals>
              <goal>resolve</goal>
            </goals>
            <inherited>false</inherited>
          </execution>
        </executions>
      </plugin>
```

# Running the application

Once compiled you will find a _target/thin/root_ along with your copland-0.0.1-SNAPSHOT.jar .

Run the application would be as simple as:

1. Copy both: the _target/thin_ folder and the _jar_ file to a server or machine with Java 8.
2. Run the following command: _java -jar copland-0.0.1-SNAPSHOT.jar --thin.root=thin/root_

This will show the following output:

```
$ java -jar copland-0.0.1-SNAPSHOT.jar --thin.root=thin/root

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.1.RELEASE)

2019-11-20 09:19:34.539  INFO 14589 --- [           main] c.a.copland.CoplandApplication           : Starting CoplandApplication v0.0.1-SNAPSHOT on ip-10-185-73-69.eu-west-1.compute.internal.node.iacaws.discovery with PID 14589 (/home/centos/copland-0.0.1-SNAPSHOT.jar started by centos in /home/centos)
2019-11-20 09:19:34.543  INFO 14589 --- [           main] c.a.copland.CoplandApplication           : No active profile set, falling back to default profiles: default
2019-11-20 09:19:35.764  INFO 14589 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2019-11-20 09:19:35.777  INFO 14589 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2019-11-20 09:19:35.778  INFO 14589 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.27]
2019-11-20 09:19:35.856  INFO 14589 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2019-11-20 09:19:35.856  INFO 14589 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 1262 ms
2019-11-20 09:19:36.060  INFO 14589 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2019-11-20 09:19:36.241  INFO 14589 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2019-11-20 09:19:36.249  INFO 14589 --- [           main] c.a.copland.CoplandApplication           : Started CoplandApplication in 2.716 seconds (JVM running for 5.058)
2019-11-20 09:19:37.972  INFO 14589 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2019-11-20 09:19:37.972  INFO 14589 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2019-11-20 09:19:37.980  INFO 14589 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 8 ms
```
