package fusion.coders.tienda.services;

import fusion.coders.tienda.models.Country;

import java.util.List;
import java.util.Optional;

public interface ICountryService {
    List<Country> Listar();

    Optional<Country> ListarPorId(Long id);

    Country agregar(Country country);

    Optional<Country> modificar(Long id, Country country);

    void elimninar(Long id);
}
