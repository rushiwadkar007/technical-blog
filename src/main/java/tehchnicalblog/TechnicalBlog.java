package tehchnicalblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class TechnicalBlog {
    public static void main(String[] args) {
        SpringApplication.run(TechnicalBlog.class, args);
    }
}
/*
JDBC API-
JDBC stands for Java Database Connectivity
It's an API provided by the Java.
We can use this API to obtain a connection to the data base and execute some queries on the database.

JDBC
JDBC to enable the flow of instructions and information between the application
and the database, the application needs to be connected to the database.

Database and application itself are incompatible interfaces and cannot interact
directly so we use database drives to address this issue.

We have individual drivers for difference database softwares

Data base drivers help us to connect a generic interface to a specific database.
it translates the instruction and inforamtion so that both application and the database can understand.

Database driver is nothing but a JDBC driver.

*/