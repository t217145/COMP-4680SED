package comp4680.u8.discovery.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final Logger logger = LogManager.getLogger(DemoController.class);

    @GetMapping({ "", "/", "/index" })
    public String index() {
        logger.info("Service Called");
        return "Hello World!";
    }
}