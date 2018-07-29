package io.pivotal.microservices.products;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductsHomeController {
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
}
