package com.bs.search.service;

import com.bs.search.bean.SearchResult;

public interface SearchService {

	SearchResult search(String queryString, int page, int rows) throws Exception;
}
