package comp4680.u7.msg.stream;

import org.springframework.messaging.support.MessageBuilder;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableBinding(Source.class)
public class MessageController {

    @Autowired
    private Source source;

    @PostMapping("/send")
    public String sendMessage(@RequestBody String message) {
        source.output().send(MessageBuilder.withPayload(message).build());
        return "Message sent: " + message;
    }
}