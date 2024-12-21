package comp4680sed.unit5.app03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.Data;

@Controller
public class NumberController {
    @Autowired
    private Game game;

    @GetMapping({ "", "/", "/index" })
    public String index() {
        return "index";
    }

    @GetMapping("/play")
    public String play(ModelMap model) {
        model.addAttribute("game", game);
        return "play";
    }

    @PostMapping("/play")
    public String makeGuess(GuessForm guessForm, ModelMap model) {
        game.doGuess(guessForm.getGuess());
        model.addAttribute("game", game);
        return "play";
    }

    @Data
    public static class GuessForm {
        private Integer guess;
    }
}