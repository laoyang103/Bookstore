package com.shopping.empory.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.empory.pojo.Product;
import com.shopping.empory.service.ProductService;
import com.shopping.empory.service.impl.CategoryServiceImpl;
import com.shopping.empory.service.impl.ProductServiceImpl;

public class SearchProductsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int pid = Integer.parseInt(request.getParameter("pid"));
		String name = request.getParameter("name");
		String supername = "全部分类";
		List<Product> searchproducts = null;
		if(pid != 0){
			searchproducts = ProductServiceImpl.getInstance().getProductByName(pid, name);
			supername = CategoryServiceImpl.getInstance().getCategoryById(pid).getName();
		}else{
			searchproducts = ProductServiceImpl.getInstance().getAllProductByName(name);
		}
		
		request.setAttribute("searchproducts", searchproducts);
		request.setAttribute("supername", supername);
		request.setAttribute("name", name);
		
		request.getRequestDispatcher("search_deal.jsp").forward(request, response);
	}

}
