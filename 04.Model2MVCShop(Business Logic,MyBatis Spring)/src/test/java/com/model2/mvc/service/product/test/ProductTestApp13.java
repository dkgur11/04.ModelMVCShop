package com.model2.mvc.service.product.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;

/*
 * FileName : MyBatisTestApp13.java
  * :: Business Layer unit Test : Service + Persistence (Spring +mybatis + DAO)
  */
public class ProductTestApp13 {
	
	///main method
	public static void main(String[] args) throws Exception{

		ApplicationContext context =
			new ClassPathXmlApplicationContext(
																new String[] {	"/config/commonservice13.xml",
																					"/config/productservice13.xml" }
								                                  );
		System.out.println("\n");

		//==> Bean/IoC Container 로 부터 획득한 UserService 인스턴스 획득
		ProductService productService =(ProductService)context.getBean("productServiceImpl12");
		
		System.out.println("\n");
		

		Product product  = new Product();
		
		
		product.setProdName("참치");
		product.setPrice(2000);
		product.setProdDetail("고추참지");
		product.setFileName("고추참치참치");
		
		
		
		
		System.out.println(":: 1. insertProduct(INSERT)  ? ");
		productService.insertProduct(product);
		System.out.println(":: "+product);
		System.out.println("\n");
		
		
		System.out.println(":: 2. findProduct(SELECT)  ? ");
		System.out.println(":: "+productService.findProduct(product.getProdName()));
		System.out.println("\n");
		  
		product.setProdName("사과");
		product.setProdDetail("맛있는사과");
		//product.setPrice(5000);
		//product.setFileName("사과사과");
		System.out.println(":: 3. updateProduct(UPDATE)  ? ");
		productService.updateProduct(product);
		System.out.println(":: "+ product);
		System.out.println("\n");
		
		
		
		Search search = new Search();
		
		 search.setCurrentPage(1);
		 search.setPageSize(3);
		 search.setSearchCondition("1");
		 search.setSearchKeyword("자전거");
		 
		
		System.out.println(":: 4.getProductList(SELECT)  ? ");
		System.out.println(":: "+ productService.getProductList(search));
		System.out.println("\n");
		 
		
		
		System.out.println(":: 5. Product.removeProduct (DELETE)  ? ");
		System.out.println(":: "+productService.removeProduct(product.getProdName())); 
		System.out.println("\n"); 
		 
		 
		  
		 
		
		 
		
		
		
		

		//END::SqlSession  close
		System.out.println("::END::SqlSession 닫기..");
		
		
		
		
	
	}//end of main
}//end of class