package vt01.graphql.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vt01.graphql.Entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
}
