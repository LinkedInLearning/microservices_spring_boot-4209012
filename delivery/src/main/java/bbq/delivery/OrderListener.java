package bbq.delivery;

import bbq.delivery.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderListener {

    private final DeliveryRepository deliveryRepository;

    public void onOrder(Order order) {
        this.deliveryRepository.addNewOrder(order);
    }
}
