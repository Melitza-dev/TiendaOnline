package fusion.coders.tienda.controllers;

import fusion.coders.tienda.models.Shipment;
import fusion.coders.tienda.services.IShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tienda_online/envio") //Ruta base
public class ShipmentController {

    @Autowired
    private IShipmentService shipmentService;

    //Listar pais (/api/tienda_online/envio) GET
    @GetMapping  //@GetMapping("/") Ruta secundaria
    public List<Shipment> listar() {
        return shipmentService.Listar();
    }

    //ListarPorId pais (/api/tienda_online/envio GET
    @GetMapping("/{id}")  //@GetMapping("/") Ruta secundaria
    public ResponseEntity<?> listarPorId(@PathVariable Long id) {
        Optional<Shipment> shipmentOptional = shipmentService.ListarPorId(id);
        if (shipmentOptional.isPresent()) {
            return ResponseEntity.ok(shipmentOptional.orElseThrow());
        }
        //return ResponseEntity.notFound().build();
        return new ResponseEntity<>("No se encontró un" +
          " Envío con ID: " + id, HttpStatus.NOT_FOUND);
    }

    //Agregar pais (/api/tienda_online/envio) POST
    @PostMapping
    public ResponseEntity<?> agregar(@RequestBody Shipment shipment) {

        return ResponseEntity
          .status(HttpStatus.CREATED)
          .body(shipmentService.agregar(shipment));
    }

    //Actualizar pais (/api/tienda_online/envio) PUT
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Shipment shipment) {

        if (shipmentService.modificar(id, shipment).isPresent()) {
            return new ResponseEntity<>("El Envío con ID: " + id + " se actualizó correctamente.", HttpStatus.OK);
        }
        return new ResponseEntity<>("El Envío con ID: " + id + " no se pudo actualizar.", HttpStatus.NOT_MODIFIED);
    }

    //Eliminar pais (/api/tienda_online/envio) DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Shipment> shipmentOptional = shipmentService.ListarPorId(id);
        if (shipmentOptional.isPresent()) {
            shipmentService.elimninar(id);
            return new ResponseEntity<>("El Envío con ID: " + id + " se eliminó correctamente.", HttpStatus.OK);

        }
        return new ResponseEntity<>("El Envío con ID: " + id + " no existe.", HttpStatus.NOT_FOUND);
    }
}
