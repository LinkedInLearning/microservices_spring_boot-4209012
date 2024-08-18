package bbq.order;

import bbq.order.model.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderKafkaPublisher {

    private final KafkaTemplate<String, Order> kafkaTemplate;

    @TransactionalEventListener
    public void handleEvent(Order orderEvent) {
        kafkaTemplate.send("orders", orderEvent);
    }

}
