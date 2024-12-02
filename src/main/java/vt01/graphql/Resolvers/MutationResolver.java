package vt01.graphql.Resolvers;

import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;
import vt01.graphql.Entity.User;
import vt01.graphql.Repository.UserRepository;

@Component
public class MutationResolver implements GraphQLMutationResolver {

    private final UserRepository userRepository;

    public MutationResolver(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String fullname, String email, String password, String phone) {
        User user = new User();
        user.setFullname(fullname);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);
        return userRepository.save(user);
    }

    public User updateUser(Long id, String fullname, String email, String password, String phone) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        if (fullname != null) user.setFullname(fullname);
        if (email != null) user.setEmail(email);
        if (password != null) user.setPassword(password);
        if (phone != null) user.setPhone(phone);
        return userRepository.save(user);
    }

    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "User deleted successfully";
    }
}
