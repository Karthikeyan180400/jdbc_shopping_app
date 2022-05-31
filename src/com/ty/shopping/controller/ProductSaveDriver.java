package com.ty.shopping.controller;

import com.ty.shopping.dao.ProductDao;
import com.ty.shopping.dto.ProductDto;

public class ProductSaveDriver {
	
   public static void main(String[] args) {
	   
	   ProductDto productDto = new ProductDto();
	   
	   productDto.setId(7);
	   productDto.setName("Surfexcel Blue");
	   productDto.setBrand("Surf Excel");
	   productDto.setType("Washing Powder");
	   productDto.setCost(10.00);
	   
	   ProductDao productDao = new ProductDao();
	   int res = productDao.saveProduct(productDto);
	   
	   if(res !=0 ) {
		   System.out.println("Data Inserted");
	   } else {
		   System.out.println("Data is not Inserted");
	   }
	   
	  
	   
	   
	
}

}
