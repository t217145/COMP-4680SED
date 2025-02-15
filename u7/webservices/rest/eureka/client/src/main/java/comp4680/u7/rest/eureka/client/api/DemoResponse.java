package comp4680.u7.rest.eureka.client.api;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DemoResponse implements Serializable {
    private String msg;
    private int age;
}