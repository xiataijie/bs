package com.bs.search.dao;

import org.apache.solr.client.solrj.SolrQuery;

import com.bs.search.bean.SearchResult;

public interface SearchDao {

	SearchResult search(SolrQuery query) throws Exception;
}
