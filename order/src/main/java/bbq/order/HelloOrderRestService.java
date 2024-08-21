package bbq.order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloOrderRestService {

    @GetMapping
    public String get() {
        return "Hello Order";
    }

    @GetMapping("/crash")
    public String crash() {
        if (true) throw new IllegalArgumentException("Bam!!");
        return "crash";
    }


}
