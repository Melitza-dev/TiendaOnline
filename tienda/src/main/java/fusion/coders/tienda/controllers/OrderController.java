package fusion.coders.tienda.controllers;

import fusion.coders.tienda.models.Order;
import fusion.coders.tienda.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/tienda_online/orden_de_compra") //Ruta base
public class OrderController {

    @Autowired
    private IOrderService orderService;

    //Listar pais (/api/tienda_online/orden_de_compra) GET
    @GetMapping  //@GetMapping("/") Ruta secundaria
    public List<Order> listar() {
        return orderService.Listar();
    }

    //ListarPorId pais (/api/tienda_online/orden_de_compra GET
    @GetMapping("/{id}")  //@GetMapping("/") Ruta secundaria
    public ResponseEntity<?> listarPorId(@PathVariable Long id) {
        Optional<Order> orderOptional = orderService.ListarPorId(id);
        if (orderOptional.isPresent()) {
            return ResponseEntity.ok(orderOptional.orElseThrow());
        }
        //return ResponseEntity.notFound().build();
        return new ResponseEntity<>("No se encontró una" +
          " Orden de Compra con ID: " + id, HttpStatus.NOT_FOUND);
    }

    //Agregar pais (/api/tienda_online/orden_de_compra) POST
    @PostMapping
    public ResponseEntity<?> agregar(@RequestBody Order order) {

        return ResponseEntity
          .status(HttpStatus.CREATED)
          .body(orderService.agregar(order));
    }

    //Actualizar pais (/api/tienda_online/orden_de_compra) PUT
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Order order) {

        if (orderService.modificar(id, order).isPresent()) {
            return new ResponseEntity<>("La Orden de Compra con ID: " + id + " se actualizó correctamente.", HttpStatus.OK);
        }
        return new ResponseEntity<>("La Orden de Compra con ID: " + id + " no se pudo actualizar.", HttpStatus.NOT_MODIFIED);
    }

    //Eliminar pais (/api/tienda_online/orden_de_compra) DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Order> orderOptional = orderService.ListarPorId(id);
        if (orderOptional.isPresent()) {
            orderService.elimninar(id);
            return new ResponseEntity<>("La Orden de Compra con ID: " + id + " se eliminó correctamente.", HttpStatus.OK);

        }
        return new ResponseEntity<>("La Orden de Compra con ID: " + id + " no existe.", HttpStatus.NOT_FOUND);
    }
}

