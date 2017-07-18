package org.com.muggle.repository;

import org.com.muggle.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.Repository;
import org.springframework.data.solr.core.query.result.FacetPage;

public interface ProductRepository extends Repository<Product, String> {
	Page<Product> findByPopularity(Integer popularity);

	FacetPage<Product> findByNameStartingWithAndFacetOnAvailable(String namePrefix);

	Page<Product> findByAvailableTrue();
}