/**
 * 
 */
package sample.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class HelloRest {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HelloClient client;


    @RequestMapping("/feign")
    public String helloFeign() {
    	return client.getHello();
    }
    
    @RequestMapping("/rt")
    public String helloRestTemplate() {
    	return restTemplate.getForObject("http://helloservice", String.class);
    }
    
}
