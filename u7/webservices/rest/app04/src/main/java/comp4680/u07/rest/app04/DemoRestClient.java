package comp4680.u07.rest.app04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoRestClient implements CommandLineRunner {
    @Autowired
    private DemoRestService svc;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(svc.sayHello());
        System.out.println(svc.helloPath("Cyrus"));
        System.out.println(svc.helloQuery("Cyrus"));
        System.out.println(svc.helloPost("Cyrus"));
    }
}