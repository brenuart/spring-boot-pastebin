package gh664.success;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.EurekaClientConfig;
import com.netflix.eureka.EurekaServerConfig;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;
import com.netflix.eureka.resources.ServerCodecs;


/**
 * The factory method for the custom PeerAwareInstanceRegistry is defined in the main class.
 * A runtime exception will be thrown as a trace of the invocation.
 * 
 * The application won't start which is expected.
 */
@SpringBootApplication
@EnableEurekaServer
@Configuration
public class Application {
	
	public static void main(String[] args) {
    	SpringApplication.run(Application.class, args);
    }
	
	
	@Bean
	public PeerAwareInstanceRegistry peerAwareInstanceRegistry(
			ApplicationInfoManager applicationInfoManager, 
			EurekaServerConfig     eurekaServerConfig, 
			ServerCodecs           serverCodecs,
			EurekaClientConfig     eurekaClientConfig,
			EurekaClient           eurekaClient)
	{
		throw new RuntimeException("This exception is thrown when my custom PeerAwareInstanceRegistry implementation is choosen over the one provided by default by SpringCloud Netflix");
	}
}
