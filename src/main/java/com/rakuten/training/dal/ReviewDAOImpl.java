package com.rakuten.training.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rakuten.training.domain.Product;
import com.rakuten.training.domain.Review;
@Repository
@Transactional
public class ReviewDAOImpl implements ReviewDAO {
	@Autowired
	EntityManager em;

	@Override
	public Review save(Review r) {
		em.persist(r);
		return r;
	}

	@Override
	public List<Review> findByProductId(int pid) {
		Query q = em.createQuery("select r from Review as r where r.product.id=:pidParam");
		q.setParameter("pidParam", pid);
		return q.getResultList();
	}

}