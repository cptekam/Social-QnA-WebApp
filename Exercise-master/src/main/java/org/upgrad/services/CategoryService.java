package org.upgrad.services;

import org.upgrad.model.Category;

import java.util.List;

public interface CategoryService {
    void  createCategory(Category category);

    List <Category> getAllCategories();
}
