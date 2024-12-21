package comp4680sed.unit3.app01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
class MyServiceIntegrationTest {

    @Value("${test.property}")
    private String testProperty;

    @Test
    void testServiceLogic() {
        // Use the testProperty in your test logic
        assertEquals("test-value", testProperty);
        // Rest of the test logic
    }
}