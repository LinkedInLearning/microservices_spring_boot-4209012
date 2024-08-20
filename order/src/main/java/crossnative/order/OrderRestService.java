package crossnative.order;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/order")
public class OrderRestService {

    @Value("${delivery-service.url:http://localhost:8070}")
    private String kitchenServiceUrl;

    private final RestTemplate restTemplate;

    private final Counter orderCounter;

    public OrderRestService(MeterRegistry registry, RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

        this.orderCounter = Counter.builder("orders.placed")
                .description("Number of orders placed")
                .register(registry);
    }

    @PostMapping
    public Map<String, String> post(@RequestBody Order order) {
            return Map.of("orderId",  UUID.randomUUID().toString());
    }
}
