package com.rakuten.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakuten.training.dal.ProductDAO;
import com.rakuten.training.dal.ProductDAOInMemImpl;
import com.rakuten.training.domain.Product;
@Service
public class ProductServiceImpl implements ProductService {	@Autowired
	ProductDAO dao;//=new ProductDAOInMemImpl();//ask spring to inject it multiple classes implemenatation correct wiring

@Override
public int addnwewProduct(Product tobeAdded) {
	if(tobeAdded.getPrice()*tobeAdded.getQoh()>=10000) {
		Product saved=dao.save(tobeAdded);
		return saved.getId();
		}
	// TODO Auto-generated method stub
	else
	{
		throw new IllegalArgumentException("Monetoary value is less than 10k");
	}
		
}

@Override
public void removeExisting(int id) {
	
	Product existing=dao.findById(id);
	if(existing!=null)
	{
		if((existing.getPrice()*existing.getQoh())<=100000)
			dao.deleteById(id);
	}
	else
	{
		throw new IllegalArgumentException("Cant delete");
		
	}
}

@Override
public Product findById(int id) {
	// TODO Auto-generated method stub
	return dao.findById(id);
}

@Override
public List<Product> findAll() {
	return dao.findAll();
}
}
