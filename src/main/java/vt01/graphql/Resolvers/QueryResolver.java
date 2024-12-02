package vt01.graphql.Resolvers;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;
import vt01.graphql.Entity.Category;
import vt01.graphql.Entity.User;
import vt01.graphql.Repository.CategoryRepository;
import vt01.graphql.Service.UserService; // Sửa đây: import UserService thay vì UserRepository

import java.util.List;

@Component
public class QueryResolver implements GraphQLQueryResolver {

    private final UserService userService; // Khai báo UserService thay vì UserRepository
    private final CategoryRepository categoryRepository;

    // Tiêm UserService vào constructor
    public QueryResolver(UserService userService, CategoryRepository categoryRepository) {
        this.userService = userService;
        this.categoryRepository = categoryRepository;
    }

    // Lấy tất cả user
    public List<User> getAllUsers() {
        return userService.getAllUsers(); // Dùng UserService thay vì UserRepository
    }

    // Lấy tất cả category
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Lấy tất cả categories của một user
    public List<Category> getCategoriesByUser(Long userId) {
        return userService.getCategoriesByUser(userId); // Sử dụng userService ở đây
    }
}
