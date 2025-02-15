package comp4680.u7.ws.rest.app03;

import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DemoRequest implements Serializable {
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;
}