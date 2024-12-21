package comp4680.u04.app04;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestDeleteRunner implements CommandLineRunner {

    @Value("${app.setting.numOfRecords:100000}")
    private int numOfRecords;

    @Autowired
    private TestingRepo repo;

    @Override
    public void run(String... args) throws Exception {
        List<Integer> ids = new ArrayList<>();
        Random rand = new Random();

        for (int i = 1; i <= numOfRecords; i++) {
            if ((rand.nextInt(10) + 1) <= 7) { // I need around 70% of records to be deleted
                ids.add(i);// as the 1st index in DB is 1
            } // end of checking for deletion
        } // end of looping through all records

        long startTime = System.currentTimeMillis();

        ids.forEach(i -> repo.deleteById(i));
        // repo.deleteAllById(ids);

        long endTime = System.currentTimeMillis();

        System.out.println("Deleted [" + ids.size() + "] records");
        System.out.println("Total time : " + ((endTime - startTime) / 1000.0) + " seconds");
    }
}