package comp4680.u07.soap.app01;

import org.apache.cxf.Bus;
import jakarta.xml.ws.Endpoint;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoEndpoint {
    @Autowired
    private Bus bus;

    @Autowired
    private DemoSoapService demoSoapService;

    @Bean
    public Endpoint endpoint() {
        EndpointImpl impl = new EndpointImpl(bus, demoSoapService);
        impl.publish("/helloSvc");
        return impl;
    }
}