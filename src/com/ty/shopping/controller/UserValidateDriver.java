package com.ty.shopping.controller;

import com.ty.shopping.dao.UserDao;
import com.ty.shopping.dto.UserDto;

public class UserValidateDriver {
	
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		UserDto userDto = userDao.validateUser("peter@mail.com","asdfghh");
		
		
		if(userDto != null) {
			System.out.println(userDto.getName());
			System.out.println(userDto.getMobile());
		}else {
			System.out.println("Email or Password is incorrect");
		}
		
		System.out.println(userDto);
		
	}
}
	

