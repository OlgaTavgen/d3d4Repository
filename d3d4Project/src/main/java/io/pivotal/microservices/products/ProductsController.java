package io.pivotal.microservices.products;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.pivotal.microservices.exceptions.ProductNotFoundException;

/**
 * A RESTFul controller for accessing product information.
 * 
 * @author Volha Tavgen
 */
@RestController
public class ProductsController {
	
	protected Logger logger = Logger.getLogger(ProductsController.class
			.getName());
	protected ProductRepository productRepository;

	/**
	 * Create an instance plugging in the respository of Products.
	 * 
	 * @param productRepository
	 *            A product repository implementation.
	 */
	@Autowired
	public ProductsController(ProductRepository productRepository) {
		this.productRepository = productRepository;

		logger.info("ProductRepository says system has "
				+ productRepository.countProducts() + " products");
	}

	/**
	 * Fetch a product with the specified product id.
	 * 
	 * @param id
	 *            A numeric, 5 digit product id.
	 * @return The product if found.
	 * @throws ProductNotFoundException
	 *             If the id is not recognised.
	 */
	@RequestMapping("/products/{id}")
	public Product byId(@PathVariable("id") Long id) {

		logger.info("products-service byId() invoked: " + id);
		Product product = productRepository.findById(id);
		logger.info("products-service byId() found: " + product);

		if (product == null)
			throw new ProductNotFoundException(id);
		else {
			return product;
		}
	}

	/**
	 * Fetch products with the specified name. A partial case-insensitive match
	 * is supported. So <code>http://.../products/productName</code> will find any
	 * products with upper or lower case 'a' in their name.
	 * 
	 * @param partialName
	 * @return A non-null, non-empty set of accounts.
	 * @throws ProductNotFoundException
	 *             If there are no matches at all.
	 */
	@RequestMapping("/products/{productName}")
	public List<Product> byProductName(@PathVariable("name") String partialName) {
		logger.info("products-service byProductName() invoked: "
				+ productRepository.getClass().getName() + " for "
				+ partialName);

		List<Product> products = productRepository
				.findByProductNameContainingIgnoreCase(partialName);
		logger.info("products-service byProductName() found: " + products);

		if (products == null || products.size() == 0)
			throw new ProductNotFoundException(partialName);
		else {
			return products;
		}
	}
}
