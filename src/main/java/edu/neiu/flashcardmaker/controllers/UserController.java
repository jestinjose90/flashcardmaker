package edu.neiu.flashcardmaker.controllers;

import edu.neiu.flashcardmaker.data.UserRepository;
import edu.neiu.flashcardmaker.models.FlashCard;
import edu.neiu.flashcardmaker.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Set;

@Controller
@RequestMapping("/register")
public class UserController {

    private UserRepository userRepo;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String RegisterUser(Model model) {
        User user = new User();
        model.addAttribute("User", user);
        return "registration";

    }


    @PostMapping
    public String handleRegistration(@Valid @ModelAttribute("User") User user, Errors errors) {
        if (errors.hasErrors())
            return "registration";
        try {

           user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Set.of(User.Role.ROLE_USER));
            user.setEnabled(true);
            user.setAccountNonExpired(true);
            user.setAccountNonLocked(true);
            user.setCredentialsNonExpired(true);
            this.userRepo.save(user);
        } catch (DataIntegrityViolationException e) {
            errors.rejectValue("email", "invalidEmail", "Email already exist . Please chose another");
            return "registration";
        }
        return "redirect:/";

    }
}