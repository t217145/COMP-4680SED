package comp4680.u7.rest.eureka.client.api;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "DEMOWS")
@LoadBalancerClient(name = "DEMOWS")
public interface DemoService {
    @PostMapping("/msgByPost")
    DemoResponse getMessageByPost(@RequestBody DemoRequest request);

    @GetMapping("/msgByGet/{name}")
    String getMessageByGet(@PathVariable("name") String name, @RequestParam("age") int age);
}