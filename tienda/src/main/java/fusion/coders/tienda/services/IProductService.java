package fusion.coders.tienda.services;

import fusion.coders.tienda.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> Listar();
    Product ListarPorId();
    boolean agregar();
    boolean modificar();
    boolean elimninar();
}
