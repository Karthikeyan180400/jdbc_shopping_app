package com.ty.shopping.controller;

import com.ty.shopping.dao.ProductDao;

public class ProductGetDriver {

	public static void main(String[] args) {

     ProductDao productDao = new ProductDao();
    // System.out.println(productDao.getProductById(1));
     //System.out.println(productDao.getAllProduct());
     //System.out.println(productDao.getProductByBrand("colgate"));
     System.out.println(productDao.getProductByBrandAndType("colgate", "Tooth Paste"));
     

	}

}
