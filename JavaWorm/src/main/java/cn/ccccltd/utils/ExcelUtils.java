package cn.ccccltd.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import cn.ccccltd.pojo.Book;

/**
 * excel导出工具类
 * 
 * @author 13013
 *
 */
public class ExcelUtils {
	/**
	 * 导出excel方法
	 */
	public void exportXls() {

	}

	public static void exprot(List<Book> books) throws IOException {
		// 生成Excel文件
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
		// 创建Sheet
		HSSFSheet sheet = hssfWorkbook.createSheet("书目清单(豆瓣)");
		//创建一个样式对象
		HSSFCellStyle cellStyle= hssfWorkbook.createCellStyle();
		//标题设置成为粗体
		HSSFFont font = hssfWorkbook.createFont(); 
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); 
		//标题设置字体颜色为红色
		short color = HSSFColor.RED.index;
		font.setColor(color);//设置字体颜色为红色
		cellStyle.setFont(font);//将font对象赋给样式
		//设置列的宽度
		sheet.setColumnWidth(0,3000);
		sheet.setColumnWidth(1,9000);
		sheet.setColumnWidth(2,2000);
		sheet.setColumnWidth(3,2000);
		sheet.setColumnWidth(4,6000);
		sheet.setColumnWidth(5,6000);
		sheet.setColumnWidth(6,2000);
		sheet.setColumnWidth(7,2000);
		// 表头
		HSSFRow headRow = sheet.createRow(0);
		
		HSSFCell createCell0 = headRow.createCell(0);
		HSSFCell createCell1 = headRow.createCell(1);
		HSSFCell createCell2 = headRow.createCell(2);
		HSSFCell createCell3 = headRow.createCell(3);
		HSSFCell createCell4 = headRow.createCell(4);
		HSSFCell createCell5 = headRow.createCell(5);
		HSSFCell createCell6 = headRow.createCell(6);
		HSSFCell createCell7 = headRow.createCell(7);
		
		createCell0.setCellStyle(cellStyle);
		createCell1.setCellStyle(cellStyle);
		createCell2.setCellStyle(cellStyle);
		createCell3.setCellStyle(cellStyle);
		createCell4.setCellStyle(cellStyle);
		createCell5.setCellStyle(cellStyle);
		createCell6.setCellStyle(cellStyle);
		createCell7.setCellStyle(cellStyle);

		createCell0.setCellValue("序号");
		createCell1.setCellValue("书名");
		createCell2.setCellValue("评分");
		createCell3.setCellValue("评分人数");
		createCell4.setCellValue("作者");
		createCell5.setCellValue("出版社");
		createCell6.setCellValue("出版日期");
		createCell7.setCellValue("价格");
		
		//对books进行排序并评分返回前100
		List<Book> bookList = sort(books);
		
		// 表格数据
		for (Book book : bookList) {
			// 设置Sheet中最后一行的行号+1，或者for循环的时候用索引for(int
			// i=0;i<wayBills.size();i++)，用i的形式创建行号
			HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
			dataRow.createCell(0).setCellValue(book.getId());//序号
			dataRow.createCell(1).setCellValue(book.getTitle()+":"+book.getSubtitle());//书名
			dataRow.createCell(2).setCellValue(book.getRating().getAverage());//评分
			dataRow.createCell(3).setCellValue(book.getRating().getNumRaters());//评分人数
			dataRow.createCell(4).setCellValue(book.getAuthors());//作者
			dataRow.createCell(5).setCellValue(book.getPublisher());//出版社
			dataRow.createCell(6).setCellValue(book.getPubdate());//出版日期
			dataRow.createCell(7).setCellValue(book.getPrice());//价格
		}

		// 文件导出
		String filename = "书目清单(豆瓣).xls";
		File file = new File("D:\\temp");
		if(!file.exists()){
			file.mkdir();
		}
		FileOutputStream fos = null;
		try {
			//创建字节流
			fos = new FileOutputStream(new File("D:\\temp\\" + filename));
			// 将Excel文档写到输出流中
			hssfWorkbook.write(fos);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("文件导出失败");
		}finally {
			try {
				if(fos != null){
					fos.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			hssfWorkbook.close();
		}

	}
	/**
	 * 冒泡排序并返回评分前100的书目
	 * @param books
	 * @return
	 */
	private static List<Book> sort(List<Book> books) {
		
		for (int i = 0; i < books.size()-1; i++) {
			for (int j = i+1; j < books.size(); j++) {
				double iAverage = Double.parseDouble(books.get(i).getRating().getAverage());
				double jAverage = Double.parseDouble(books.get(j).getRating().getAverage());
				if(iAverage < jAverage){
					Book temp = books.get(j);
					books.set(j, books.get(i));
					books.set(i, temp);
				}
			}
		}
		
		List<Book> result = new ArrayList<Book>();
		
		for (int i = 0; i < 100; i++) {
			result.add(books.get(i));
		}
		return result;
	}
}
