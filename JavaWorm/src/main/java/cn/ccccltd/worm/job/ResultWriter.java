package cn.ccccltd.worm.job;

import java.util.List;

import cn.ccccltd.pojo.Book;
import cn.ccccltd.pojo.Bookrack;
import cn.ccccltd.pojo.SearchResult;

/**
 * 结果写入类
 * @author 13013
 *
 */
public class ResultWriter {
	/**
	 * 加锁遍历搜索结果的bookrack对象写入resultSearch中
	 * @param bookrack
	 */
	public static synchronized void write(Bookrack bookrack) {
		//获得结果对象
		SearchResult result = SearchResult.getInstance();
		//获得结果对象中的books
		List<Book> books = result.getBooks();
		//遍历书架中的书本
		List<Book> resultBooks = bookrack.getBooks();
		for (Book book : resultBooks) {
			books.add(book);
		}
	}
	
}
