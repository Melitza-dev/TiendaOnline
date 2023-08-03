package fusion.coders.tienda.repositories;

import fusion.coders.tienda.models.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepository {
    @PersistenceContext
    EntityManager entityManager;

    public List<Category> findAll(){
        String sql = "SELECT * FROM categories";
        return entityManager
          .createNativeQuery(sql, Category.class)
          .getResultList();
    }

    public Category findById(Long id){
        String sql = "SELECT * FROM categories WHERE id= :id";

        return (Category) entityManager
          .createNativeQuery(sql, Category.class)
          .setParameter("id", id)
          .getSingleResult();
    }

    public Category create(Category category) {
        String sql = "INSERT INTO categories (name, description) VALUES (:name, :description)";
            entityManager
              .createNativeQuery(sql, Category.class)
              .setParameter("name", category.getName())
              .setParameter("description", category.getDescription())
              .executeUpdate();
            return category;
    }


    public Long update(Long id, Category category){
        //Buscar en servicio si existe, y luego actualizar
        //Si existe hago lo sgte

        String sql = "UPDATE categories SET name= :name, description= :description " +
          "WHERE id= :id";

         entityManager
          .createNativeQuery(sql, Category.class)
          .setParameter("name", category.getName())
          .setParameter("description", category.getDescription())
           .setParameter("id",id)
          .executeUpdate();
        return id;
    }

    public void delete(Long id){
        String sql = "DELETE FROM categories WHERE id= :id";

        entityManager
          .createNativeQuery(sql, Category.class)
          .setParameter("id", id)
          .executeUpdate();
    }
}
