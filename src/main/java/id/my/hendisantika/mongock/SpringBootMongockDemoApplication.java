package id.my.hendisantika.mongock;

import com.github.cloudyrock.spring.v5.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableMongock
@SpringBootApplication
public class SpringBootMongockDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMongockDemoApplication.class, args);
    }

}
