package bbq.order;

import bbq.order.model.Order;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderRabbitMQPublisher {

    private final RabbitTemplate rabbitTemplate;

    @PostConstruct
    protected void init() {
        // Transaction Support
        rabbitTemplate.setChannelTransacted(true);
    }

    void publish(Order order) {
        rabbitTemplate.convertAndSend("orders", "",  order);
    }

}
