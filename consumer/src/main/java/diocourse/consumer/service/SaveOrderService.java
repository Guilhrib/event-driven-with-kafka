package diocourse.consumer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import diocourse.consumer.data.OrderData;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SaveOrderService {
    @KafkaListener(topics = "SaveOrder", groupId = "SaveOrderMicroService")
    private void execute(ConsumerRecord<String, String> record) {
        log.info("Key = {}", record.key());
        log.info("Header = {}", record.headers());
        log.info("Partition = {}", record.partition());

        String data = record.value();

        ObjectMapper mapper = new ObjectMapper();
        OrderData orderData = null;

        try {
            orderData = mapper.readValue(data, OrderData.class);
        } catch (JsonProcessingException ex) {
            log.error("Error converting event [data]={}]", data, ex);
        }

        log.info("Event received = {}", orderData);
    }
}
