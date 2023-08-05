package fusion.coders.tienda.repositories;

import fusion.coders.tienda.models.Country;
import org.springframework.data.repository.CrudRepository;


public interface CountryRepository extends CrudRepository<Country, Long> {
}
