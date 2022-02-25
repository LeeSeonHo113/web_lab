package site.metacoding.mvc.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import site.metacoding.mvc.config.DBConn;

// insert, delete, update, select하는 메서드 만들어서 재사용
public class MyUserRepository {
	
	private Connection conn;
	
	public MyUserRepository() {
		conn = DBConn.getConnection();
	}
	
	// SELECT * FROM myUser
	public List<MyUser> selectAll() {
		List<MyUser> myUsers = new ArrayList<>();
		
		return null;
	}
	
	// SELECT * FROM myUser WHERE id = ?
	public MyUser selectById(int id) {
		MyUser myUser = null;
		
		try {
			String sql = "SELECT * FROM myUser WHERE id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
		if(rs.next()) { // 한 건 밖에 없어서 굳이 while 돌릴 필요가 없다.
			myUser = new MyUser(
					rs.getInt("id"),
					rs.getString("username"),
					rs.getString("password"),
					rs.getString("email")
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return myUser;
	}
	
	// INSERT INTO myUser(id, username, password, email) VALUES(seq_myUser.nextval, ?, ?, ?)
	public int insert(String username, String password, String email) {
		int result = 0;
		
		return result;
	}
	
	// DELETE FROM myUser WHERE id = ?
	public int deleteById(int id) {
		int result = 0;
		
		try {
			String sql = "DELETE FROM myUser WHERE id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// UPDATE myUser SET username = ?, password = ?, email = ? WHERE id = ?
	public int updateById(int id, String username, String password, String email) {
		int result = 0;
		
		return result;
	}
}