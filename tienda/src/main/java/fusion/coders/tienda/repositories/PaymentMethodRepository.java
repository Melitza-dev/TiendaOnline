package fusion.coders.tienda.repositories;

import fusion.coders.tienda.models.PaymentMethod;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface PaymentMethodRepository extends CrudRepository<PaymentMethod, Long> {
}
