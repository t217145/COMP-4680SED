package comp4680sed.unit3.app02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import comp4680sed.unit3.beans.School;

@Component
public class MyRunner2 implements CommandLineRunner {
    @Autowired
    private School school;

    @Override
    public void run(String... args) throws Exception {

        school.setName("My school abc");

        System.out.println("Runner 1: " + school.getName());
    }
}