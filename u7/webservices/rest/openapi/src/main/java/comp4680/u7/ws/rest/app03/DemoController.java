package comp4680.u7.ws.rest.app03;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.text.ParseException;
import java.util.Date;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    /**
     * POST API to calculate age and return a message.
     *
     * @param requestBody JSON request body containing "name" and "DoB"
     * @return JSON response with message and calculated age
     */
    @SuppressWarnings("deprecation")
    @Operation(summary = "Calculate age and return a greeting message", description = "Accepts a JSON request with name and date of birth, calculates the age, and returns a greeting message.")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "SuccessfulResponse", content = @Content(schema = @Schema(implementation = DemoResponse.class))))
    @PostMapping("/msgByPost")
    public DemoResponse getMessageByPost(@RequestBody DemoRequest request) throws ParseException {
        System.out.println(request);
        String name = request.getName();
        Date dob = request.getDob();

        // Calculate age
        int age = new Date().getYear() - dob.getYear();

        return new DemoResponse("Hello " + name + ", you are " + age + " years old", age);
    }

    /**
     * GET API to return a greeting message using path variable and query param.
     *
     * @param name the name provided in the path variable
     * @param age  the age provided as a query parameter
     * @return Greeting message as a string
     */
    @Operation(summary = "Return a greeting message with name and age", description = "Accepts name as a path variable and age as a query parameter,and returns a greeting message.")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "SuccessfulResponse", content = @Content(schema = @Schema(type = "string"))))
    @GetMapping("/msgByGet/{name}")
    public String getMessageByGet(@PathVariable String name, @RequestParam int age) {
        return "Hello " + name + ", you are " + age + " years old";
    }
}