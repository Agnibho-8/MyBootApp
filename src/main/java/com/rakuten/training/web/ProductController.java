package com.rakuten.training.web;

import java.net.URI;
import java.util.List;

import javax.xml.ws.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rakuten.training.domain.Product;
import com.rakuten.training.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService service;
	//@RequestMapping(method = RequestMethod.GET,value="/products")
	@GetMapping("/products")
	public List<Product> getALlProducts(){//jackson connverts arra java to array json
		return service.findAll();
		
	}
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getById(@PathVariable("id")int id)
	{
		Product p=service.findById(id);
		//return p;
		if(p!=null)
			return new ResponseEntity<Product>(p,HttpStatus.OK);
		else
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	}
	@PostMapping("/products")
	public ResponseEntity<Product> addProduct(@RequestBody Product  toBeAdded)
	{
		try {
			int id=service.addnwewProduct(toBeAdded);
			HttpHeaders headers=new HttpHeaders();
			headers.setLocation(URI.create("/products/id"));
			return new ResponseEntity<Product>(toBeAdded, headers, HttpStatus.CREATED);
		}
		catch(IllegalArgumentException e)
		{
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
