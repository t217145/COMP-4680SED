package comp4680.u04.app04;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestRunner implements CommandLineRunner {

    @Value("${app.setting.numOfRecords:100000}")
    private int numOfRecords;

    @Autowired
    private TestingRepo repo;

    @Override
    public void run(String... args) throws Exception {
        List<Testing> tests = new ArrayList<>();

        long startTime = System.currentTimeMillis();

        for (int i = 1; i <= numOfRecords; i++) {
            tests.add(new Testing(0, "test" + i));
            // repo.save(new Testing(0, "test" + i));
        }
        repo.saveAll(tests);

        long endTime = System.currentTimeMillis();

        System.out.println("Saved [" + numOfRecords + "] records");
        System.out.println("Total time : " + ((endTime - startTime) / 1000.0) + " seconds");
    }// end of main()
}