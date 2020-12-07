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

		//==> Bean/IoC Container �� ���� ȹ���� UserService �ν��Ͻ� ȹ��
		ProductService productService =(ProductService)context.getBean("productServiceImpl12");
		
		System.out.println("\n");
		

		Product product  = new Product();
		
		
		product.setProdName("��ġ");
		product.setPrice(2000);
		product.setProdDetail("��������");
		product.setFileName("������ġ��ġ");
		
		
		
		
		System.out.println(":: 1. insertProduct(INSERT)  ? ");
		productService.insertProduct(product);
		System.out.println(":: "+product);
		System.out.println("\n");
		
		
		System.out.println(":: 2. findProduct(SELECT)  ? ");
		System.out.println(":: "+productService.findProduct(product.getProdName()));
		System.out.println("\n");
		  
		product.setProdName("���");
		product.setProdDetail("���ִ»��");
		//product.setPrice(5000);
		//product.setFileName("������");
		System.out.println(":: 3. updateProduct(UPDATE)  ? ");
		productService.updateProduct(product);
		System.out.println(":: "+ product);
		System.out.println("\n");
		
		
		
		Search search = new Search();
		
		 search.setCurrentPage(1);
		 search.setPageSize(3);
		 search.setSearchCondition("1");
		 search.setSearchKeyword("������");
		 
		
		System.out.println(":: 4.getProductList(SELECT)  ? ");
		System.out.println(":: "+ productService.getProductList(search));
		System.out.println("\n");
		 
		
		
		System.out.println(":: 5. Product.removeProduct (DELETE)  ? ");
		System.out.println(":: "+productService.removeProduct(product.getProdName())); 
		System.out.println("\n"); 
		 
		 
		  
		 
		
		 
		
		
		
		

		//END::SqlSession  close
		System.out.println("::END::SqlSession �ݱ�..");
		
		
		
		
	
	}//end of main
}//end of class