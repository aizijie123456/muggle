package org.com.muggle.solr.client;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.stereotype.Component;

@Component(value = "solrClientFactory")
public class SolrClientFactory {

	private String solrCore = "muggle";
	
	@Resource(name = "solrClient")
	private HttpSolrClient solrClient;

	public void addBeanToSolr(Object bean) {
		try {
			solrClient.addBean(bean);
			solrClient.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
	}

	public void addKVToSolr(Map<String, String> kvMap) {
		try {
			SolrInputDocument doc = new SolrInputDocument();
			for (Entry<String, String> entry : kvMap.entrySet()) {
				doc.addField(entry.getKey(), entry.getValue());
			}
			solrClient.add(solrCore, doc);
			solrClient.commit(solrCore);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
	}

	public void add(SolrFactory solrFactory) {
		solrFactory.addKVToSolr();
	}

}
