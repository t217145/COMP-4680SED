package com.cyrus822.demo.web01.Models;

import java.io.Serializable;
import java.util.Date;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DemoModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //unique checking will carry in custom validator
    @Column(name="fld1", unique = true, nullable = false, length = 20)
    @Length(min = 3, max = 20, message = "value1 must between 3 to 20 characters")
    @NotBlank(message = "value1 must be provided")
    private String value1;

    @Column(name = "fld2")
    @Range(min = 0, max = 100, message = "value2 must between 0 to 100")
    private int value2;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "value3 must be a past date")
    private Date value3;
}