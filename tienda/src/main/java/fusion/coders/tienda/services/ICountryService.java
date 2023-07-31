package fusion.coders.tienda.services;

import fusion.coders.tienda.models.Country;

import java.util.List;

public interface ICountryService {
    List<Country> Listar();
    Country ListarPorId();
    boolean agregar();
    boolean modificar();
    boolean elimninar();
}
