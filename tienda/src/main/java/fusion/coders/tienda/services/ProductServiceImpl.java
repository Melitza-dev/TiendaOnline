package fusion.coders.tienda.services;

import fusion.coders.tienda.models.Product;
import fusion.coders.tienda.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> Listar() {
        return null;
    }

    @Override
    public Product ListarPorId() {
        return null;
    }

    @Override
    public boolean agregar() {
        return false;
    }

    @Override
    public boolean modificar() {
        return false;
    }

    @Override
    public boolean elimninar() {
        return false;
    }
}
