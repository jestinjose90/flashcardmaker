package edu.neiu.flashcardmaker.data;

import edu.neiu.flashcardmaker.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {

    User findByUsername(String username);

    User findByEmail(String email);
}
