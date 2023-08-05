package fusion.coders.tienda.repositories;

import fusion.coders.tienda.models.Promotion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface PromotionRepository extends CrudRepository<Promotion, Long> {
}
