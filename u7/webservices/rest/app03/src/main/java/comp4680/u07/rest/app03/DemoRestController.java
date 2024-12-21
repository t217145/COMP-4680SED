package comp4680.u07.rest.app03;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping("/helloPath/{name}")
    public String helloPath(@PathVariable(value = "name") String name) {
        return "Hello by GET with path variable: " + name + "!";
    }

    @GetMapping("/helloQuery")
    public String helloQuery(@RequestParam(value = "name", defaultValue = "Nobody") String name) {
        return "Hello by GET with query parameter: " + name + "!";
    }

    @PostMapping("/hello")
    public String helloPost(@RequestBody String name) {
        return "Hello by POST : " + name + "!";
    }
}