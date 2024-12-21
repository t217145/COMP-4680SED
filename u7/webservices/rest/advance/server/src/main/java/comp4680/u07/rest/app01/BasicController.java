package comp4680.u07.rest.app01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @GetMapping({ "", "/", "/index" })
    public String index() {
        return "Hello World";
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "Hello " + name;
    }

    @GetMapping("/hello")
    public String helloQuery(@RequestParam(value = "name", defaultValue = "Nobody") String name) {
        return "Hello " + name;
    }

    @PostMapping("/hello")
    public String helloPost(@RequestBody String name) {
        return "Hello " + name;
    }

}