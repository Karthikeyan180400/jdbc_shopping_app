package com.ty.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ty.shopping.dto.ProductDto;
import com.ty.shopping.util.ConnectionObject;

public class ProductDao {
	Connection connection = null;

	public int saveProduct(ProductDto productDto) {
		connection = ConnectionObject.getConnection();
		String query = "insert into product value(?,?,?,?,?)";

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, productDto.getId());
			preparedStatement.setString(2, productDto.getName());
			preparedStatement.setString(3, productDto.getType());
			preparedStatement.setString(4, productDto.getBrand());
			preparedStatement.setDouble(5, productDto.getCost());

			return preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return 0;

	}

	public ProductDto getProductById(int id) {
		connection = ConnectionObject.getConnection();
		String query = "select * from product where id=?";

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				ProductDto productDto = new ProductDto();
				productDto.setId(resultSet.getInt(1));
				productDto.setName(resultSet.getString(2));
				productDto.setBrand(resultSet.getString(3));
				productDto.setType(resultSet.getString(4));
				productDto.setCost(resultSet.getDouble(5));
				return productDto;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;

	}

	public List<ProductDto> getAllProduct() {
		connection = ConnectionObject.getConnection();
		String query = "select * from product";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			ResultSet resultSet = preparedStatement.executeQuery();
			ProductDto productDto = new ProductDto();
			List<ProductDto> list = new ArrayList<ProductDto>();
			while (resultSet.next()) {
				productDto.setId(resultSet.getInt(1));
				productDto.setName(resultSet.getString(2));
				productDto.setType(resultSet.getString(3));
				productDto.setBrand(resultSet.getString(4));
				productDto.setCost(resultSet.getDouble(5));

				list.add(productDto);
			}

			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return null;

	}

	public List<ProductDto> getProductByBrand(String brand) {
		connection = ConnectionObject.getConnection();
		String query = "select * from product where brand=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, brand);

			ResultSet resultSet = preparedStatement.executeQuery();
			List<ProductDto> list = new ArrayList<ProductDto>();
			while (resultSet.next()) {
				ProductDto productDto = new ProductDto();
				productDto.setId(resultSet.getInt(1));
				productDto.setName(resultSet.getString(2));
				productDto.setType(resultSet.getString(3));
				productDto.setBrand(resultSet.getString(4));
				productDto.setCost(resultSet.getDouble(5));

				list.add(productDto);
			}

			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<ProductDto> getProductByBrandAndType(String brand, String type) {
		connection = ConnectionObject.getConnection();
		String query = "select * from product where type=? and brand=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, type);
			preparedStatement.setString(2,brand);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			List<ProductDto> list  = new ArrayList<ProductDto>();
			while(resultSet.next()) {
				ProductDto productDto = new ProductDto();
				productDto.setId(resultSet.getInt(1));
				productDto.setName(resultSet.getString(2));
				productDto.setType(resultSet.getString(3));
				productDto.setBrand(resultSet.getString(4));
				productDto.setCost(resultSet.getDouble(5));
				
				list.add(productDto);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return null;

	}

}
