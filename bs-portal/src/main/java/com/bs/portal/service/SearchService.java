package com.bs.portal.service;

import com.bs.portal.bean.SearchResult;

public interface SearchService {

	SearchResult search(String queryString, int page);
}
