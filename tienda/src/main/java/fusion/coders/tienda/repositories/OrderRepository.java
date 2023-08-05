package fusion.coders.tienda.repositories;

import fusion.coders.tienda.models.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
