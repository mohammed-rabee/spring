package com.example.demo.mvc.controller;

import com.example.demo.mvc.model.Product;
import com.example.demo.mvc.service.ProductService;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping( value = "" , consumes = "application/json")
    public void add (@RequestBody Product product ) throws Exception {
        productService.add(product);
    }

    @DeleteMapping ( value = "/{id}" )
    public void delete (@PathVariable int id) throws NotFoundException {
        productService.delete(id);
    }

    @PutMapping ( value = "" , consumes = "application/json")
    public void update (@RequestBody Product product) throws Exception {
        productService.update(product);
    }

    @GetMapping(value = "/{id}")
    public Product view(@PathVariable int id) throws NotFoundException {
        return productService.view(id);
    }

    @GetMapping(value = "", produces = "application/json")
    public List<Product> viewAll(){
        return productService.viewAll();

    }
}
