package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCUtil;
import vo.Product;

public class ProductDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//상품 목록 보기
	public List<Product> getProductList(){
		List<Product> productList = new ArrayList<>();
		conn = JDBCUtil.getConnection();        //mysql에 연결
		String sql = "SELECT * FROM product";   //조회 쿼리문
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();          //반환 자료 가져옴
			while(rs.next()){  //자료가 있으면
				Product product = new Product();
				product.setProductId(rs.getString("p_id"));
				product.setPname(rs.getString("p_name"));
				product.setUnitPrice(rs.getInt("p_unitPrice"));
				product.setDescription(rs.getString("p_description"));
				product.setCategory(rs.getString("p_category"));
				product.setManufacturer(rs.getString("p_manufacturer"));
				product.setUnitsInStock(rs.getLong("p_unitsInStock"));
				product.setCondition(rs.getString("p_condition"));
				product.setProductImage(rs.getString("p_productImage"));
				productList.add(product);  //리스트에 저장
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return productList;
	}
	
	//상품 등록
	public void addProduct(Product product) {
		conn = JDBCUtil.getConnection();
		String sql = "INSERT INTO product(p_id, p_name, p_unitPrice, p_description, p_category,  "
				+ "p_manufacturer, p_unitsInStock, p_condition, p_productImage) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getProductId());
			pstmt.setString(2, product.getPname());
			pstmt.setInt(3, product.getUnitPrice());
			pstmt.setString(4, product.getDescription());
			pstmt.setString(5, product.getCategory());
			pstmt.setString(6, product.getManufacturer());
			pstmt.setLong(7, product.getUnitsInStock());
			pstmt.setString(8, product.getCondition());
			pstmt.setString(9, product.getProductImage());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
	
	//상품 상세 보기
	public Product getProduct(String productId) {
		Product product = new Product();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "SELECT * FROM product WHERE p_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productId);
			rs = pstmt.executeQuery();
			if(rs.next()){
				product.setProductId(rs.getString("p_id"));
				product.setPname(rs.getString("p_name"));
				product.setUnitPrice(rs.getInt("p_unitPrice"));
				product.setDescription(rs.getString("p_description"));
				product.setCategory(rs.getString("p_category"));
				product.setManufacturer(rs.getString("p_manufacturer"));
				product.setUnitsInStock(rs.getLong("p_unitsInStock"));
				product.setCondition(rs.getString("p_condition"));
				product.setProductImage(rs.getString("p_productImage"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return product;
	}
	
	//상품 삭제
	public void deleteProduct(String productId) {
		conn = JDBCUtil.getConnection();
		String sql = "DELETE FROM product WHERE p_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
	//상품 수정(이미지 있는 경우)
	public void updateProduct(Product product) {
		conn = JDBCUtil.getConnection();
		String sql = "UPDATE product SET p_name=?, p_unitPrice=?, p_description=?, "
				+ "p_category=?, p_manufacturer=?, p_unitsInStock=?, p_condition=?, "
				+ "p_productImage=? WHERE p_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getPname());
			pstmt.setInt(2, product.getUnitPrice());
			pstmt.setString(3, product.getDescription());
			pstmt.setString(4, product.getCategory());
			pstmt.setString(5, product.getManufacturer());
			pstmt.setLong(6, product.getUnitsInStock());
			pstmt.setString(7, product.getCondition());
			pstmt.setString(8, product.getProductImage());
			pstmt.setString(9, product.getProductId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
	//상품 수정(이미지 없는 경우)
	public void updateProductNoImage(Product product) {
		conn = JDBCUtil.getConnection();
		String sql = "UPDATE product SET p_name=?, p_unitPrice=?, p_description=?, "
				+ "p_category=?, p_manufacturer=?, p_unitsInStock=?, p_condition=? "
				+ "WHERE p_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getPname());
			pstmt.setInt(2, product.getUnitPrice());
			pstmt.setString(3, product.getDescription());
			pstmt.setString(4, product.getCategory());
			pstmt.setString(5, product.getManufacturer());
			pstmt.setLong(6, product.getUnitsInStock());
			pstmt.setString(7, product.getCondition());
			pstmt.setString(8, product.getProductId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
}
