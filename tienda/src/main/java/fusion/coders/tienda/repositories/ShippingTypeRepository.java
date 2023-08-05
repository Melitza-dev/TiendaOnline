package fusion.coders.tienda.repositories;

import fusion.coders.tienda.models.ShippingType;
import fusion.coders.tienda.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ShippingTypeRepository extends CrudRepository<ShippingType, Long> {
}
