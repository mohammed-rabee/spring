package com.example.demo.mvc.controller;

import com.example.demo.mvc.model.Category;
import com.example.demo.mvc.service.CategoryService;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping ( value = "/{id}" )
    public Category view (@PathVariable int id) throws NotFoundException {
        return categoryService.view(id);
    }

    @GetMapping (value = "")
    public List<Category> viewAll() {
        return categoryService.viewAll();
    }
}
