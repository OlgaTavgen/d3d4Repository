package io.pivotal.microservices.services.web;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Client controller, fetches Product info from the microservice via
 * {@link WebProductsService}.
 * 
 * @author Volha Tavgen
 */
@Controller
public class WebProductsController {
	
	@Autowired
	protected WebProductsService productsService;

	protected Logger logger = Logger.getLogger(WebAccountsController.class
			.getName());

	public WebProductsController(WebProductsService productsService) {
		this.productsService = productsService;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setAllowedFields("id", "searchText");
	}

	@RequestMapping("/products")
	public String goHome() {
		return "index";
	}

	@RequestMapping("/products/{id}")
	public String byId(Model model,
			@PathVariable("id") Long id) {

		logger.info("web-service byId() invoked: " + id);

		Product product = productsService.findById(id);
		logger.info("web-service byNumber() found: " + product);
		model.addAttribute("account", product);
		return "product";
	}

	@RequestMapping("/products/{productName}")
	public String byProductName(Model model, @PathVariable("text") String name) {
		logger.info("web-service byProductName() invoked: " + name);

		List<Product> products = productsService.byProductName(name);
		logger.info("web-service byProductName() found: " + products);
		model.addAttribute("search", name);
		if (products != null)
			model.addAttribute("products", products);
		return "products";
	}

	@RequestMapping(value = "/products/search", method = RequestMethod.GET)
	public String searchForm(Model model) {
		model.addAttribute("searchCriteria", new SearchCriteria());
		return "productSearch";
	}

	@RequestMapping(value = "/products/dosearch")
	public String doSearch(Model model, SearchCriteria criteria,
			BindingResult result) {
		logger.info("web-service search() invoked: " + criteria);

		criteria.validate(result);

		if (result.hasErrors())
			return "productSearch";

		String name = criteria.getProductName();
		if (StringUtils.hasText(name)) {
			return byProductName(model, name);
		} else {
			String searchText = criteria.getSearchText();
			return byProductName(model, searchText);
		}
	}
}
