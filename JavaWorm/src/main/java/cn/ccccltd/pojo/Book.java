package cn.ccccltd.pojo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * 书籍类
 * @author 13013
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//书籍等级
	private BookRating rating;
	
	//数目名
	private String subtitle;
	
	//作者
	private List<String> author;
	
	//出版时间
	private String pubdate;
	
	//豆瓣id
	private String id;
	
	//主题
	private String title;
	
	//价格
	private String price;
	
	//出版社
	private String publisher;

	public BookRating getRating() {
		return rating;
	}

	public void setRating(BookRating rating) {
		this.rating = rating;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public List<String> getAuthor() {
		return author;
	}

	public void setAuthor(List<String> author) {
		this.author = author;
	}

	public String getPubdate() {
		return pubdate;
	}

	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public String getAuthors(){
		String authors = null;
		for (String author : author) {
			authors += author + "  ";
		}
		return authors;
	}

	@Override
	public String toString() {
		return "Book [rating=" + rating + ", subtitle=" + subtitle + ", author=" + author + ", pubdate=" + pubdate
				+ ", id=" + id + ", title=" + title + ", price=" + price + ", publisher=" + publisher + "]";
	}

	
}
