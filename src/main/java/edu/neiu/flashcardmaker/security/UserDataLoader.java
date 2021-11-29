package edu.neiu.flashcardmaker.security;

import edu.neiu.flashcardmaker.data.UserRepository;
import edu.neiu.flashcardmaker.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class UserDataLoader implements CommandLineRunner {
    private UserRepository userRepo;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserDataLoader(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void run(String... args) throws Exception {
       // User user = new User("foo@foo.com","foo",passwordEncoder.encode("password"), "Harold","Kumar");
       // user.setRoles(Set.of(User.Role.ROLE_ADMIN));
       // user.setEnabled(true);
        //userRepo.save(user);


       //User user1 = new User("foo@foo1.com","foo1",passwordEncoder.encode("password"), "Harald","Kumar");
       // user1.setRoles(Set.of(User.Role.ROLE_USER));
       // user1.setEnabled(true);
       // userRepo.save(user1);

    }
}
