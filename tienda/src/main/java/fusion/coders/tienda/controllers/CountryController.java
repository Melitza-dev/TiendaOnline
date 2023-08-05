package fusion.coders.tienda.controllers;

import fusion.coders.tienda.models.Country;
import fusion.coders.tienda.services.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tienda_online/pais") //Ruta base
public class CountryController {

    @Autowired
    private ICountryService countryService;

    //Listar pais (/api/tienda_online/pais) GET
    @GetMapping  //@GetMapping("/") Ruta secundaria
    public List<Country> listar() {
        return countryService.Listar();
    }

    //ListarPorId pais (/api/tienda_online/pais GET
    @GetMapping("/{id}")  //@GetMapping("/") Ruta secundaria
    public ResponseEntity<?> listarPorId(@PathVariable Long id) {
        Optional<Country> countryOptional = countryService.ListarPorId(id);
        if (countryOptional.isPresent()) {
            return ResponseEntity.ok(countryOptional.orElseThrow());
        }
        //return ResponseEntity.notFound().build();
        return new ResponseEntity<>("No se encontro un" +
          " país con ID: " + id, HttpStatus.NOT_FOUND);
    }

    //Agregar pais (/api/tienda_online/pais) POST
    @PostMapping
    public ResponseEntity<?> agregar(@RequestBody Country country) {

        return ResponseEntity
          .status(HttpStatus.CREATED)
          .body(countryService.agregar(country));
    }

    //Actualizar pais (/api/tienda_online/pais) PUT
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Country country) {

        if (countryService.modificar(id, country).isPresent()) {
            return new ResponseEntity<>("El país con ID: " + id + " se actualizó correctamente.", HttpStatus.OK);
        }
        return new ResponseEntity<>("El país con ID: " + id + " no se pudo actualizar.", HttpStatus.NOT_MODIFIED);
    }

    //Eliminar pais (/api/tienda_online/pais) DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Country> countryOptional = countryService.ListarPorId(id);
        if (countryOptional.isPresent()) {
            countryService.elimninar(id);
            return new ResponseEntity<>("El país con ID: " + id + " se eliminó correctamente.", HttpStatus.OK);

        }
        return new ResponseEntity<>("El país con ID: " + id + " no existe.", HttpStatus.NOT_FOUND);
    }
}

