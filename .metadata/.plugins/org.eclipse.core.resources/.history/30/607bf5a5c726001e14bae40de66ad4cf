package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.Product;
import product.ProductDAO;

@WebServlet("*.do")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductDAO productDAO;

	public void init(ServletConfig config) throws ServletException {
		productDAO = new ProductDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String command = uri.substring(uri.lastIndexOf("/"));
		System.out.println(command);
		
		String nextPage = null;
		
		if(command.equals("/productList.do")) { //상품 목록 페이지 요청
			
			List<Product> productList = productDAO.getProductList();
			
			//모델 생성
			request.setAttribute("productList", productList);
			
			nextPage = "/product/productList.jsp";
		}
		
		//페이지 포워딩
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
		
	}

}
