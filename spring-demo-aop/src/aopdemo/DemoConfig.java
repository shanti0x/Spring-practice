package aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration // configurare pur java
@EnableAspectJAutoProxy //spring AOP proxy support
@ComponentScan("aopdemo")

public class DemoConfig {

}
