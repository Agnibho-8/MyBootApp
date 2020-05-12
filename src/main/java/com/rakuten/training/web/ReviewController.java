package com.rakuten.training.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rakuten.training.domain.Product;
import com.rakuten.training.domain.Review;
import com.rakuten.training.service.ProductService;
import com.rakuten.training.service.ReviewService;
@RestController
public class ReviewController {
	@Autowired
	ReviewService review;
	@Autowired
	ProductService service;
	//ProductS
	@GetMapping("/products/{id}/reviews")
	public ResponseEntity<List<Review>> getReviewById(@PathVariable("id")int id)
	{
		Product p=service.findById(id);
		//return p;
		if(p!=null)
			{
			List<Review> r=review.findByProductId(id);
			if(r.isEmpty())
			{
				return new ResponseEntity<List<Review>>(HttpStatus.NOT_FOUND);
				
			}
			else {
				return new ResponseEntity<List<Review>>(r,HttpStatus.OK);
			}
			}
		else
			return new ResponseEntity<List<Review>>(HttpStatus.NOT_FOUND);
		
	}
	@PostMapping("/products/{id}/reviews")
	public ResponseEntity<Review> addReviewById(@PathVariable("id")int id,@RequestBody Review  toBeAdded)
	{
		Product p=service.findById(id);
		if(p!=null)
		{
			Review r1=review.addReviewToProduct(id,toBeAdded);
			HttpHeaders headers=new HttpHeaders();
			headers.setLocation(URI.create("/products/id/reviews"));
			return new ResponseEntity<Review>(toBeAdded, headers, HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity<Review>(HttpStatus.NOT_FOUND);	
		}
	}
}
