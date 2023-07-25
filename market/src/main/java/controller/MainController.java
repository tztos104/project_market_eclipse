package controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.MemberDAO;
import dao.ProductDAO;
import vo.Member;
import vo.Product;


@WebServlet("*.do")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 12L;
	
	ProductDAO productDAO = null;
	MemberDAO memberDAO = null;

	public void init(ServletConfig config) throws ServletException {
		productDAO = new ProductDAO();
		memberDAO = new MemberDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String uri = request.getRequestURI();
		String command = uri.substring(uri.lastIndexOf("/"));
		
		String nextPage = null;
		
		//세션 생성
		HttpSession session = request.getSession();
		
		if(command.equals("/productList.do")) { //상품 목록 
			
			List<Product> productList = productDAO.getProductList();
			
			request.setAttribute("productList", productList);
			
			nextPage = "/product/productList.jsp";
				
		}else if(command.equals("/productInfo.do")) { //상품 정보
			String productId = request.getParameter("productId");
			Product product = productDAO.getProduct(productId);
			
			request.setAttribute("product", product);
			
			nextPage = "/product/productInfo.jsp";
		}else if(command.equals("/productForm.do")) { //상품 등록 페이지 요청
			
			nextPage = "/product/productForm.jsp";
		}else if(command.equals("/addProduct.do")) { //상품 등록 처리
			String realFolder = "C:/ak/market/src/main/webapp/upload";

			MultipartRequest multi = new MultipartRequest(request, realFolder, 5*1024*1024,
					"utf-8", new DefaultFileRenamePolicy());
			
			//name 속성 가져오기(주의! multi를 사용)
			String productId = multi.getParameter("productId");
			String pname = multi.getParameter("pname");
			int unitPrice = Integer.parseInt(multi.getParameter("unitPrice"));
			String description = multi.getParameter("description");
			String category = multi.getParameter("category");
			String manufacturer = multi.getParameter("manufacturer");
			long unitsInStock = Long.parseLong(multi.getParameter("unitsInStock"));
			String condition = multi.getParameter("condition");
			
			//productImage 속성 가져옴
			Enumeration<String> files = multi.getFileNames();
			String name = "";
			String productImage = "";
			if(files.hasMoreElements()) {
				name = (String)files.nextElement();
				productImage = multi.getFilesystemName(name);
			}
			
			//Product 객체 생성
			Product newProduct = new Product();
			newProduct.setProductId(productId);
			newProduct.setPname(pname);
			newProduct.setUnitPrice(unitPrice);
			newProduct.setDescription(description);
			newProduct.setCategory(category);
			newProduct.setManufacturer(manufacturer);
			newProduct.setUnitsInStock(unitsInStock);
			newProduct.setCondition(condition);
			newProduct.setProductImage(productImage);
			
			productDAO.addProduct(newProduct);  //상품 등록 처리
		
			nextPage = "/productList.do";
		}else if(command.equals("/editProduct.do")) { //상품 편집 페이지
			List<Product> productList = productDAO.getProductList();
			
			String edit = request.getParameter("edit");
			
			request.setAttribute("productList", productList);
			request.setAttribute("edit", edit);
			
			nextPage = "/product/editProduct.jsp";
		}else if(command.equals("/deleteProduct.do")) { //상품 삭제 후 상품 삭제 페이지
			String id = request.getParameter("productId");
			String edit = request.getParameter("edit");
			
			productDAO.deleteProduct(id);
			
			//상품 삭제 페이지로 이동
			nextPage = "/editProduct.do?edit=delete";
		}else if(command.equals("/updateProductForm.do")) {
			String id = request.getParameter("productId");
			Product product = productDAO.getProduct(id);
			
			request.setAttribute("product", product);
			nextPage = "/product/updateProductForm.jsp";
		}else if(command.equals("/updateProduct.do")) {
			String realFolder = "C:/ak/market/src/main/webapp/upload";

			MultipartRequest multi = new MultipartRequest(request, realFolder, 5*1024*1024,
					"utf-8", new DefaultFileRenamePolicy());
			
			//name 속성 가져오기(주의! multi를 사용)
			String productId = multi.getParameter("productId");
			String pname = multi.getParameter("pname");
			int unitPrice = Integer.parseInt(multi.getParameter("unitPrice"));
			String description = multi.getParameter("description");
			String category = multi.getParameter("category");
			String manufacturer = multi.getParameter("manufacturer");
			long unitsInStock = Long.parseLong(multi.getParameter("unitsInStock"));
			String condition = multi.getParameter("condition");
			
			//productImage 속성 가져옴
			Enumeration<String> files = multi.getFileNames();
			String name = "";
			String productImage = "";
			if(files.hasMoreElements()) {
				name = (String)files.nextElement();
				productImage = multi.getFilesystemName(name);
			}
			
			//Product 객체 생성
			Product upProduct = new Product();
			upProduct.setProductId(productId);
			upProduct.setPname(pname);
			upProduct.setUnitPrice(unitPrice);
			upProduct.setDescription(description);
			upProduct.setCategory(category);
			upProduct.setManufacturer(manufacturer);
			upProduct.setUnitsInStock(unitsInStock);
			upProduct.setCondition(condition);
			upProduct.setProductImage(productImage);
			
			if(productImage != null) { //상품 이미지 수정을 할 경우
				productDAO.updateProduct(upProduct);
			}else {
				productDAO.updateProductNoImage(upProduct);
			}
			
			nextPage = "/editProduct.do?edit=update";
		}
		
		else if(command.equals("/addCart.do")) { //장바구니에 담기 처리	
			String id = request.getParameter("productId");
			
			//상품 목록 리스트를 생성하고 상품을 저장함
			List<Product> goodsList = productDAO.getProductList();
			Product goods = new Product();
			
			for(int i=0; i<goodsList.size(); i++) {
				 goods = goodsList.get(i);
				 if(goods.getProductId().equals(id)) 
					 break;
			}
			
			//요청 아이디의 상품을 담은 장바구니를 초기화 함
			List<Product> list = (ArrayList<Product>)session.getAttribute("cartlist");
			if(list == null) {
				list = new ArrayList<>();
				session.setAttribute("cartlist", list);	 //장바구니 세션 발급
			}
			
			//요청 아이디의 상품이 장바구니에 담긴 목록이면 해당 상품의 수량을 증가시킴
			int cnt = 0;
			Product goodsQnt = new Product(); 
			
			for(int i=0; i<list.size(); i++){
				goodsQnt = list.get(i);
				if(goodsQnt.getProductId().equals(id)){
					cnt++;	//횟수 1증가
					int orderQuantity = goodsQnt.getQuantity() + 1;	//주문 수량 합계
					goodsQnt.setQuantity(orderQuantity);
				}
			}
			
			//장바구니에 담긴 목록이 아니면 해당 상품의 수량을 1로하고, 장바구니 목록에 추가함
			if(cnt == 0) {
				goods.setQuantity(1);
				list.add(goods);
			}
		}else if(command.equals("/cart.do")) { //장바구니 페이지
			//장바구니에 세션 가져오기(세션 유지)
			ArrayList<Product> cartList = (ArrayList<Product>)session.getAttribute("cartlist");
			if(cartList == null){
				cartList = new ArrayList<>();
			}
			
			Product product = null;
			int sum = 0;
			int total = 0;
			for(int i=0; i<cartList.size(); i++){
				product = cartList.get(i);	//장바구니에 들어있는 상품
				total = product.getUnitPrice() * product.getQuantity();	//품목별 합계 = 가격 x 수량					
				sum += total;   //총액
			}
			
			String cartId = session.getId();  //cartId - 주문 코드로 사용
			
			//모델 생성
			request.setAttribute("cartList", cartList);
			request.setAttribute("sum", sum);
			request.setAttribute("cartId", cartId);
			
			nextPage = "/product/cart.jsp";
		}else if(command.equals("/removeCart.do")) { //장바구니의 개별 품목 삭제
			String id = request.getParameter("productId");
			
			//장바구니 가져오기(세션 유지)
			ArrayList<Product> cartList = (ArrayList<Product>)session.getAttribute("cartlist");
			
			Product selProduct = new Product();  //삭제할 품목 선택
			for(int i=0; i<cartList.size(); i++) {
				selProduct = cartList.get(i);
				if(selProduct.getProductId().equals(id)) { //외부 입력된 상품코드와 일치하면
					cartList.remove(selProduct); //해당 품목 삭제
				}	
			}
		}else if(command.equals("/deleteCart.do")) {  //장바구니 초기화(삭제)
			session.invalidate(); //장바구니 세션 삭제
		}else if(command.equals("/shippingInfo.do")) {
			
			String cartId = request.getParameter("cartId");
			
			request.setAttribute("cartId", cartId);
			
			nextPage = "/product/shippingInfo.jsp?cartId=" + cartId;
		}else if(command.equals("/processShippingInfo.do")) {
			//쿠키 발행
			Cookie shippingId = new Cookie("Shipping_cartId", 
					URLEncoder.encode(request.getParameter("cartId"), "utf-8"));  //쿠키 이름 - 주문번호
			Cookie name = new Cookie("Shipping_name", 
					URLEncoder.encode(request.getParameter("name"), "utf-8"));  //쿠키 이름 - 이름
			Cookie shippingDate = new Cookie("Shipping_shippingDate", 
					URLEncoder.encode(request.getParameter("shippingDate"), "utf-8"));  //쿠키 이름 - 배송일
			Cookie country = new Cookie("Shipping_country", 
					URLEncoder.encode(request.getParameter("country"), "utf-8"));  //쿠키 이름 - 국가
			Cookie zipCode = new Cookie("Shipping_zipCode", 
					URLEncoder.encode(request.getParameter("zipCode"), "utf-8"));  //쿠키 이름 - 우편번호
			Cookie addressName = new Cookie("Shipping_addressName", 
					URLEncoder.encode(request.getParameter("addressName"), "utf-8"));  //쿠키 이름 - 주소
					
			//쿠키 유효기간 1일
			shippingId.setMaxAge(24*60*60);
			name.setMaxAge(24*60*60);
			shippingDate.setMaxAge(24*60*60);
			country.setMaxAge(24*60*60);
			zipCode.setMaxAge(24*60*60);
			addressName.setMaxAge(24*60*60);
			
			//클라이언트 컴으로 쿠키 보내기
			response.addCookie(shippingId);
			response.addCookie(name);
			response.addCookie(shippingDate);
			response.addCookie(country);
			response.addCookie(zipCode);
			response.addCookie(addressName);
			
			//쿠키를 받아서 사용할 변수
			//String cartId = session.getId();   //주문번호 - 세션 아이디
			String shipping_cartId = "";       //주문번호
			String shipping_name = "";         //주문자 이름
			String shipping_shippingDate = ""; //배송일
			String shipping_country = "";      //국가
			String shipping_zipCode = "";      //우편번호
			String shipping_addressName = "";  //주소
			
			Cookie[] cookies = request.getCookies(); //쿠기 받기(배열)
			
			if(cookies != null){
				for(int i=0; i<cookies.length; i++){
					Cookie cookie = cookies[i];
					String cname = cookie.getName();  //쿠키이름
					if(cname.equals("Shipping_cartId")) //쿠기이름과 같으면
						//쿠키 값을 가져옴
						shipping_cartId = URLDecoder.decode(cookie.getValue(), "utf-8");
					if(cname.equals("Shipping_name"))
						shipping_name = URLDecoder.decode(cookie.getValue(), "utf-8");
					if(cname.equals("Shipping_shippingDate"))
						shipping_shippingDate = URLDecoder.decode(cookie.getValue(), "utf-8");
					if(cname.equals("Shipping_country"))
						shipping_country = URLDecoder.decode(cookie.getValue(), "utf-8");
					if(cname.equals("Shipping_zipCode"))
						shipping_zipCode = URLDecoder.decode(cookie.getValue(), "utf-8");
					if(cname.equals("Shipping_addressName"))
						shipping_addressName = URLDecoder.decode(cookie.getValue(), "utf-8");
				}
			}
			
			String cartId = request.getParameter("cartId");
			
			//장바구니에 세션 가져오기(세션 유지)
			ArrayList<Product> cartList = (ArrayList<Product>)session.getAttribute("cartlist");
			if(cartList == null){
				cartList = new ArrayList<>();
			}
			
			Product product = null;
			int sum = 0;
			int total = 0;
			for(int i=0; i<cartList.size(); i++){
				product = cartList.get(i);	//장바구니에 들어있는 상품
				total = product.getUnitPrice() * product.getQuantity();	//품목별 합계 = 가격 x 수량					
				sum += total;   //총액
			}
			
			//모델 - 쿠키
			request.setAttribute("shipping_name", shipping_name);
			request.setAttribute("shipping_shippingDate", shipping_shippingDate);
			request.setAttribute("shipping_zipCode", shipping_zipCode);
			request.setAttribute("shipping_addressName", shipping_addressName);
			
			//모델 - 계산
			request.setAttribute("cartList", cartList);
			request.setAttribute("sum", sum);
			request.setAttribute("cartId", cartId);
			
			nextPage = "/product/orderConfirm.jsp";
		}else if(command.equals("/thanksCustomer.do")) { //주문 완료 페이지 요청
			String shipping_cartId = "";
			String shipping_shippingDate = "";
			
			Cookie[] cookies = request.getCookies();
			
			if(cookies != null){
				for(int i=0; i<cookies.length; i++){
					Cookie cookie = cookies[i];
					String name = cookie.getName();
					if(name.equals("Shipping_cartId"))
						shipping_cartId = URLDecoder.decode(cookie.getValue(), "utf-8");
					if(name.equals("Shipping_shippingDate"))
						shipping_shippingDate = URLDecoder.decode(cookie.getValue(), "utf-8");
				}
			}
			
			request.setAttribute("shipping_cartId", shipping_cartId);
			request.setAttribute("shipping_shippingDate", shipping_shippingDate);
			
			//모든 세션 삭제
			session.invalidate();

		    //모든 쿠키 삭제
		    if(cookies != null){
				for(int i=0; i<cookies.length; i++){
					Cookie cookie = cookies[i];
					String name = cookie.getName();
					if(name.equals("Shipping_cartId"))
						cookie.setMaxAge(0);   //유효 기간을 0 - 삭제
					if(name.equals("Shipping_name"))
						cookie.setMaxAge(0);
					if(name.equals("Shipping_shippingDate"))
						cookie.setMaxAge(0);
					if(name.equals("Shipping_country"))
						cookie.setMaxAge(0);
					if(name.equals("Shipping_zipCode"))
						cookie.setMaxAge(0);
					if(name.equals("Shipping_addressName"))
						cookie.setMaxAge(0);
					
					//클라이언트 컴에 삭제된 쿠키 보내줌
					response.addCookie(cookie);
				}
			}
			
		    //주문 완료 페이지 이동
			nextPage = "/product/thanksCustomer.jsp";
		}else if(command.equals("/checkOutCancel.do")) { //주문 취소 페이지 요청
			nextPage = "/product/checkOutCancel.jsp";
		}
		
		//회원 Control
		if(command.equals("/memberList.do")) { //회원 목록
			List<Member> memberList = memberDAO.getMemberList();
			request.setAttribute("memberList", memberList);
			nextPage = "/member/memberList.jsp";
		} else if(command.equals("/memberForm.do")) { //회원 가입 폼 요청
			nextPage = "/member/memberForm.jsp";
		} else if(command.equals("/addMember.do")) {  //회원 가입 처리
			//폼 데이터 받기  
			String mid = request.getParameter("mid");
			String passwd = request.getParameter("passwd1");
			String mname = request.getParameter("mname");
			String gender = request.getParameter("gender");
			//birth
			String year = request.getParameter("birthyy");
			String month = request.getParameterValues("birthmm")[0];
			String day = request.getParameter("birthdd");
			String birth = year + "/" + month + "/" + day;
			//email
			String email1 = request.getParameter("email1");
			String email2 = request.getParameterValues("email2")[0];
			String email = email1 + "@" + email2;
	
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			
			Member newMember = new Member();  //회원 객체 생성
			newMember.setMid(mid);
			newMember.setPasswd(passwd);
			newMember.setMname(mname);
			newMember.setGender(gender);
			newMember.setBirth(birth);
			newMember.setPhone(phone);
			newMember.setEmail(email);
			newMember.setAddress(address);
			
			session.setAttribute("sessionId", mid);  //세션 발급
			
			memberDAO.addMember(newMember);  //회원 가입 및 자동 로그인
			
			nextPage="index.jsp";
		}else if(command.equals("/loginForm.do")) { //로그인 페이지 요청
			nextPage = "/member/loginForm.jsp";
		}else if(command.equals("/processLogin.do")) { //로그인 처리
			String mid = request.getParameter("mid");
			String passwd = request.getParameter("passwd");
			
			Member member = new Member();
			member.setMid(mid);
			member.setPasswd(passwd);
			
			boolean result = memberDAO.checkLogin(member);
			if(result) {
				session.setAttribute("sessionId", mid);
				nextPage = "index.jsp";
			}else {
				String error = "아이디나 비밀번호를 확인해 주세요";
				request.setAttribute("error", error);
				nextPage = "/loginForm.do";
			}
		}else if(command.equals("/logout.do")) { //로그아웃
			session.invalidate();
			nextPage = "index.jsp";
		}else if(command.equals("/memberInfo.do")) {  //나의 정보
			String mid = request.getParameter("mid");
			Member member = memberDAO.getMember(mid);
			request.setAttribute("member", member);
			nextPage = "/member/memberInfo.jsp";
		}
		
		//페이지 이동 - 포워딩
		if(command.equals("/addCart.do")) {
			String id = request.getParameter("productId");
			
			response.sendRedirect("/productInfo.do?productId=" + id);  //상세 정보 페이지 이동
		}else if(command.equals("/removeCart.do") || command.equals("/deleteCart.do")) {
			response.sendRedirect("/cart.do");  //장바구니 페이지로 이동
		}
		else {
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher(nextPage);
			
			dispatcher.forward(request, response);
		}
	}
	
	public void destroy() {
		System.out.println("Servlet 해제...");
	}

}
