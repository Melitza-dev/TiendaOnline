package fusion.coders.tienda.controllers;

import fusion.coders.tienda.models.Category;
import fusion.coders.tienda.services.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;


    //Listar categorias (/api/tienda_online/categoria) GET
   @GetMapping("/api/tienda_online/categoria")
    public List<Category> listar(){
        return categoryServiceImpl.listar();
    }

    //ListarPorId categorias (/api/tienda_online/categoria/{1}) GET
    @GetMapping("/api/tienda_online/categoria/{id}")
    public Category listarporId(@PathVariable Long id){
        return categoryServiceImpl.listarPorId(id);
    }


    //Agregar categorias (/api/tienda_online/categoria) POST
    @PostMapping("/api/tienda_online/categoria")
    public String agregar(@RequestBody Category categoria){
        categoryServiceImpl.agregar(categoria);
        return "La categoría " + categoria.getName() +" fué agregada exitosamente";
    }


    //Modificar categorias (/api/tienda_online/categoria/{1}) PUT
    @PutMapping("/api/tienda_online/categoria/{id}")
    public String modificar(@RequestBody Category categoria, @PathVariable Long id){
        boolean modificado = categoryServiceImpl.modificar(id, categoria);
        if(modificado){
            return "La categoría con ID: " + id + " fué modificada exitosamente";
        }
        return "La categoría con ID: " + id + " NO pudo ser modificada, verifica si el ID existe";
    }


    //Eliminar categorias (/api/tienda_online/categoria/{1}) DELETE
    @DeleteMapping("/api/tienda_online/categoria/{id}")
    public String eliminar(@PathVariable Long id){
        boolean eliminado = categoryServiceImpl.elimninar(id);
        if(eliminado){
            return "La categoría con ID: " + id + " fué eliminada exitosamente";
        }
        return "La categoría con ID: " + id + " NO pudo ser eliminada, verifica si el ID existe";
    }

}
