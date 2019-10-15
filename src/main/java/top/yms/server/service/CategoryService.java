package top.yms.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yms.server.dao.CategoryMapper;
import top.yms.server.entity.Category;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public Category findOne(long id) {
        return categoryMapper.findOne(id);
    }

    public Category findByCategoryName(String categoryName) {
        return categoryMapper.findByCategoryName(categoryName);
    }

    public List<Category> findAll() {
        return categoryMapper.findAll();
    }

    public int add(Category category) {
        return categoryMapper.add(category.getId(),category.getCategoryName(),category.getCreatedTime());
    }


    public int delete() {
        return 1;
    }

    public int update(Category category) {
        return categoryMapper.update(category.getCategoryName(),category.getCreatedTime(),category.getId());
    }

}
