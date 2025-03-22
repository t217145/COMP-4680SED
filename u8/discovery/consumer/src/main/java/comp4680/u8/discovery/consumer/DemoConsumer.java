package comp4680.u8.discovery.consumer;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoConsumer implements CommandLineRunner {

    @Autowired
    private DemoService demoSvc;

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            System.out.println(String.format("%s : %tH:%<tM:%<tS %<tp", demoSvc.index(), new Date()));
            Thread.sleep(1500);
        } // end of endless while loop
    }// end of run method()

}// end of class