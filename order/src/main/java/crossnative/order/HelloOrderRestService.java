package crossnative.order;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class HelloOrderRestService {

    @Value("${order.greeting:Hello Order}")
    private String greeting;

    @GetMapping
    public String get() {
        return greeting;
    }


}
