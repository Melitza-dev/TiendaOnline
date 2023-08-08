package fusion.coders.tienda.controllers;

import fusion.coders.tienda.models.User;
import fusion.coders.tienda.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/tienda_online/usuario") //Ruta base
public class UserController {

    @Autowired
    private IUserService userService;

    //Listar pais (/api/tienda_online/usuario) GET
    @GetMapping  //@GetMapping("/") Ruta secundaria
    public List<User> listar() {
        return userService.Listar();
    }

    //ListarPorId pais (/api/tienda_online/usuario GET
    @GetMapping("/{id}")  //@GetMapping("/") Ruta secundaria
    public ResponseEntity<?> listarPorId(@PathVariable Long id) {
        Optional<User> userOptional = userService.ListarPorId(id);
        if (userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.orElseThrow());
        }
        //return ResponseEntity.notFound().build();
        return new ResponseEntity<>("No se encontró un" +
          " Usuario con ID: " + id, HttpStatus.NOT_FOUND);
    }

    //Agregar pais (/api/tienda_online/usuario) POST
    @PostMapping
    public ResponseEntity<?> agregar(@RequestBody User user) {
        return ResponseEntity
          .status(HttpStatus.CREATED)
          .body(userService.agregar(user));
    }

    //Actualizar pais (/api/tienda_online/usuario) PUT
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody User user) {

        if (userService.modificar(id, user).isPresent()) {
            return new ResponseEntity<>("El Usuario con ID: " + id + " se actualizó correctamente.", HttpStatus.OK);
        }
        return new ResponseEntity<>("El Usuario con ID: " + id + " no se pudo actualizar.", HttpStatus.NOT_MODIFIED);
    }

    //Eliminar pais (/api/tienda_online/usuario) DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<User> userOptional = userService.ListarPorId(id);
        if (userOptional.isPresent()) {
            userService.elimninar(id);
            return new ResponseEntity<>("El Usuario con ID: " + id + " se eliminó correctamente.", HttpStatus.OK);

        }
        return new ResponseEntity<>("El Usuario con ID: " + id + " no existe.", HttpStatus.NOT_FOUND);
    }
}