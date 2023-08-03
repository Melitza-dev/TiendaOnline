package fusion.coders.tienda.repositories;

import fusion.coders.tienda.models.Category;
import fusion.coders.tienda.models.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Product> findAll(){
        String sql = "SELECT * FROM products";
        return entityManager
                .createNativeQuery(sql, Product.class)
                .getResultList();
    }

    public Product findById(Long id){
        String sql = "SELECT * FROM products WHERE id= :id";

        return (Product) entityManager
                .createNativeQuery(sql, Product.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public Product create(Product product){
        String sql = "INSERT INTO categories (name, description) VALUES (:name, :description, :stoke, :price, :other )";
        entityManager
                .createNativeQuery(sql, Product.class)
                .setParameter("name", product.getName())
                .setParameter("description", product.getDescription())
                .setParameter("stoke", product.getStock())
                .setParameter("price", product.getPrice())
                .setParameter("other", product.getOther())
                .executeUpdate();
        return product;
    }

    public Long update(Long id, Product product){
        String sql = "UPDATE products SET name= :name, description= :description, stoke= :stoke, price= :price, other= :other"
                + "WHERE id= :id";
        entityManager
                .createNativeQuery(sql, Product.class)
                .setParameter("name", product.getName())
                .setParameter("description", product.getDescription())
                .setParameter("stoke", product.getStock())
                .setParameter("price", product.getPrice())
                .setParameter("other", product.getOther())
                .setParameter("id", id)
                .executeUpdate();
        return id;
    }

   public void delete(Long id){
        String sql = "DELETE FROM products WHERE id= :id";
        entityManager
                .createNativeQuery(sql,Product.class)
                .setParameter("id", id)
                .executeUpdate();
   }

}
