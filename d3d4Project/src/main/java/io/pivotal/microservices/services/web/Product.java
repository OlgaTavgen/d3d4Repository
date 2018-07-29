package io.pivotal.microservices.services.web;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Product DTO - used to interact with the {@link WebProductsService}.
 * 
 * @author Volha Tavgen
 */
@JsonRootName("Product")
public class Product {
	
	protected Long id;
	protected String productName;
	protected BigDecimal price;

	/**
	 * Default constructor for JPA only.
	 */
	protected Product() {
	}

	public long getId() {
		return id;
	}

	/**
	 * Set JPA id - for testing and JPA only. Not intended for normal use.
	 * 
	 * @param id
	 *            The new id.
	 */
	protected void setId(long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	protected void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getPrice() {
		return price.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

	protected void setPrice(BigDecimal value) {
		price = value;
		price.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

	@Override
	public String toString() {
		return id + " [" + productName + "]: $" + price;
	}
}
