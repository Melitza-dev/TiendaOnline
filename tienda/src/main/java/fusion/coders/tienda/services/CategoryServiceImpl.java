package fusion.coders.tienda.services;

import fusion.coders.tienda.models.Category;
import fusion.coders.tienda.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Transactional
    @Override
    public List<Category> listar() {
        return categoryRepository.findAll();
    }

    @Transactional
    @Override
    public Category listarPorId(Long id) {
        try {
            return categoryRepository.findById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Transactional
    @Override
    public void agregar(Category category) {
        categoryRepository.create(category);
    }

    @Transactional
    @Override
    public boolean modificar(Long id, Category category) {
        Category categoryBd = categoryRepository.findById(id);

        try {
            if (categoryBd != null) {
                categoryRepository.update(id, category);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Transactional
    @Override
    public boolean elimninar(Long id) {

        try {
            Category categoryBd = categoryRepository.findById(id);
            if (categoryBd != null) {
                categoryRepository.delete(id);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
