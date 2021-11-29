package code_space.service.impl;
import code_space.domain.Category;
import code_space.dao.CategoryDao;
import code_space.dao.impl.CategoryDaoImpl;
import code_space.service.CategoryService;
import java.util.List;
public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao = new CategoryDaoImpl();
    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }
}

