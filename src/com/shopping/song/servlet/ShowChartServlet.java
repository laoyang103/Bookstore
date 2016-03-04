package com.shopping.song.servlet;

import java.awt.Font;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.data.general.DefaultPieDataset;

import com.shopping.empory.pojo.Product;
import com.shopping.empory.service.impl.ProductServiceImpl;
 /** 
 * 演示通过 servlet 直接输出图表
 * @author Winter Lau 
 */ 
 public class ShowChartServlet extends HttpServlet { 
	 public void service(ServletRequest req, ServletResponse res) 
		 throws ServletException, IOException 
	 { 
		 res.setContentType("image/jpeg"); 
		 DefaultPieDataset data = getDataSet(); 
		 configChartTheme();
		 JFreeChart chart = ChartFactory.createPieChart("商品销量分布图", data, true, false, false);
		 
		 ChartUtilities.writeChartAsJPEG(res.getOutputStream(), chart, 400, 300);
	 } 
	 /** 
	 * 获取一个演示用的简单数据集对象
	 * @return 
	 */ 
	 private static DefaultPieDataset getDataSet() { 
		 DefaultPieDataset dataset = new DefaultPieDataset(); 
		 
		 List<Product> products = ProductServiceImpl.getInstance().getProductBySum();
		 for (Product product : products) {
			dataset.setValue(product.getName(), product.getSalesCount());
		}
		 return dataset; 
	 } 
	 
	 private void configChartTheme() {
		//创建主题样式  
		   StandardChartTheme standardChartTheme=new StandardChartTheme("CN");  
		   //设置标题字体  
		   standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20));  
		   //设置图例的字体  
		   standardChartTheme.setRegularFont(new Font("宋书",Font.PLAIN,15));  
		   //设置轴向的字体  
		   standardChartTheme.setLargeFont(new Font("宋书",Font.PLAIN,15));  
		   //应用主题样式  
		   ChartFactory.setChartTheme(standardChartTheme); 
	}
	 
 } 