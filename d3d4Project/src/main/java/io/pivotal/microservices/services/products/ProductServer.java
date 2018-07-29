package io.pivotal.microservices.services.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import io.pivotal.microservices.accounts.AccountsConfiguration;
import io.pivotal.microservices.services.registration.RegistrationServer;

/**
 * Run as a micro-service, registering with the Discovery Server (Eureka).
 * <p>
 * Note that the configuration for this application is imported from
 * {@link ProductsConfiguration}. This is a deliberate separation of concerns.
 * <p>
 * This class declares no beans and current package contains no components for
 * ComponentScan to find. No point using <tt>@SptingBootApplication</tt>.
 * 
 * @author Volha Tavgen
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
//@Import(AccountsConfiguration.class)
public class ProductServer {
	
	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
		// Tell server to look for products.properties or products-server.yml
		System.setProperty("spring.config.name", "products-server");

		SpringApplication.run(ProductServer.class, args);
	}

}
