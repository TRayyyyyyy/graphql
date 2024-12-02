package vt01.graphql.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vt01.graphql.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
