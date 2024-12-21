package comp4680sed.unit5.app05;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class IdNotFoundException extends Exception {
    private int id;
    private String entityName;
    private String rtnUrl;
}