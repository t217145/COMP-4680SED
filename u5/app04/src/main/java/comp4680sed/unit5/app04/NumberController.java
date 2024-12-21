package comp4680sed.unit5.app04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String play(ModelMap model, @RequestParam("newGame") String newGame) {
        if (newGame.equals("1")) {
            game.newGame();
        }
        model.addAttribute("game", game);
        model.addAttribute("guessForm", new GuessForm());
        return "play";
    }

    @PostMapping("/play")
    public String makeGuess(GuessForm guessForm, ModelMap model) {
        model.addAttribute("game", game);
        return game.doGuess(guessForm.getGuess()) ? "success" : "play";
    }

    @Data
    public static class GuessForm {
        private Integer guess;
    }
}