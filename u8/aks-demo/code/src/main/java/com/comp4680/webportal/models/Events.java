package com.comp4680.webportal.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class Events implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100, nullable = false, unique = true)
    @Length(min = 3, max = 100, message = "Code must be between 3 and 100 characters")
    @NotBlank
    private String code;

    @Column(length = 255, nullable = false)
    @Length(min = 3, max = 255, message = "Name must be between 3 and 255 characters")
    @NotBlank
    private String name;

    @Column(length = 500, nullable = false)
    @Length(min = 3, max = 500, message = "Description must be between 3 and 500 characters")
    @NotBlank
    private String descr;

    @Column(length = 20, nullable = false, columnDefinition = "varchar(1) default 'P'")
    @Pattern(regexp = "[PIE]", message = "Only P, I, E are allowed")
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "evtDate", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Future(message = "Event date must be in the future")
    @NotNull
    private Date eventDate;

    @OneToMany(mappedBy = "event")
    private List<Items> items;

    public String getStatusString() {
        String rtn = "Pending";
        switch (this.status) {
            case "I":
                rtn = "In Progress";
                break;
            case "E":
                rtn = "End";
                break;
            case "P":
            default:
                rtn = "Pending";
                break;
        }
        return rtn;
    }
}
