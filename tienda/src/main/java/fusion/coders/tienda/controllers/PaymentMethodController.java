package fusion.coders.tienda.controllers;

import fusion.coders.tienda.models.PaymentMethod;
import fusion.coders.tienda.services.IPaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tienda_online/metodo_de_pago") //Ruta base
public class PaymentMethodController {

    @Autowired
    private IPaymentMethodService paymentMethodService;

    //Listar pais (/api/tienda_online/metodo_de_pago) GET
    @GetMapping  //@GetMapping("/") Ruta secundaria
    public List<PaymentMethod> listar() {
        return paymentMethodService.Listar();
    }

    //ListarPorId pais (/api/tienda_online/metodo_de_pago GET
    @GetMapping("/{id}")  //@GetMapping("/") Ruta secundaria
    public ResponseEntity<?> listarPorId(@PathVariable Long id) {
        Optional<PaymentMethod> paymentMethodOptional = paymentMethodService.ListarPorId(id);
        if (paymentMethodOptional.isPresent()) {
            return ResponseEntity.ok(paymentMethodOptional.orElseThrow());
        }
        //return ResponseEntity.notFound().build();
        return new ResponseEntity<>("No se encontró un Método de Pago" +
          " con ID: " + id + " no se encontró.", HttpStatus.NOT_FOUND);
    }

    //Agregar pais (/api/tienda_online/metodo_de_pago) POST
    @PostMapping
    public ResponseEntity<?> agregar(@RequestBody PaymentMethod paymentMethod) {

        return ResponseEntity
          .status(HttpStatus.CREATED)
          .body(paymentMethodService.agregar(paymentMethod));
    }

    //Actualizar pais (/api/tienda_online/metodo_de_pago) PUT
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody PaymentMethod paymentMethod) {

        if (paymentMethodService.modificar(id, paymentMethod).isPresent()) {
            return new ResponseEntity<>("El Método de Pago con ID: " + id + " se actualizó correctamente.", HttpStatus.OK);
        }
        return new ResponseEntity<>("El Método de Pago con ID: " + id + " no se pudo actualizar.", HttpStatus.NOT_MODIFIED);
    }

    //Eliminar pais (/api/tienda_online/metodo_de_pago) DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<PaymentMethod> paymentMethodOptional = paymentMethodService.ListarPorId(id);
        if (paymentMethodOptional.isPresent()) {
            paymentMethodService.elimninar(id);
            return new ResponseEntity<>("El Método de Pago con ID: " + id + " se eliminó correctamente.", HttpStatus.OK);

        }
        return new ResponseEntity<>("El Método de Pago con ID: " + id + " no existe.", HttpStatus.NOT_FOUND);
    }
}

