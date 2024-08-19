package bbq.order;

import bbq.order.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
public class OrderRestController {

    private final OrderRepository orderRepository;

    @GetMapping
    public List<Order> get() {
        return orderRepository.findAll();
    }

}
