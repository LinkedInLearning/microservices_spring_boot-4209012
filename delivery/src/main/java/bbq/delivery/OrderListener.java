package bbq.delivery;

import bbq.delivery.model.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderListener {

    private final DeliveryRepository deliveryRepository;

    @RabbitListener(queues = "delivery.orders")
    public void onOrder(Order order) {
     //   throw new AmqpRejectAndDontRequeueException("over");
       // throw new RuntimeException("Order delivery failed");
     log.info("receive order: {}", order);
     deliveryRepository.addNewOrder(order);
    }
}
