package comp4680sed.unit5.app01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping({ "", "/", "/index" })
    public String index() {
        return "index";
    }
}