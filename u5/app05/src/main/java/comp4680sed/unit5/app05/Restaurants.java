package comp4680sed.unit5.app05;

import java.io.Serializable;
import org.hibernate.validator.constraints.Length;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Restaurants implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    @NotEmpty(message = "Name must be provided")
    private String name;

    @Column(length = 10)
    @Length(min = 1, max = 10, message = "Address must be between 1 and 10 characters")
    private String addr;

    @Pattern(regexp = "^(|\\d{8})$", message = "Phone number must be 8 digits")
    private String phone;
}