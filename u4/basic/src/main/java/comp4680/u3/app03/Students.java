package comp4680.u3.app03;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostLoad;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Students implements Serializable {

    public Students(String stdCode, String stdNames, String programme, Date dob) {
        this.stdCode = stdCode;
        this.stdNames = stdNames;
        this.programme = programme;
        this.dob = dob;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "s_code", unique = true, nullable = false, length = 20)
    @NotNull(message = "Name is required")
    @UniqueElements
    @Length(min = 6, max = 20, message = "Name must be between 1 and 20 characters")
    private String stdCode;

    @Column(name = "s_names", nullable = false)
    private String stdNames;

    @Column(nullable = false)
    private String programme;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    @Transient
    @Max(value = 100, message = "Age must be less than 100")
    @Min(value = 0, message = "Age must be greater than 0")
    private int age = 0;

    @SuppressWarnings("deprecation")
    @PostLoad
    public void calculateAge() {
        age = new Date().getYear() - dob.getYear();
    }
}