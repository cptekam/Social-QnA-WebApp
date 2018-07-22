package org.upgrad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.upgrad.model.Category;
import org.upgrad.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void createCategory(Category category) {
        categoryRepository.addCategory ( category.getTitle (), category.getDescription () );

    }

    @Override
    public List <Category> getAllCategories() {
        return categoryRepository.getAllCategories ();
    }

}