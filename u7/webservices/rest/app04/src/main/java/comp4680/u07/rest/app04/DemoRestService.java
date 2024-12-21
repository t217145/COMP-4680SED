package comp4680.u07.rest.app04;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "demo", url = "http://localhost:8080")
public interface DemoRestService {
    @GetMapping("/hello")
    String sayHello();

    @GetMapping("/helloPath/{name}")
    String helloPath(@PathVariable(value = "name") String name);

    @GetMapping("/helloQuery")
    String helloQuery(@RequestParam(value = "name") String name);

    @PostMapping("/hello")
    String helloPost(@RequestBody String name);
}