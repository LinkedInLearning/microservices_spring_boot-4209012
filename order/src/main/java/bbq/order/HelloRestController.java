package bbq.order;

import com.github.kkuegler.HumanReadableIdGenerator;
import com.github.kkuegler.PermutationBasedHumanReadableIdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class HelloRestController {

    private final HumanReadableIdGenerator idGenerator = new PermutationBasedHumanReadableIdGenerator();

    @GetMapping
    public String get() {
        return "Hello Order!";
    }

}
