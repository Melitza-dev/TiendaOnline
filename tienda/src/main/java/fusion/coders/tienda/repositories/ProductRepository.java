package fusion.coders.tienda.repositories;

import fusion.coders.tienda.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
