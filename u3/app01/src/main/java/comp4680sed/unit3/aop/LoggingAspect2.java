package comp4680sed.unit3.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect2 {
    @Before("execution(* comp4680sed.unit3.*.*.*(int, String))")
    public void beforeMethodExecution() {
        System.out.println("LoggingAspect: Executing before the method...");
    }
}