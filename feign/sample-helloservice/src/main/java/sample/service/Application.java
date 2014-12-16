/**
 * 
 */
package sample.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author brenuart
 *
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableDiscoveryClient

@RestController
public class Application {

	@Value("${eureka.instance.metadataMap.instanceId}")
	private String instanceId;
	
    @RequestMapping("/")
    public String home() {
        return "Hello world @"+instanceId;
    }
    
    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }

}