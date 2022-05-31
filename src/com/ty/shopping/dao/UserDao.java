package com.ty.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ty.shopping.dto.UserDto;
import com.ty.shopping.util.AES;
import com.ty.shopping.util.ConnectionObject;
import static com.ty.shopping.util.AppConstants.SECRET_KEY;

public class UserDao {
	
	
	public int saveUser(UserDto userDto) {
		String query = "insert into user values(?,?,?,?,?)";
		Connection connection = ConnectionObject.getConnection();
		try {
			
			String enc = AES.encrypt(userDto.getPassword(), SECRET_KEY);
		    System.out.println(AES.decrypt(enc, SECRET_KEY));
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, userDto.getId());
			preparedStatement.setString(2, userDto.getName());
			preparedStatement.setString(3, userDto.getEmail());
			preparedStatement.setString(4, enc);
			preparedStatement.setLong(5, userDto.getMobile());
			
			return preparedStatement.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
		  try {
			  if(connection != null) {
			connection.close();
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
		
		return 0;
	}
	
	public UserDto validateUser(String email,String password) {
		String query = "select * from user where email=? and password=?";
		Connection connection = ConnectionObject.getConnection();
		String enc = AES.encrypt(password,SECRET_KEY);
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, enc);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				UserDto userDto = new UserDto();
				userDto.setId(resultSet.getInt(1));
				userDto.setName(resultSet.getString(2));
				userDto.setEmail(resultSet.getString(3));
				userDto.setMobile(resultSet.getLong(5));
				return userDto;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
