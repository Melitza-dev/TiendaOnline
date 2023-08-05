package fusion.coders.tienda.controllers;

import fusion.coders.tienda.models.ShippingType;
import fusion.coders.tienda.models.User;
import fusion.coders.tienda.services.IShippingTypeService;
import fusion.coders.tienda.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/tienda_online/tipo_de_envio") //Ruta base
public class ShippingTypeController {

    @Autowired
    private IShippingTypeService shippingTypeService;

    //Listar pais (/api/tienda_online/tipo_de_envio) GET
    @GetMapping  //@GetMapping("/") Ruta secundaria
    public List<ShippingType> listar() {
        return shippingTypeService.Listar();
    }

    //ListarPorId pais (/api/tienda_online/usuario GET
    @GetMapping("/{id}")  //@GetMapping("/") Ruta secundaria
    public ResponseEntity<?> listarPorId(@PathVariable Long id) {
        Optional<ShippingType> shippingTypeOptional = shippingTypeService.ListarPorId(id);
        if (shippingTypeOptional.isPresent()) {
            return ResponseEntity.ok(shippingTypeOptional.orElseThrow());
        }
        //return ResponseEntity.notFound().build();
        return new ResponseEntity<>("No se encontró un" +
          " el Tipo de Envío con ID: " + id, HttpStatus.NOT_FOUND);
    }

    //Agregar pais (/api/tienda_online/tipo_de_envio) POST
    @PostMapping
    public ResponseEntity<?> agregar(@RequestBody ShippingType shippingType) {

        return ResponseEntity
          .status(HttpStatus.CREATED)
          .body(shippingTypeService.agregar(shippingType));
    }

    //Actualizar pais (/api/tienda_online/tipo_de_envio) PUT
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody ShippingType shippingType) {

        if (shippingTypeService.modificar(id, shippingType).isPresent()) {
            return new ResponseEntity<>("El Tipo de Envío con ID: " + id + " se actualizó correctamente.", HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }

    //Eliminar pais (/api/tienda_online/tipo_de_envio) DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<ShippingType> shippingTypeOptional = shippingTypeService.ListarPorId(id);
        if (shippingTypeOptional.isPresent()) {
            shippingTypeService.elimninar(id);
            return new ResponseEntity<>("El Tipo de Envío con ID: " + id + " se eliminó correctamente.", HttpStatus.OK);

        }
        return new ResponseEntity<>("El Tipo de Envío con ID: " + id + " no existe.", HttpStatus.NOT_FOUND);
    }
}