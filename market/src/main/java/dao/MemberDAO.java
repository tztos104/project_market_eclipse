package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCUtil;
import vo.Member;
import vo.Product;

public class MemberDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//회원 전체 목록
	public List<Member> getMemberList(){
		List<Member> memberList = new ArrayList<>();
		conn = JDBCUtil.getConnection();  //mysql에 연결
		String sql = "SELECT * FROM member ORDER BY regdate DESC"; //조회 쿼리문
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();  //반환 자료 가져옴
			while(rs.next()){  //자료가 있으면
				Member member = new Member();
				member.setMid(rs.getString("mid"));
				member.setPasswd(rs.getString("passwd"));
				member.setMname(rs.getString("mname"));
				member.setGender(rs.getString("gender"));
				member.setBirth(rs.getString("birth"));
				member.setPhone(rs.getString("phone"));
				member.setEmail(rs.getString("email"));
				member.setAddress(rs.getString("address"));
				member.setRegDate(rs.getTimestamp("regdate"));
				memberList.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return memberList;
	}
	
	//회원 가입
	public void addMember(Member member) {
		conn = JDBCUtil.getConnection();
		String sql = "INSERT INTO member(mid, passwd, mname, gender, birth, phone, "
					+ "email, address) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMid());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getMname());
			pstmt.setString(4, member.getGender());
			pstmt.setString(5, member.getBirth());
			pstmt.setString(6, member.getPhone());
			pstmt.setString(7, member.getEmail());
			pstmt.setString(8, member.getAddress());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
	//회원 정보
	public Member getMember(String mid){
		Member member = new Member();
		conn = JDBCUtil.getConnection();      
		String sql = "SELECT * FROM member WHERE mid = ?";  
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();          
			if(rs.next()){  //자료가 있으면
				member.setMid(rs.getString("mid"));
				member.setPasswd(rs.getString("passwd"));
				member.setMname(rs.getString("mname"));
				member.setGender(rs.getString("gender"));
				member.setBirth(rs.getString("birth"));
				member.setPhone(rs.getString("phone"));
				member.setEmail(rs.getString("email"));
				member.setAddress(rs.getString("address"));
				member.setRegDate(rs.getTimestamp("regdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return member;
	}
	
	//로그인 체크
	public boolean checkLogin(Member member) {
		conn = JDBCUtil.getConnection();
		String sql = "SELECT * FROM member WHERE mid = ? and passwd = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMid());
			pstmt.setString(2, member.getPasswd());
			rs = pstmt.executeQuery();
			if(rs.next())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return false;
	}
}
