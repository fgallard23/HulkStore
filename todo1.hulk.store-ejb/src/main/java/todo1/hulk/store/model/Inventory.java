package todo1.hulk.store.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Inventory")
public class Inventory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "code")
	Long code;

	Long inputProducts;

	Long outputProducts;

	@Temporal(TemporalType.TIMESTAMP)
	Date date;

	@ManyToOne
	@JoinColumn(name = "code")
	private Products products;

	public Inventory() {
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public Long getInputProducts() {
		return inputProducts;
	}

	public void setInputProducts(Long inputProducts) {
		this.inputProducts = inputProducts;
	}

	public Long getOutpuProducts() {
		return outputProducts;
	}

	public void setOutputProducts(Long outputProducts) {
		this.outputProducts = outputProducts;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}
}
