package fusion.coders.tienda.services;

import fusion.coders.tienda.models.PaymentMethod;
import fusion.coders.tienda.models.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> Listar();

    Optional<Product> ListarPorId(Long id);

    Product agregar(Product product);

    Optional<Product> modificar(Long id, Product product);

    void elimninar(Long id);
}
