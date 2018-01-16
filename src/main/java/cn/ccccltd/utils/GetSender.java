package cn.ccccltd.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
/**
 * 发送GET请求并获取网页内容
 * @author 13013
 *
 */
public class GetSender {
	/**
	 * 根据网页url获取页面内容
	 * @param String url
	 * @return String result
	 */
	public String getHtmlResult(String url) {
		// 定义一个字符串用来存储网页内容
		StringBuilder sb = null;
		// 定义一个缓冲字符输入流
		BufferedReader in = null;
		try {
			// 将string转成url对象
			URL realUrl = new URL(url);
			// 初始化一个链接到那个url的连接
			URLConnection connection = realUrl.openConnection();
			// 开始实际的连接
			connection.connect();
			// 初始化 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
			// 用来临时存储抓取到的每一行的数据
			String line;
			sb = new StringBuilder();
			while ((line = in.readLine()) != null) {
				// 遍历抓取到的每一行并将其存储到result里面
				sb.append(line);
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return sb.toString();
	}
}
