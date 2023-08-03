package fusion.coders.tienda.controllers;

import fusion.coders.tienda.models.Product;
import fusion.coders.tienda.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    //Listar producto (/api/tienda_online/producto) GET
    @GetMapping("/api/tienda_online/productos")
    public List<Product> listar() {
     return productServiceImpl.Listar();
    }

    //ListarPorId producto (/api/tienda_online/producto GET
    @GetMapping("/api/tienda_online/productos/{id}")
    public Product listarPorId(@PathVariable Long id){
        return productServiceImpl.ListarPorId(id);
    }

    //Agregar producto (/api/tienda_online/producto) POST
    @PostMapping("/api/tienda_online/productos")
    public String agregar(@RequestBody Product products){
        productServiceImpl.agregar(products);
        return "El producto " + products.getName() + " fue agregado exitosamente";
    }

    //Actualizar producto (/api/tienda_online/producto) PUT
    @PutMapping("/api/tienda_online/productos/{id}")
    String actualizar(@PathVariable Long id, @RequestBody Product product){
        boolean actualizado = productServiceImpl.modificar(id, product);
        if (actualizado){
            return "El producto con ID: " + id + " fue actualizado correctamente";
    }
       return "El producto con ID: " + id + " NO pudo ser actualizado, verifica si el ID existe";
    }

    //Eliminar producto (/api/tienda_online/producto) DELETE
    @DeleteMapping("/api/tienda_online/producto/{id}")
    public String eliminar(@PathVariable Long id){
        boolean eliminado = productServiceImpl.eliminar(id);
        if (eliminado){
            return "El producto con ID: " + id + " fue eliminado correctamente";
        }
        return "El producto con ID: " + id + " NO pudo ser eliminado, verifica si el ID existe";
    }
}
