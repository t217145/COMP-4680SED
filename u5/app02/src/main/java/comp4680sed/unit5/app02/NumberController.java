package comp4680sed.unit5.app02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NumberController {
    @GetMapping({ "", "/", "/index" })
    public String index() {
        return "index";
    }

    @GetMapping("/play")
    public String play() {
        return "play";
    }
}