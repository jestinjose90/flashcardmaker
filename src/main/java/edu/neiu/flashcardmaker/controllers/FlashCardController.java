package edu.neiu.flashcardmaker.controllers;

import edu.neiu.flashcardmaker.models.FlashCard;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/flashcard")
public class FlashCardController {

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
        System.out.println("Topic:" + flashcard.getTopic());
        System.out.println(("Term:"  + flashcard.getTerm()));
        System.out.println("Definition:" + flashcard.getDefinition());

        return "redirect:/";

    }



}
