package com.lmn.mybatis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

import com.wana.user.interfaces.UserInterface;

@SpringBootConfiguration
@PropertySource(value = "classpath:rpc.properties")
public class RPCConfig {

	@Value("${user_host}")
	private String userHost;

	@Value("${user_port}")
	private String userPort;

	@Bean
	public HessianProxyFactoryBean userInterface() {
		HessianProxyFactoryBean factory = new HessianProxyFactoryBean();
		factory.setServiceUrl("http://" + userHost + ":" + userPort
				+ "/user/remote/userInterface");
		factory.setServiceInterface(UserInterface.class);
		return factory;
	}

}
