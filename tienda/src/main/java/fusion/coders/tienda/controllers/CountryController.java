package fusion.coders.tienda.controllers;
import fusion.coders.tienda.models.Country;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CountryController {
    @PostMapping("/api/country")
    public void agregar(@RequestBody Country country) {
        // funcionalidad para agregar a la bases de datos
    }

    @PutMapping("/api/country/{id}")
    public void modificar(@RequestBody Country country, @PathVariable("id") Long id) {
        // funcionalidad para modificar a la bases de datos
    }

    @DeleteMapping("/api/country/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        // funcionalidad para eliminar a la bases de datos
    }

    @GetMapping("/api/country/{id}")
    public Country get(@PathVariable("id") Long id) {
        Country country = new Country();
        country.setId(1L);
        country.setNombre("Madrid");
        return country;
    }

    @GetMapping("/api/country")
    public List<Country> getAll() {
        List<Country> lista = new ArrayList<>();
        Country country = new Country();
        country.setId(1L);
        country.setNombre("Madrid");


        Country country2 = new Country();
        country2.setId(1L);
        country2.setNombre("Valencia");
        lista.add(country);
        lista.add(country2);
        return lista;
    }

}
