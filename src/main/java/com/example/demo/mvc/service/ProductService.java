package com.example.demo.mvc.service;

import com.example.demo.mvc.repository.ProductRepository;
import com.example.demo.mvc.model.Product;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    ProductRepository productRepository;

    public void add(Product product) throws Exception {

        Optional<Product> oldProduct = productRepository.findById(product.getId());

        if (oldProduct.isPresent()) {
            throw new Exception("Product already there");
        } else {
            productRepository.saveAndFlush(product);
        }
    }

    public void delete (int id) throws NotFoundException {

        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {
            productRepository.deleteById(id);
        } else {
            throw new NotFoundException("No such Product to delete");
        }
    }

    public void update (Product product) throws Exception {
        Optional<Product> oldProduct = productRepository.findById(product.getId());
        if (oldProduct.isPresent()) {
            Product newProduct = oldProduct.get();
            newProduct.setName(product.getName());
            newProduct.setDescription(product.getDescription());
            newProduct.setCategory(product.getCategory());
            newProduct.setCreateDate(product.getCreateDate());
            productRepository.saveAndFlush(newProduct);
        } else {
            throw new NotFoundException("Product not exist");
        }

    }

    public Product view (int id) throws NotFoundException {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        } else {
            throw new NotFoundException("Nothing to View please recheck the product Id");
        }
    }

    public List<Product> viewAll () {
        return productRepository.findAll();
    }
}
