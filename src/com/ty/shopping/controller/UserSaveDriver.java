package com.ty.shopping.controller;

import com.ty.shopping.dao.UserDao;
import com.ty.shopping.dto.UserDto;

public class UserSaveDriver {
	public static void main(String[] args) {
		
		UserDto userDto = new UserDto(); 
		
		userDto.setId(13);
		userDto.setName("Peter");
		userDto.setEmail("peter@mail.com");
		userDto.setPassword("asdfghh");
		userDto.setMobile(8989890);
		
		
		UserDao userDao = new UserDao();
		int res = userDao.saveUser(userDto);
		if(res >0 ){
			System.out.println("Data inserted");			
		} else {
			System.out.println("Data not inserted");
		}
	}
}
