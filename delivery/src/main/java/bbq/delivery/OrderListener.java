package bbq.delivery;

import bbq.delivery.model.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderListener {

    private final DeliveryRepository deliveryRepository;

    @RetryableTopic(attempts = "2")
    @KafkaListener(topics = "orders", groupId = "delivery", properties = { "spring.json.value.default.type=bbq.delivery.model.Order"})
    public void onOrder(Order order) {
       // throw new RuntimeException("Bam!");
     log.info("receive order: {}", order);
     deliveryRepository.addNewOrder(order);
    }

    @DltHandler
    public void dltListener(
            ConsumerRecord<String, String> message,
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic
    ) {
        log.info("DLT Message Received - key: {} , value: {}, at: {}", message.key(), message.value(), LocalDateTime.now());
    }
}
