package bbq.order.config;

import bbq.order.model.Order;
import com.github.kkuegler.PermutationBasedHumanReadableIdGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class DummyOrderProducerRunner implements ApplicationRunner {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Sending dummy order for queue setup");
        var order = new Order();
        order.setId(new PermutationBasedHumanReadableIdGenerator().generate());
        rabbitTemplate.convertAndSend("orders", "",  order);
    }
}
