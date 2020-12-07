package com.model2.mvc.service.product.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductDao;
import com.model2.mvc.service.product.ProductService;




//@Service("productServiceImpl14")
public class ProductServiceImpl14 implements ProductService{
	
	///Field
	//@Autowired
	//@Qualifier("productDaoImpl14")
	private ProductDao productDao;
	
	public void setProductDao(ProductDao productDao) {
		System.out.println("::"+getClass()+".setProductDao Call....");
		this.productDao = productDao;
	}
	
	///Constructor
	public ProductServiceImpl14() {
		System.out.println("::"+getClass()+ "default Constructor Call....");
		
	}

	///Method
	public void insertProduct(Product product) throws Exception {
		productDao.insertProduct(product);   
	}

	public Product findProduct(String prodName) throws Exception {
		return productDao.findProduct(prodName);
	}
	
	public void updateProduct(Product product) throws Exception {
		productDao.updateProduct(product);
	}

	public Map<String , Object > getProductList(Search search) throws Exception {
		List<Product> list= productDao.getProductList(search);
		int totalCount = productDao.getTotalCount(search);
		
	
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list );
		map.put("totalCount", new Integer(totalCount));
		
		return map;
	}
	

	public int removeProduct(String productName) throws Exception{
		return productDao.removeProduct(productName); 
	}

	
}