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

public class AddProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductService productService = ProductServiceImpl.getInstance();

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int categoryid = Integer.parseInt(request.getParameter("categoryid"));
		String productname = request.getParameter("productname");
		double normalprice =  Double.parseDouble(request.getParameter("normalprice"));
		double memberprice = Double.parseDouble(request.getParameter("memberprice"));
		int ifspecial = Integer.parseInt(request.getParameter("ifspecial"));
		String img = request.getParameter("img");
		String desr = request.getParameter("desr");
		
		Product product = new Product();
		product.setCategoryid(categoryid);
		product.setName(productname);
		product.setNormalprice(normalprice);
		product.setMemberprice(memberprice);
		product.setIfspecial(ifspecial);
		product.setImg(img);
		product.setDescr(desr);
		int result = productService.addProduct(product);
		
		if(result == 1) {
			out.print("添加成功");
		} else {
			out.print("添加失败");
		}
		
		out.flush();
		out.close();
	}

}
