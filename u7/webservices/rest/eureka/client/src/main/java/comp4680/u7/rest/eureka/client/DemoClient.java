package comp4680.u7.rest.eureka.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import comp4680.u7.rest.eureka.client.api.DemoRequest;
import comp4680.u7.rest.eureka.client.api.DemoService;

@Component
public class DemoClient implements CommandLineRunner {

    @Autowired
    private DemoService demoService;

    @Override
    @SuppressWarnings("deprecation")
    public void run(String... args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        do {
            // HTTP POST
            DemoRequest request = new DemoRequest("Cyrus Cheng", new Date(1983, 8, 22));
            System.out.println(demoService.getMessageByPost(request).toString());

            // HTTP GET
            System.out.println(demoService.getMessageByGet("Cyrus Cheng", 37));

            System.out.print("Press Enter to continue...");
        } while (reader.readLine() != null);
    }

}