package comp4680.u07.soap.app02;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoSoapClient implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(DemoSoapService.class);
        factory.setAddress("http://localhost:8080/services/helloSvc");
        DemoSoapService demoSoapService = (DemoSoapService) factory.create();
        System.out.println(demoSoapService.sayHelloName("Cyrus"));
    }
}