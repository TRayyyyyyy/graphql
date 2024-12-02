package vt01.graphql.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vt01.graphql.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
