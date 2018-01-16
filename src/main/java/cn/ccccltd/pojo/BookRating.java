package cn.ccccltd.pojo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 书籍评级
 * @author 13013
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookRating implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//评论人数
	private int NumRaters;
	
	//平均得分
	private String average;

	public int getNumRaters() {
		return NumRaters;
	}

	public void setNumRaters(int numRaters) {
		NumRaters = numRaters;
	}

	public String getAverage() {
		return average;
	}

	public void setAverage(String average) {
		this.average = average;
	}

	@Override
	public String toString() {
		return "BookRating [NumRaters=" + NumRaters + ", average=" + average + "]";
	}
	
}
