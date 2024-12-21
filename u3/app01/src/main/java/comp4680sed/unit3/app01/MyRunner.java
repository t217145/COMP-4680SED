package comp4680sed.unit3.app01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import comp4680sed.unit3.beans.School;

//@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    private School school;

    @Override
    public void run(String... args) throws Exception {
        try {
            school.setName("My school abc");
        } catch (Exception e) {
            //
        }
        System.out.println("Runner 1: " + school.getName());
    }
}