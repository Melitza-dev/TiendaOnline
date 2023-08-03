package fusion.coders.tienda.services;

import fusion.coders.tienda.models.Country;
import fusion.coders.tienda.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements ICountryService{
    @Autowired
    CountryRepository countryRepository;
    @Override
    public List<Country> Listar() {
        return null;
    }

    @Override
    public Country ListarPorId() {
        return null;
    }

    @Override
    public boolean agregar() {
        return false;
    }

    @Override
    public boolean modificar() {
        return false;
    }

    @Override
    public boolean elimninar() {
        return false;
    }
}
