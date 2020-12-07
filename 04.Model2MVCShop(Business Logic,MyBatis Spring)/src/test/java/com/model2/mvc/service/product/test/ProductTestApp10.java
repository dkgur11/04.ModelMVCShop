package com.model2.mvc.service.product.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.model2.mvc.common.Search;
import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;



import org.apache.ibatis.session.SqlSession;


public class ProductTestApp10 {
	
	///main method
	public static void main(String[] args) throws Exception{
	
		//==> SqlSessionFactoryBean.getSqlSession()을 이용 SqlSession instance GET
		SqlSession sqlSession = SqlSessionFactoryBean.getSqlSession();
		System.out.println("\n");
		
	
		Product product  = new Product();
		product.setProdName("참치");
		product.setPrice(2000);
		product.setProdDetail("고추참지");
		product.setFileName("고추참치참치");
		
		
		
		
		System.out.println(":: 1. insertProduct(INSERT)  ? ");
		System.out.println(":: "+ sqlSession.insert("ProductMapper.insertProduct",product));
		System.out.println("\n");
		
		
		System.out.println(":: 2. findProduct(SELECT)  ? ");
		System.out.println(":: "+sqlSession.selectOne("ProductMapper.findProduct",product.getProdName()));
		System.out.println("\n");
		  
		product.setProdName("사과");
		product.setProdDetail("맛있는사과");
		//product.setPrice(5000);
		//product.setFileName("사과사과");
		System.out.println(":: 3. updateProduct(UPDATE)  ? ");
		System.out.println(":: "+ sqlSession.update("ProductMapper.updateProduct",product));
		System.out.println("\n");
		
		
		System.out.println(":: 4. findProduct(SELECT)  ? ");
		System.out.println(":: "+sqlSession.selectOne("ProductMapper.findProduct",product.getProdName()));
		System.out.println("\n");
		 
		
		 
	 	 
		 System.out.println(":: 5. Product.removeProduct (DELETE)  ? ");
		 System.out.println(":: "+sqlSession.delete("ProductMapper.removeProduct",product.getProdName())); 
		 System.out.println("\n"); 
		 
		 
		  
		 
		 Search search = new Search();
		 
		 search.setCurrentPage(1);
		 search.setPageSize(3);
		 search.setSearchCondition("1");
		 search.setSearchKeyword("자전거");
		 
		System.out.println(":: 1. getProductList(SELECT)  ? ");
		SqlSessionFactoryBean.printList( sqlSession.selectList("ProductMapper.getProductList",search) );	
		
		

		//END::SqlSession  close
		System.out.println("::END::SqlSession 닫기..");
		sqlSession.close();
		
	}//end of main
}//end of class