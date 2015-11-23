package gh664.failure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * MyConfig.class holds a factory method providing a custom instance of PeerAwareInstanceRegistry.
 * The method throws a runtime exception when invoked. The application shouldn't start if the method
 * is invoked.
 * 
 * However, the test case shows that the method is not invoked (the application starts) and the instance
 * provided by default by SpringCloud is used instead.
 * 
 */
@SpringBootApplication
@EnableEurekaServer
public class Application {

	public static void main(String[] args) {
    	SpringApplication.run(Application.class, args);
    }
}
