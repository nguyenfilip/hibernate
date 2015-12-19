package cz.nguyen.entity;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	

	@Column(unique=true)
	private String name;
	
	/*
	 * The day this item has been added to the eshop
	 */
	@Temporal(TemporalType.DATE)
	private java.util.Date addedDate;
	
	@ManyToMany
	private Set<Category> categories = new HashSet<Category>();



	
	public void setId(Long id){
		this.id = id;
	}
	
	public void removeCategory(Category category)
	{
		this.categories.remove(category);
	}

	public Set<Category> getCategories() {
		return Collections.unmodifiableSet(categories);
	}
	
	public void addCategory(Category c) {
		categories.add(c);
		c.addProduct(this);
	}


	public java.util.Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(java.util.Date addedDate) {
		this.addedDate = addedDate;
	}
	public Product(Long productId) {
		this.id = productId;
	}
	public Product() {
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Product))
			return false;
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.getName()))
			return false;
		return true;
	}


	
	
	
}
