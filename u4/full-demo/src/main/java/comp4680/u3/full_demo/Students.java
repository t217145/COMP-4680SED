package comp4680.u3.full_demo;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "s_code", unique = true, nullable = false, length = 20)
    private String stdCode;

    @Column(nullable = false)
    private String name;

    private String programme;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;

    @Transient
    private int age;

    public Students(String stdCode, String name, String programme, Date dob) {
        this.stdCode = stdCode;
        this.name = name;
        this.programme = programme;
        this.dob = dob;
    }
}