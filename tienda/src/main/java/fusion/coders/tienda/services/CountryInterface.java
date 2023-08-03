package fusion.coders.tienda.services;
import fusion.coders.tienda.models.Country;

import java.util.List;

public interface CountryInterface {
    void agregar(Country country);
    void modificar(Country country);
    void eliminar(Long id);
    Country get(Long id);
    List<Country> getAll();
}
