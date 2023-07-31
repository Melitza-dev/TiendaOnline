package fusion.coders.tienda.services;

import fusion.coders.tienda.models.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> listar();
    Category listarPorId(Long id);
    void agregar(Category category);
    boolean modificar(Long id, Category category);
    boolean elimninar(Long id);


}
