package com.example.demo;

import com.example.demo.mvc.model.*;
import com.example.demo.mvc.repository.CategoryRepository;
import com.example.demo.mvc.repository.ClientRepository;
import com.example.demo.mvc.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
@EnableTransactionManagement
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner demo(ClientRepository clientRepository,
//                                  CategoryRepository categoryRepository,
//                                  ProductRepository productRepository) {
//        return args -> {
//
//            Category category = new Category();
//            Category category1 = new Category();
//            category.setName("first Category");
//            category1.setName("SecondCategory");
//            categoryRepository.save(category);
//            categoryRepository.save(category1);
//
//            Sale sale = new Sale();
//            sale.setTotal();
//            ProductItem productItem = new ProductItem();
//            productItem.setItemPrice(500);
//            productItem.setQuantity(4);
//
//
//            Set<Product> products = new HashSet<Product>();
//            Client client = new Client();
//
////            Client client = new Client("mohammed", "rabee", "+5656565656");
////            Client client2 = new Client("mohannad", "mohannad", "+4545454818");
////            Client client3 = new Client("sezar", "sezar", "+454545454");
//
//            Product product = new Product();
//            product.setName("ahlam");
//            product.setDescription("bad Product");
//            product.setCategory(category);
//            product.setCreateDate(LocalDateTime.now());
//
//            Set<Product> products = new HashSet<Product>();
//            products.add(product);
//
//            category.setProduct(products);
//            category.setName("first Category");
//
//            categoryRepository.save(category);
//            productRepository.save(product);
//
//            clientRepository.save(client);
//            clientRepository.save(client2);
//            clientRepository.save(client3);
//            clientRepository.save(client4);
//            clientRepository.save(client5);
//        };
//    }
}