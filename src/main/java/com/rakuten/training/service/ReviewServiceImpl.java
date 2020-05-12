package com.rakuten.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rakuten.training.dal.ProductDAO;
import com.rakuten.training.dal.ReviewDAO;
import com.rakuten.training.domain.Product;
import com.rakuten.training.domain.Review;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	ReviewDAO reviewDAO;
	
	@Autowired
	ProductDAO productDAO;

	@Override
	public Review addReviewToProduct(int productId, Review toBeAdded) {
		Product aProduct = productDAO.findById(productId);
		if(aProduct == null) {
			throw new IllegalArgumentException("No such product : "+productId);
		}else {
			toBeAdded.setProduct(aProduct);
			reviewDAO.save(toBeAdded);
			return toBeAdded;
		}
		
	}

	@Override
	public List<Review> findByProductId(int pid) {
		return reviewDAO.findByProductId(pid);
	}
	
	

}