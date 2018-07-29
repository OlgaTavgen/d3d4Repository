package io.pivotal.microservices.products;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Persistent product entity with JPA markup. Products are stored in an H2
 * relational database.
 * 
 * @author Volha Tavgen
 */
@Entity
@Table(name = "T_PRODUCT")
public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static Long nextId = 0L;

	@Id
	protected Long id;

	protected String number;

	@Column(name = "productName")
	protected String productName;

	protected BigDecimal price;

	/**
	 * This is a very simple, and non-scalable solution to generating unique
	 * ids. Not recommended for a real application. Consider using the
	 * <tt>@GeneratedValue</tt> annotation and a sequence to generate ids.
	 * 
	 * @return The next available id.
	 */
	protected static Long getNextId() {
		synchronized (nextId) {
			return nextId++;
		}
	}

	/**
	 * Default constructor for JPA only.
	 */
	protected Product() {
		price = BigDecimal.ZERO;
	}

	public Product(String productName) {
		id = getNextId();
		this.productName = productName;
		price = BigDecimal.ZERO;
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

	public void withdraw(BigDecimal amount) {
		price.subtract(amount);
	}

	public void deposit(BigDecimal amount) {
		price.add(amount);
	}

	@Override
	public String toString() {
		return id + " [" + productName + "]: $" + price;
	}
}
