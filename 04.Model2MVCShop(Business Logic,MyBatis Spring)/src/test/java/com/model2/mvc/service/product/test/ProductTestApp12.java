package com.model2.mvc.service.product.test;

import java.util.ArrayList;



import org.apache.ibatis.session.SqlSession;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.impl.ProductDaoImpl11;
import com.model2.mvc.service.product.impl.ProductServiceImpl12;

/*
 * FileName : MyBatisTestApp11.java 
 *  :: Persistence Layer unit Test : MyBatis + DAO
  */
public class ProductTestApp12 {
	
	///main method
	public static void main(String[] args) throws Exception{

		SqlSession sqlSession = SqlSessionFactoryBean.getSqlSession();
		
		
		ProductDaoImpl11 productDao = new ProductDaoImpl11();
		productDao.setSqlSession(sqlSession);
		
		
		ProductServiceImpl12 productService = new ProductServiceImpl12();
		productService.setProductDao(productDao);
		System.out.println("\n");
		
	
		Product product  = new Product();
		
		
		product.setProdName("��ġ");
		product.setPrice(2000);
		product.setProdDetail("��������");
		product.setFileName("������ġ��ġ");
		
		
		
		
		System.out.println(":: 1. insertProduct(INSERT)  ? ");
		System.out.println(":: "+ sqlSession.insert("ProductMapper.insertProduct",product));
		System.out.println("\n");
		
		
		System.out.println(":: 2. findProduct(SELECT)  ? ");
		System.out.println(":: "+sqlSession.selectOne("ProductMapper.findProduct",product.getProdName()));
		System.out.println("\n");
		  
		product.setProdName("���");
		product.setProdDetail("���ִ»��");
		//product.setPrice(5000);
		//product.setFileName("������");
		System.out.println(":: 3. updateProduct(UPDATE)  ? ");
		System.out.println(":: "+ sqlSession.update("ProductMapper.updateProduct",product));
		System.out.println("\n");
		
		
		
		System.out.println(":: 4.getProductList(SELECT)  ? ");
		System.out.println(":: "+sqlSession.selectOne("ProductMapper.findProduct",product.getProdName()));
		System.out.println("\n");
		 
		
		 
	 	 
		 System.out.println(":: 5. Product.removeProduct (DELETE)  ? ");
		 System.out.println(":: "+sqlSession.delete("ProductMapper.removeProduct",product.getProdName())); 
		 System.out.println("\n"); 
		 
		 
		  
		 
		 Search search = new Search();
		 
		 search.setCurrentPage(1);
		 search.setPageSize(3);
		 search.setSearchCondition("1");
		 search.setSearchKeyword("����");
		 
		System.out.println(":: 1. getProductList(SELECT)  ? ");
		SqlSessionFactoryBean.printList( sqlSession.selectList("ProductMapper.getProductList",search) );	
		
		

		//END::SqlSession  close
		System.out.println("::END::SqlSession �ݱ�..");
		sqlSession.close();
		
		
	}//end of main
}//end of class