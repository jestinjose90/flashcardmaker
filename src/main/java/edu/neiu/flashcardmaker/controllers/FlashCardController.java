package edu.neiu.flashcardmaker.controllers;

import edu.neiu.flashcardmaker.data.FlashCardRepository;
import edu.neiu.flashcardmaker.models.FlashCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/flashcard")
public class FlashCardController {

    private FlashCardRepository flashcardrepo;

    @Autowired
    public FlashCardController(FlashCardRepository flashcardrepo) {

        this.flashcardrepo = flashcardrepo;
    }

    @GetMapping
    public String addFlashCard(Model model) {
        model.addAttribute("flashcard", new FlashCard());
        return "add-flashcard";

    }

    @GetMapping("/display/{id}")
    public String showFlashCard(@PathVariable long id, Model model) {
        FlashCard flashCard = this.flashcardrepo.findById(id).get();
        model.addAttribute("flashcard", flashCard);
        return "view-flashcard";
    }

    @GetMapping("/display")
    public String displayFlashCard(Model model) {
        List<FlashCard> flashcards = (List<FlashCard>) this.flashcardrepo.findAll();
        model.addAttribute("flashcards", flashcards);
        return "display-flashcards";
    }

    @PostMapping
    public String handleFlashCardForm(@Valid @ModelAttribute("flashcard") FlashCard flashcard, Errors errors) {
        if (errors.hasErrors())
            return "add-flashcard";
        try {
            this.flashcardrepo.save(flashcard);
        } catch (DataIntegrityViolationException e) {
           errors.rejectValue("topic", "invalidTopic","Topic already exist . Please enter another topic");
           return "add-flashcard";
        }
        return "redirect:/flashcard/display";


    }

    @PostMapping("/edit/{id}")

    public String handleEditFlashCardForm(@PathVariable long id, @Valid @ModelAttribute("flashcard") FlashCard flashcard, Errors errors) {
        if (errors.hasErrors())
            return "view-flashcard";
        FlashCard eachFlashcard = this.flashcardrepo.findById(id).get();
        updateEachFlashCard(eachFlashcard, flashcard);
        this.flashcardrepo.save(eachFlashcard);

        return "redirect:/flashcard/display";


    }

    private void updateEachFlashCard(FlashCard eachflashcard, FlashCard update) {
        eachflashcard.setTopic(update.getTopic());
        eachflashcard.setTerm(update.getTerm());
        eachflashcard.setDefinition(update.getDefinition());

    }

    @GetMapping("/delete/{id}")
    public String deleteFlashCard(@PathVariable long id) {
        this.flashcardrepo.deleteById(id);
        return "redirect:/flashcard/display";
    }


}
