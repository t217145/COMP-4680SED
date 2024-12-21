package comp4680.u07.soap.app01;

import org.springframework.stereotype.Service;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

@WebService
@Service
public class DemoSoapService {

    @WebMethod(operationName = "sayHelloName")
    public @WebResult(name = "greeting") String sayHello(@WebParam(name = "yourName") String name) {
        return "Hello " + name;
    }

    public @WebResult(name = "result") Result calculate(@WebParam(name = "rectangle") Rectangle rectangle) {
        Result result = new Result();
        result.setArea(rectangle.getLength() * rectangle.getHeight());
        result.setPerimeter(2 * (rectangle.getLength() + rectangle.getHeight()));
        return result;
    }
}