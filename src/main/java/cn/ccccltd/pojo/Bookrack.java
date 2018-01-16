package cn.ccccltd.pojo;

import java.io.Serializable;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 书架类
 * @author 13013
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bookrack implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//书本数目
	private int count;
	
	//搜索起始数目
	private int start;
	
	//搜索条件下所有书籍数目
	private int total;
	
	//书籍
	private List<Book> books;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Bookrack [count=" + count + ", start=" + start + ", total=" + total + ", books=" + books + "]";
	}
	
}
