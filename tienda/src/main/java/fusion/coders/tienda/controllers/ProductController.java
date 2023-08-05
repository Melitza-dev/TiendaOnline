package fusion.coders.tienda.controllers;

import fusion.coders.tienda.models.Product;
import fusion.coders.tienda.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tienda_online/productos") //Ruta base
public class ProductController {

    @Autowired
    private IProductService productService;

    //Listar pais (/api/tienda_online/productos) GET
    @GetMapping  //@GetMapping("/") Ruta secundaria
    public List<Product> listar() {
        return productService.Listar();
    }

    //ListarPorId pais (/api/tienda_online/productos GET
    @GetMapping("/{id}")  //@GetMapping("/") Ruta secundaria
    public ResponseEntity<?> listarPorId(@PathVariable Long id) {
        Optional<Product> paymentMethodOptional = productService.ListarPorId(id);
        if (paymentMethodOptional.isPresent()) {
            return ResponseEntity.ok(paymentMethodOptional.orElseThrow());
        }
        //return ResponseEntity.notFound().build();
        return new ResponseEntity<>("No se encontró el" +
          " Producto con ID: " + id, HttpStatus.NOT_FOUND);
    }

    //Agregar pais (/api/tienda_online/productos) POST
    @PostMapping
    public ResponseEntity<?> agregar(@RequestBody Product product) {

        return ResponseEntity
          .status(HttpStatus.CREATED)
          .body(productService.agregar(product));
    }

    //Actualizar pais (/api/tienda_online/productos) PUT
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Product product) {

        if (productService.modificar(id, product).isPresent()) {
            return new ResponseEntity<>("El Producto con ID: " + id + " se actualizó correctamente.", HttpStatus.OK);
        }
        return new ResponseEntity<>("El Producto con ID: " + id + " no se pudo actualizar.", HttpStatus.NOT_MODIFIED);
    }

    //Eliminar pais (/api/tienda_online/productos) DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Product> productOptional = productService.ListarPorId(id);
        if (productOptional.isPresent()) {
            productService.elimninar(id);
            return new ResponseEntity<>("El Producto con ID: " + id + " se eliminó correctamente.", HttpStatus.OK);

        }
        return new ResponseEntity<>("El Producto con ID: " + id + " no existe.", HttpStatus.NOT_FOUND);
    }
}
