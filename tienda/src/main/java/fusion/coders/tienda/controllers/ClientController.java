package fusion.coders.tienda.controllers;

import fusion.coders.tienda.models.Client;
import fusion.coders.tienda.services.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientServiceImpl clientServiceImpl;


    //Listar categorias (/api/tienda_online/cliente) GET
    @GetMapping("/api/tienda_online/cliente")
    public List<Client> listar(){
        return clientServiceImpl.listar();
    }

    //ListarPorId categorias (/api/tienda_online/cliente/{1}) GET
    @GetMapping("/api/tienda_online/cliente/{id}")
    public Client listarPorId(@PathVariable Long id){
        return clientServiceImpl.listarPorId(id);
    }


    //Agregar categorias (/api/tienda_online/cliente) POST
    @PostMapping("/api/tienda_online/cliente")
    public String agregar(@RequestBody Client client){
        clientServiceImpl.agregar(client);
        return "El cliente " + client.getName() +" fué agregado exitosamente";
    }


    //Modificar categorias (/api/tienda_online/cliente/{1}) PUT
    @PutMapping("/api/tienda_online/cliente/{id}")
    public String modificar(@RequestBody Client client, @PathVariable Long id){
        boolean modificado = clientServiceImpl.modificar(id, client);
        if(modificado){
            return "El cliente con ID: " + id + " fué modificado exitosamente";
        }
        return "El cliente con ID: " + id + " NO pudo ser modificado, verifica si el ID existe";
    }


    //Eliminar categorias (/api/tienda_online/cliente/{1}) DELETE
    @DeleteMapping("/api/tienda_online/cliente/{id}")
    public String eliminar(@PathVariable Long id){
        boolean eliminado = clientServiceImpl.elimninar(id);
        if(eliminado){
            return "El cliente con ID: " + id + " fué eliminado exitosamente";
        }
        return "El cliente con ID: " + id + " NO pudo ser eliminado, verifica si el ID existe";
    }

}

