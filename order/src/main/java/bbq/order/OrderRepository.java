package bbq.order;

import bbq.order.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, String> {


}
