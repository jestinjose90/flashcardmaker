package edu.neiu.flashcardmaker.security;

import edu.neiu.flashcardmaker.data.UserRepository;
import edu.neiu.flashcardmaker.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepo;

   @Autowired
    public UserDetailsServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //User user = userRepo.findByUsername(username);

        User user = userRepo.findByEmail(email);
        if(user == null)
            throw new UsernameNotFoundException("Email" + email + "not found");
        return user;
    }
}
