package cn.ccccltd.worm.job;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cn.ccccltd.pojo.Book;
import cn.ccccltd.pojo.Bookrack;
import cn.ccccltd.pojo.SearchResult;
import cn.ccccltd.utils.ExcelUtils;
import cn.ccccltd.utils.GetSender;
import cn.ccccltd.utils.JsonUtils;

/**
 * 工作类
 * @author 13013
 *
 */
public class WormJob {
	
	//使用ExecutorService 创建线程池
	private static ExecutorService pool = Executors.newCachedThreadPool();
	//创建CountDownLatch观察线程是否全部结束
	private static CountDownLatch cdl = new CountDownLatch(15);
	//Url地址前部分
	private static final String preUrl = "https://api.douban.com//v2/book/search?count=100&q=";
	//设置关键字
	final static ArrayList<String> keywords = new ArrayList<String>();
	static {
		keywords.add("互联网");
		keywords.add("编程");
		keywords.add("算法");
	}
	public static void main(String[] args) {
		System.out.println("搜索开始");
		//开始搜索 各关键字搜索5次
		for (int i = 0; i < 15; i++) {
			//设置索引值
			final int index = i;
			pool.execute(new Runnable() {
		        public void run() {
		            try {
		            	//新建请求发送对象
		            	GetSender getSender = new GetSender();
		            	//发送请求获取数据
		            	String result = getSender.getHtmlResult(preUrl + keywords.get(index%3));
		            	//将json数据转换为javaBean
		            	Bookrack bookrack = JsonUtils.jsonToPojo(result);
		            	//写入结果
		            	ResultWriter.write(bookrack);
		    			cdl.countDown();
		            } catch (Exception e) {
		                e.printStackTrace();
		            }
		        }
		    });
		}
		try {
			//观察线程是否全部结束
			cdl.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//关闭线程池
		pool.shutdown();
		List<Book> books = SearchResult.getInstance().getBooks();
		System.out.println("搜索完毕，根据互联网，编程，算法三个关键词找到了" + books.size() + "本书");
		//将搜索结果中得分最高的前100本书籍导出excel
		System.out.println("评分前100书单excel文件导出中，导出文件夹为:D:\\temp");
		try {
			ExcelUtils.exprot(books);
			System.out.println("导出成功，请根据路径查看。");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("文件导出失败");
		}
	}
	
}
