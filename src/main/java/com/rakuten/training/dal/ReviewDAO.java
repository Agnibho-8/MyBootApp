package com.rakuten.training.dal;

import java.util.List;

import com.rakuten.training.domain.Product;
import com.rakuten.training.domain.Review;

public interface ReviewDAO {
public Review save(Review r);
public List<Review> findByProductId(int pid);
}
