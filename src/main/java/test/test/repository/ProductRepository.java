package test.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.test.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

}