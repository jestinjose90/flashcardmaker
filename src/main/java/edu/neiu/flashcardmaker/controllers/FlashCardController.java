package edu.neiu.flashcardmaker.controllers;

import edu.neiu.flashcardmaker.data.FlashCardRepository;
import edu.neiu.flashcardmaker.models.FlashCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

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
        model.addAttribute("flashcard", new FlashCard());
        return "add-flashcard";

    }

    @GetMapping("/display")
    public String displayFlashCard(Model model){
    List<FlashCard> flashcards = (List<FlashCard>) this.flashcardrepo.findAll();
    model.addAttribute("flashcards",flashcards);
    return  "display-flashcards";
    }

    @PostMapping
    public String handleFlashCardForm(@Valid @ModelAttribute("flashcard") FlashCard flashcard, Errors errors){
    if(errors.hasErrors())
        return "add-flashcard";
     this.flashcardrepo.save(flashcard);

        return "redirect:/flashcard/display";

    }








}
