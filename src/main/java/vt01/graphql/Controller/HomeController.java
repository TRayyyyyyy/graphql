package vt01.graphql.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vt01.graphql.Entity.Category;
import vt01.graphql.Entity.User;
import vt01.graphql.Service.CategoryService;
import vt01.graphql.Service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeController {
    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }


    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return userService.updateUser(id, userDetails);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/users/{userId}/categories")
    public List<Category> getCategoriesByUser(@PathVariable Long userId) {
        return userService.getCategoriesByUser(userId);
    }

}

