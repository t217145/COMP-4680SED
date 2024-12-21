package comp4680.u07.rest.app04.apis;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "basic", url = "http://localhost:8080", fallback = CustomErrorHandler.class)
public interface BasicApi {
    @GetMapping("/index")
    String index();

    @GetMapping("/hello/test/{name}")
    String hello(@PathVariable String name);

    @GetMapping("/hello")
    String helloQuery(@RequestParam(value = "name", defaultValue = "Nobody") String name);

    @PostMapping("/hello")
    String helloPost(@RequestBody String name);
}

@Component
class CustomErrorHandler implements BasicApi {
    @Override
    public String helloPost(@RequestBody String name) {
        return "Error occur in hello by post";
    }

    @Override
    public String index() {
        return "Error occur in default";
    }

    @Override
    public String hello(String name) {
        return "Error occur in hello by path";
    }

    @Override
    public String helloQuery(String name2) {
        return "Error occur in hello by query";
    }
}