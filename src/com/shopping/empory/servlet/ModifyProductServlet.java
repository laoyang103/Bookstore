package com.shopping.empory.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.empory.pojo.Product;
import com.shopping.empory.service.ProductService;
import com.shopping.empory.service.impl.ProductServiceImpl;

public class ModifyProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//为商品修改提供信息
		int productid = Integer.parseInt(request.getParameter("productid"));
		ProductService productService = ProductServiceImpl.getInstance();
		
		Product product = productService.getProductById(productid);
		double rebate = (product.getMemberprice()/product.getNormalprice())*100;
		rebate = (Math.round(rebate*2))/2;
		request.setAttribute("product", product);
		request.setAttribute("rebate",rebate);
		request.getRequestDispatcher("manage/goods_modify.jsp").forward(request, response);
		
	}

}
