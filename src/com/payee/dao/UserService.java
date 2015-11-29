package com.payee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.payee.domain.User;
import com.payee.utility.DBUtility;


public class UserService {
	
	private Connection connection;

	public UserService() {
		connection = DBUtility.getConnection();
	}
	
	public int getUserCount(){
		int count=0;
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select count(*) as count from user");		
			while (rs.next()) {
				count=rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public void addUser(User user) {
		try {
			
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into user(firstName,lastName,userId,email,dob,password,balance) values (?,?,?,?,?,?,? )");
			
			int i=0;
			preparedStatement.setString(++i, user.getFirstName());
			preparedStatement.setString(++i, user.getLastName());
			preparedStatement.setString(++i, user.getUserId());
			preparedStatement.setString(++i, user.getEmail());
			preparedStatement.setString(++i, user.getDob());
			preparedStatement.setString(++i, user.getPassword());
			preparedStatement.setString(++i, "0");
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser(String userId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from user where userId=?");

			preparedStatement.setString(1, userId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateUser(User user) throws ParseException {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update user set lastname=?,email=?" +
							"where userId=?");

			preparedStatement.setString(1, user.getLastName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getUserId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from user limit 15");
			while (rs.next()) {
				User user = new User();
				//user.setUserid(rs.getInt("userid"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));				
				user.setEmail(rs.getString("email"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}
	
	public User getUserById(String userId, String password ) {
		User user = new User();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from user where userId = ? and password = ?");
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, password);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setEmail(rs.getString("email"));
				user.setUserId(userId);
				user.setPassword(password);
				user.setValid(true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}

