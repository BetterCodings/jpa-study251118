package com.codeit.jpastudy.chap01.repository;

import com.codeit.jpastudy.chap01.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class JdbcProductRepositoryTest {

    @Autowired
    private JdbcProductRepository repository;

    @Test
    void insertTest() {
        repository.insertProduct("아이폰", 1500000, Product.Category.ELECTRONIC);
    }

    @Test
    void selectAllTest() {
        List<Product> products = repository.selectAllProducts();
        for (Product product : products) {
            System.out.println(product);
        }
    }
}