package comp4680.u07.rest.app04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import comp4680.u07.rest.app04.apis.BasicApi;

@Component
public class DemoClient implements CommandLineRunner {

    @Autowired
    private BasicApi api;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(api.index());
        System.out.println(api.hello("Cyrus by Path"));
        System.out.println(api.helloQuery("Cyrus by Query"));
        System.out.println(api.helloPost("Cyrus by Post"));
    }

}
