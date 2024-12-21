package comp4680.u3.app03;

import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoRunner implements CommandLineRunner {

    @Autowired
    private StudentsRepo repo;

    @SuppressWarnings("null")
    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

        repo.deleteAll();// clean up the existing data

        // 1. Save a new records
        Students s1 = new Students("s1039518",
                "Cyrus", "BCOMPHIT",
                fmt.parse("1984-08-22"));
        repo.save(s1);

        Students s2 = new Students("s1234567",
                "Mandy Ko", "BBA(Acct)",
                fmt.parse("1984-11-17"));
        repo.save(s2);
        pause("Records created");

        // 2a . List all records
        List<Students> allStd = repo.customQuery("BCOMPHIT", "Cyrus");
        allStd.stream().forEach(System.out::println);

        // 2b. Find a specific record
        Students std = repo.findByStdCode("s1039518").orElse(null);
        System.out.println(std == null ? "not found" : std);
        pause("Records retrieved");

        // 3. Update a record
        std.setProgramme("BSc(CS)");
        repo.save(std);
        pause("Records updated");

        // 4. Delete a record
        repo.delete(std);
        pause("Records deleted");

        System.exit(0);
    }

    private void pause(String msg) throws Exception {
        System.out.printf("%sPress any key to continue ...", msg);
        System.in.read();
        System.in.read();
    }
}