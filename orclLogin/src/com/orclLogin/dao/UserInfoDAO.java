package com.orclLogin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.orclLogin.dto.UserInfoDTO;

public class UserInfoDAO {

//	①ログインの認証、ユーザー名の情報取得
	public UserInfoDTO select(String userId, String password) {
		UserInfoDTO dto = new UserInfoDTO();
		Connection con = getConnection();

		try{
			String sql ="select * from user_info where user_id = ? and password = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				dto.setUserName(rs.getString("user_name"));
				dto.setUserId(rs.getString("user_id"));
				dto.setPassword(rs.getString("password"));
			}
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			try {
				con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

//	②ユーザー登録時の重複IDの有無の確認
	public String checkId(String userId) {
		String result = null;
		Connection con = getConnection();

		try {
			String sql ="SELECT user_id FROM user_info WHERE user_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				result = rs.getString("user_id");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
			try {
				con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

//	③ユーザー情報の新規登録
	public void create(String userName, String userId, String password) {
		Connection con = getConnection();

		String sql ="INSERT INTO user_info (user_name, user_id, password) VALUES (?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, userId);
			ps.setString(3, password);
			ps.execute();

		} catch(Exception e) {
			e.printStackTrace();
		} finally{
			try {
				con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

//	④DBコネクタ
	public Connection getConnection() {
		Connection con = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	        final String url = "jdbc:oracle:thin:@localhost:1521:orcl19";
	        final String user = "HR";
	        final String pass = "HR";
			con = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
