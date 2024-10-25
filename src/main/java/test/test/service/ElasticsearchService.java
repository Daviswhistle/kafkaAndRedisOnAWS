package test.test.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.test.model.Product;
import test.test.repository.ProductRepository;

import java.io.IOException;

@Service
public class ElasticsearchService {

    @Autowired
    private ElasticsearchClient elasticsearchClient;

    @Autowired
    private ProductRepository productRepository;

    private final String indexName = "products";

    public String createProduct(Product product) throws IOException {
        // PostgreSQL에 저장
        productRepository.save(product);

        // Elasticsearch에 저장
        IndexResponse response = elasticsearchClient.index(i -> i
            .index(indexName)
            .id(product.getId())
            .document(product)
        );

        return response.result().name();
    }
}