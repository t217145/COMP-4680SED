package comp4680sed.unit3.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // @AfterThrowing("excution(* comp4680sed.unit3.*.*(..))")
    public void exceptionHappened() {
        System.out.println("LoggingAspect: Exception occur...");
    }

    // @AfterReturning(pointcut = "execution(* comp4680sed.unit3.*.*(..))",
    // returning = "result")
    public void afterMethodExecution(Object result) {
        System.out.println("LoggingAspect: Executing after the method with result: " + result);
    }
}

@Aspect
@Component
class SecurityAspect {
    @Cacheable("myCache")
    public Object getCachedData() {
        // Method implementation
        return null;
    }

    @Around("execution(* com.example.myapp.service.*.*(..))")
    public Object handleMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        // Perform decryption of input argument
        Object[] args = joinPoint.getArgs();
        // Decrypt args[0] using appropriate decryption logic

        // Execute the method
        return joinPoint.proceed(args);
    }

}

@Aspect
@Component
class ErrorHandlingAspect {
    @AfterThrowing(pointcut = "excution(* comp4680sed.unit3.*.*.*(..))", throwing = "ex")
    public void handleExceptions(Exception ex) {
        // Error handling logic
        System.out.println("LoggingAspect: Exception occur..." + ex.getMessage());
    }
}