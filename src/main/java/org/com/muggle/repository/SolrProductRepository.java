package org.com.muggle.repository;

import java.util.Iterator;

import org.com.muggle.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.FacetOptions;
import org.springframework.data.solr.core.query.FacetQuery;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.Query.Operator;
import org.springframework.data.solr.core.query.SimpleFacetQuery;
import org.springframework.data.solr.core.query.SimpleField;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.data.solr.repository.support.SimpleSolrRepository;

@NoRepositoryBean
public class SolrProductRepository extends SimpleSolrRepository<Product, String> implements ProductRepository {

	@Override
	public Page<Product> findByPopularity(Integer popularity) {
		Query query = new SimpleQuery(new Criteria(SolrSearchableFields.POPULARITY).is(popularity));
		return getSolrOperations().queryForPage(query, Product.class);
	}

	@Override
	public FacetPage<Product> findByNameStartingWithAndFacetOnAvailable(String namePrefix) {
		FacetQuery query = new SimpleFacetQuery(new Criteria(SolrSearchableFields.NAME).startsWith(namePrefix));
		query.setFacetOptions(new FacetOptions(SolrSearchableFields.AVAILABLE));
		return getSolrOperations().queryForFacetPage(query, Product.class);
	}

	@Override
	public Page<Product> findByAvailableTrue() {
		Query query = new SimpleQuery(new Criteria(new SimpleField(Criteria.WILDCARD)).expression(Criteria.WILDCARD));
		query.addFilterQuery(new SimpleQuery(new Criteria(SolrSearchableFields.AVAILABLE).is(true)));
		return getSolrOperations().queryForPage(query, Product.class);
	}

	@Override
	public Page<Product> findByConditions(String id, String name) {
		Criteria c1 = new Criteria(SolrSearchableFields.ID).is(id);
		Criteria c2 = new Criteria(SolrSearchableFields.NAME).is(name);
		Query query = new SimpleQuery();
		query.addCriteria(c1).addCriteria(c2);
		return getSolrOperations().query(query, Product.class);
	}

}
