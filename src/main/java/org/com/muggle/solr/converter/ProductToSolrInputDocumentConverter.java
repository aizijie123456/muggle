package org.com.muggle.solr.converter;

import org.apache.solr.common.SolrInputDocument;
import org.com.muggle.model.Product;
import org.springframework.core.convert.converter.Converter;

public class ProductToSolrInputDocumentConverter implements Converter<Product, SolrInputDocument> {

	@Override
	public SolrInputDocument convert(Product source) {
		
		SolrInputDocument input = new SolrInputDocument();
		
		return null;
	}

}
