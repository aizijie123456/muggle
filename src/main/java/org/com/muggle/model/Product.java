package org.com.muggle.model;

import org.apache.solr.client.solrj.beans.Field;

public class Product implements SearchableProduct {
	@Field(ID_FIELD)
	private String id;

	@Field(NAME_FIELD)
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + "]";
	}

}
