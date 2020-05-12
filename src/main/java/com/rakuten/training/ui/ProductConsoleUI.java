package com.rakuten.training.ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rakuten.training.domain.Product;
import com.rakuten.training.service.ProductService;
import com.rakuten.training.service.ProductServiceImpl;
@Component
public class ProductConsoleUI {
	@Autowired
	ProductService service;//=new ProductServiceImpl();
	public void createProductWithUI()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter name");
		String name =sc.nextLine();
		System.out.println("Enter price");
		float price=Float.parseFloat(sc.nextLine());
		System.out.println("Enter QOh");
		int qoh=Integer.parseInt(sc.nextLine());
		Product aProduct=new Product(name,price,qoh);
		int id=service.addnwewProduct(aProduct);
		System.out.println("Added Product With Id: "+id);
	}

}
