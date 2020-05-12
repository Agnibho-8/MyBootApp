package com.rakuten.training.service;

import java.util.List;

import com.rakuten.training.domain.Product;

public interface ProductService {
public int addnwewProduct(Product tobeAdded);
public void removeExisting(int id);
public Product findById(int id);
public List<Product>findAll();
}
