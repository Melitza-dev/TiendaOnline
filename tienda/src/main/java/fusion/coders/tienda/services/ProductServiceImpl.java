package fusion.coders.tienda.services;

import fusion.coders.tienda.models.Category;
import fusion.coders.tienda.models.PaymentMethod;
import fusion.coders.tienda.models.Product;
import fusion.coders.tienda.repositories.CategoryRepository;
import fusion.coders.tienda.repositories.PaymentMethodRepository;
import fusion.coders.tienda.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Product> Listar() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> ListarPorId(Long id) {
        return productRepository.findById(id);
    }

    @Override
    @Transactional
    public Product agregar(Product product) {
        Category c = categoryRepository.findById(product.getCategory().getId());
        if (c != null) {
            product.setCategory(c);
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    @Transactional
    public Optional<Product> modificar(Long id, Product product) {

        Optional<Product> productOptional = this.ListarPorId(id);
        Category c = categoryRepository.findById(product.getCategory().getId());
        if (c != null) {
            if (productOptional.isPresent()) {
                Product productBd = productOptional.orElseThrow();
                productBd.setName(product.getName());
                productBd.setDescription(product.getDescription());
                productBd.setPrice(product.getPrice());
                productBd.setStock(product.getStock());
                productBd.setOther(product.getOther());
                productBd.setCategory(c);
                productBd.setOrder(product.getOrder());
                return Optional.of(agregar(productBd));
            }
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public void elimninar(Long id) {
        productRepository.deleteById(id);
    }
}
