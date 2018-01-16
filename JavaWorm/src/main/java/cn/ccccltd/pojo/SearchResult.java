package cn.ccccltd.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 搜索结果类 单例模式 放置一个Book集合
 * @author 13013
 *
 */
public class SearchResult {
	
	private static SearchResult searchResult = null;
	
	private SearchResult(){}
	
	private List<Book> books = new ArrayList<Book>();
	
	public static synchronized 	SearchResult getInstance(){
		if(searchResult == null){
			searchResult = new SearchResult();
		}
		return searchResult;
	}
	
	public List<Book> getBooks() {
		return books;
	}

}
