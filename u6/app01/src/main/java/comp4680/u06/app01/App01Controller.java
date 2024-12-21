package comp4680.u06.app01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class App01Controller {

    @GetMapping({ "/", "", "/index" })
    public String external(ModelMap m) {
        m.addAttribute("msg", "This is an external page");
        return "index";
    }

    @GetMapping({ "/internal", "/internal/index" })
    public String internal(ModelMap m) {
        m.addAttribute("msg", "This is an staff and admin page");
        return "index";
    }

    @GetMapping("/internal/admin")
    public String admin(ModelMap m) {
        m.addAttribute("msg", "This is an admin page");
        return "index";
    }
}