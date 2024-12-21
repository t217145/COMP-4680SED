package comp4680.u3.full_demo;

import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.format.annotation.DateTimeFormat;

public class DemoRunner implements CommandLineRunner {

    @Autowired
    private StudentsRepo repo;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

        // 1. Create 2 studetns
        Students s1 = new Students("s1039518", "Cyrus Che", "BCOMPHIT", fmt.parse("1984-08-22"));
        Students s2 = new Students("s1234567", "Peter", "BBA", fmt.parse("1984-08-22"));

        repo.save(s1);
        repo.save(s2);
        pause();

        System.exit(0);
    }

    private void pause() {
        try {
            System.in.read();
            System.out.print("Press any key to continue...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
