package bbq.order;

import bbq.order.model.Order;
import com.github.kkuegler.HumanReadableIdGenerator;
import com.github.kkuegler.PermutationBasedHumanReadableIdGenerator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderRestController {

    private final OrderKafkaPublisher publisher;

    private final OrderRepository orderRepository;

    private final HumanReadableIdGenerator idGenerator = new PermutationBasedHumanReadableIdGenerator();


    @GetMapping
    public Iterable<Order> getOrders() {
        return orderRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public Order post(@RequestBody Order order) {
        // 1. Save Order
        order.setId(idGenerator.generate());
        var savedOrder = orderRepository.save(order);

        // 2. Publish order
        publisher.publish(savedOrder);

        //if (true) throw new RuntimeException("Crash!!");

        // 3. Return order
        return savedOrder;
    }
}
