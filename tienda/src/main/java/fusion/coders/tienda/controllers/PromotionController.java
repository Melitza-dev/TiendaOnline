package fusion.coders.tienda.controllers;

import fusion.coders.tienda.models.Product;
import fusion.coders.tienda.models.Promotion;
import fusion.coders.tienda.services.IPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tienda_online/promocion") //Ruta base
public class PromotionController {

    @Autowired
    private IPromotionService promotionService;

    //Listar pais (/api/tienda_online/promocion) GET
    @GetMapping  //@GetMapping("/") Ruta secundaria
    public List<Promotion> listar() {
        return promotionService.Listar();
    }

    //ListarPorId pais (/api/tienda_online/promocion GET
    @GetMapping("/{id}")  //@GetMapping("/") Ruta secundaria
    public ResponseEntity<?> listarPorId(@PathVariable Long id) {
        Optional<Promotion> promotionOptional = promotionService.ListarPorId(id);
        if (promotionOptional.isPresent()) {
            return ResponseEntity.ok(promotionOptional.orElseThrow());
        }
        //return ResponseEntity.notFound().build();
        return new ResponseEntity<>("No se encontró una" +
          " Promoción con ID: " + id, HttpStatus.NOT_FOUND);
    }

    //Agregar pais (/api/tienda_online/promocion) POST
    @PostMapping
    public ResponseEntity<?> agregar(@RequestBody Promotion promotion) {

        return ResponseEntity
          .status(HttpStatus.CREATED)
          .body(promotionService.agregar(promotion));
    }

    //Actualizar pais (/api/tienda_online/promocion) PUT
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Promotion promotion) {

        if (promotionService.modificar(id, promotion).isPresent()) {
            return new ResponseEntity<>("La Promoción con ID: " + id + " se actualizó correctamente.", HttpStatus.OK);
        }
        return new ResponseEntity<>("La Promoción con ID: " + id + " no se pudo actualizar.", HttpStatus.NOT_MODIFIED);
    }

    //Eliminar pais (/api/tienda_online/promocion) DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Promotion> promotionOptional = promotionService.ListarPorId(id);
        if (promotionOptional.isPresent()) {
            promotionService.elimninar(id);
            return new ResponseEntity<>("La Promoción con ID: " + id + " se eliminó correctamente.", HttpStatus.OK);

        }
        return new ResponseEntity<>("La Promoción con ID: " + id + " no existe.", HttpStatus.NOT_FOUND);
    }
}
