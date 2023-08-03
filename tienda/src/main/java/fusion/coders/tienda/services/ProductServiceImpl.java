package fusion.coders.tienda.services;

import fusion.coders.tienda.models.Category;
import fusion.coders.tienda.models.Product;
import fusion.coders.tienda.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public abstract class ProductServiceImpl implements IProductService{
    @Autowired
    ProductRepository productRepository;

    @Transactional
    @Override
    public List<Product> Listar() {
        return productRepository.findAll();
    }

    @Transactional
    public Product ListarPorId(Long id) {
        try {
            return productRepository.findById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Transactional
    public boolean agregar(Product product) {
        productRepository.create(product);
        return false;
    }

    @Transactional
    public boolean modificar(Long id, Product product) {
        return false;
    }

    @Transactional
    public boolean eliminar(Long id) {
        try {
            Product productBd = productRepository.findById(id);
            if (productBd != null) {
                productRepository.delete(id);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

