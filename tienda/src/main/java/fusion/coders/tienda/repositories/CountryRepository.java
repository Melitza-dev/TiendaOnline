package fusion.coders.tienda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import fusion.coders.tienda.models.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {
    // Puedes definir métodos de consulta personalizados si es necesario
}