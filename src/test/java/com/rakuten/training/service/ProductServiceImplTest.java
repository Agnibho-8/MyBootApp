package com.rakuten.training.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import com.rakuten.training.dal.ProductDAO;
import com.rakuten.training.dal.ProductDAOInMemImpl;
import com.rakuten.training.domain.Product;

public class ProductServiceImplTest {

	@Test
	public void addNewProduct_Must_Return_Valid_Id_When_Value_GT_Min_Value() {
		//Arrange
		//ProductDAOInMemImpl doubleOfDAO=new ProductDAOInMemImpl();
		ProductServiceImpl obUndertest= new ProductServiceImpl();
		ProductDAO mockDAO=Mockito.mock(ProductDAO.class);
		obUndertest.dao=mockDAO;//Thisis DI
		Product argumentToBePassed=new Product("test",10001,1);
		Product toBeReturnedByMock=new Product("test",10001,1);
		toBeReturnedByMock.setId(1);
		Mockito.when(mockDAO.save(argumentToBePassed)).thenReturn(toBeReturnedByMock);
		//Act
		int id=obUndertest.addnwewProduct(argumentToBePassed);
		//Assert
		assertTrue(id>0);
		}
	@Test
	public void addNewProduct_Must_Return_Valid_Id_When_Value_GT_Min_Value2()
	{
		try {
			ProductDAO mockDAO=Mockito.mock(ProductDAO.class);
			ProductServiceImpl obUndertest= new ProductServiceImpl();
			obUndertest.dao=mockDAO;//Thisis DI
			Product argumentToBePassed=new Product("test",10000,0);
			Product toBeReturnedByMock=new Product("test",10000,0);
			//Act
			int id=obUndertest.addnwewProduct(argumentToBePassed);
			fail("failed");
		}
		catch(IllegalArgumentException e) {
			
		}
	}
}
