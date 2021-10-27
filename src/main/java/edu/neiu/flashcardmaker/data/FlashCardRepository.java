package edu.neiu.flashcardmaker.data;

import edu.neiu.flashcardmaker.models.FlashCard;
import org.springframework.data.repository.CrudRepository;

public interface FlashCardRepository extends CrudRepository<FlashCard, Long> {


}
