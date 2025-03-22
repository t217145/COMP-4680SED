package comp4680.u8.discovery.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "demo-service")
public interface DemoService {
    @GetMapping("/index")
    String index();
}