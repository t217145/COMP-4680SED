package comp4680sed.unit5.app05;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;

@Controller
public class RestaurantsController {

    @Autowired
    private RestaurantsRepo repo;

    @Autowired
    private CustomRestaurantsValidator validator;

    @GetMapping({ "", "/", "/retrieve" })
    public String retrieve(ModelMap map) {
        map.addAttribute("allObjects", repo.findAll());
        return "retrieve";
    }

    @GetMapping("/create")
    public String create(ModelMap map) {
        map.addAttribute("newObject", new Restaurants());
        return "create";
    }

    @PostMapping("/create")
    public String create(
            @Valid @ModelAttribute("newObject") Restaurants restaurant,
            BindingResult result,
            ModelMap map) {
        validator.validate(restaurant, result);
        if (result.hasErrors()) {
            map.addAttribute("newObject", restaurant);
            return "create";
        }
        repo.save(restaurant);
        return "redirect:/retrieve";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, ModelMap map) throws IdNotFoundException {
        Optional<Restaurants> obj = repo.findById(id);
        if (obj.isPresent()) {
            map.addAttribute("updateObject", obj.get());
        } else {
            throw new IdNotFoundException(id, "Restaurants", "/retrieve");
        }
        return "update";
    }

    @PostMapping("/update")
    public String update(
            @Valid @ModelAttribute("updateObject") Restaurants restaurant,
            BindingResult result,
            ModelMap map) {
        if (result.hasErrors()) {
            map.addAttribute("updateObject", restaurant);
            return "update";
        }
        repo.save(restaurant);
        return "redirect:/retrieve";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) throws IdNotFoundException {
        Optional<Restaurants> obj = repo.findById(id);
        if (obj.isPresent()) {
            repo.deleteById(id);
        } else {
            throw new IdNotFoundException(id, "Restaurants", "/retrieve");
        }
        return "redirect:/retrieve";
    }

    @GetMapping("/customError")
    public String error() {
        return "error";
    }
}