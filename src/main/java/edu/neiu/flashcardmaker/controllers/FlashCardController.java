package edu.neiu.flashcardmaker.controllers;

import edu.neiu.flashcardmaker.data.FlashCardRepository;
import edu.neiu.flashcardmaker.models.FlashCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/flashcard")
public class FlashCardController {

    private FlashCardRepository flashcardrepo;

@Autowired
    public FlashCardController(FlashCardRepository flashcardrepo){
        this.flashcardrepo = flashcardrepo;
    }

    @GetMapping
    public String addFlashCard(Model model) {
        model.addAttribute("topic", "Enter the topic");
        model.addAttribute("term", "Enter the term");
        model.addAttribute("definition", "Enter the definition");
        model.addAttribute("flashcard", new FlashCard());
        return "add-flashcard";

    }

    @PostMapping
    public String handleFlashCardForm(@ModelAttribute("flashcard") FlashCard flashcard){
     this.flashcardrepo.save(flashcard);

        return "redirect:/";

    }



}
