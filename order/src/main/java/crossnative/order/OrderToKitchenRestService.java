package crossnative.order;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/order-to-kitchen")
@RequiredArgsConstructor
public class OrderToKitchenRestService {

    @Value("${kitchen-service.url:http://localhost:8070}")
    private String kitchenServiceUrl;

    private final RestTemplate restTemplate;

    private final RestClient restClient;

    @GetMapping
    public String get() {
        /*
        return
                restClient.get()
                .uri(kitchenServiceUrl)
                .retrieve()
                .body(String.class);
         */

        return restTemplate.getForObject(kitchenServiceUrl, String.class);
    }
}
