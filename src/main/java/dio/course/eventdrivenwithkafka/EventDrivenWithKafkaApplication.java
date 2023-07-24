package dio.course.eventdrivenwithkafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class EventDrivenWithKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventDrivenWithKafkaApplication.class, args);
    }

}
