package fusion.coders.tienda.services;

import fusion.coders.tienda.models.Country;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@Service
public class CountryService implements CountryInterface {


    public void agregar(Country country) {
        if (country.getTitulo().equals("")) {
            return;
        }

        // Llamar a la base de datos
    }

    public void modificar(Country country) {
        // funcionalidad para modificar a la bases de datos
    }

    public void eliminar(Long id) {
        // funcionalidad para eliminar a la bases de datos
    }

    public Country get(Long id) {
        return null;
    }

    public List<Country> getAll() {
        return null;
    }

}


