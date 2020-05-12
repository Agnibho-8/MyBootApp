package com.rakuten.training.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import com.rakuten.training.domain.Product;

@Repository
@Transactional  //tells spring to take care of transaction i.e begin and commit in save
public class ProductDAOjplimpl implements ProductDAO {
@Autowired
EntityManager em;

@Override
public Product save(Product toBeSaved) {
	em.persist(toBeSaved);
	
	return toBeSaved;
}

@Override
public Product findById(int id) {
	return em.find(Product.class,id);

}

@Override
public List<Product> findAll() {
	Query q=em.createQuery("select p from Product as p");
	List<Product>all=q.getResultList();
	return all;
}
public List<Product> findByPriceLessThan(float priceLimit)
{
	Query q=em.createQuery("select p from Product A p where p.price<:priceParam");
	q.setParameter("priceParam", priceLimit);
	return q.getResultList();
}
@Override
public void deleteById(int id) {
	Product p=em.find(Product.class,id);
	if(p!=null)
		em.remove(p);
	
	
	
}

}
