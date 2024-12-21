package comp4680sed.unit5.app03;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import lombok.Data;

@Component
@SessionScope
@Data
public class Game implements Serializable {
    private int number = 33;
    private Integer guess;
    private int trials = 0;
    private String message;

    public void doGuess(Integer guess) {
        trials++;
        if (guess > number) {
            message = "Your guess, " + guess + ", is higher than my number.";
        } else if (guess < number) {
            message = "Your guess, " + guess + ", is lower than my number.";
        } else {
            message = "Congratulations! Your guess, " + guess + ", is my number.";
        }
    }// end of doGuess()
}