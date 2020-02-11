package com.example.demo.mvc.service;

import com.example.demo.mvc.model.Category;
import com.example.demo.mvc.repository.CategoryRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSException;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category view (int id) throws NotFoundException {
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isPresent())
            return category.get();
        else
            throw new NotFoundException("No category with this ID");
    }

    public List<Category> viewAll () {
        return categoryRepository.findAll();
    }
}
