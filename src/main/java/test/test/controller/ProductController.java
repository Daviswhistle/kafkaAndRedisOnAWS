package test.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.test.model.Product;
import test.test.service.ElasticsearchService;

import java.io.IOException;

@RestController
@RequestMapping("/es/products")
public class ProductController {

    @Autowired
    private ElasticsearchService elasticsearchService;

    @PostMapping
    public String createProduct(@RequestBody Product product) {
        try {
            return elasticsearchService.createProduct(product);
        } catch (IOException e) {
            e.printStackTrace();
            return "Error";
        }
    }
}