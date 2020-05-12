package com.rakuten.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.rakuten.training.dal.ReviewDAO;
import com.rakuten.training.domain.Review;
import com.rakuten.training.service.ReviewService;
import com.rakuten.training.ui.ProductConsoleUI;

@SpringBootApplication
public class MyBootAppApplication {

	public static void main(String[] args) {
		//ApplicationContext springContainer = SpringApplication.run(MyBootAppApplication.class, args);
		SpringApplication.run(MyBootAppApplication.class, args);
//		ProductConsoleUI  ui = springContainer.getBean(ProductConsoleUI.class);
//		ui.createProductWithUI();
		
		/*Review aReview = new Review("self", "this is super stuff", 5);
		ReviewService service = springContainer.getBean(ReviewService.class);
		service.addReviewToProduct(1, aReview);*/
	}

}
