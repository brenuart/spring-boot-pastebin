/*
 * $Id$
 *
 * Copyright (c) 2015 Aegaeon IT S.A..  All Rights Reserved
 * This program is a trade secret of Aegaeon IT S.A., and it is not to be
 * reproduced, published, disclosed to others, copied, adapted, distributed
 * or displayed without the prior authorization of Aegaeon IT S.A..
 * Licensee agrees to attach or embed this notice on all copies of the
 * program, including partial copies or modified versions thereof, and
 * is licensed subject to restrictions on use and distribution.
 *
 */
package gh664.failure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.EurekaClientConfig;
import com.netflix.eureka.EurekaServerConfig;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;
import com.netflix.eureka.resources.ServerCodecs;

/**
 * 
 */
@Configuration
public class MyConfig {

	
	/**
	 * 
	 * @param applicationInfoManager
	 * @param eurekaServerConfig
	 * @param serverCodecs
	 * @param eurekaClientConfig
	 * @param eurekaClient
	 * @return
	 */
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
