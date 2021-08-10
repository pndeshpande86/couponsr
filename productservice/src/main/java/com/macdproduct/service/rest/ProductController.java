package com.macdproduct.service.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.macdproduct.service.model.Coupon;
import com.macdproduct.service.model.Product;
import com.macdproduct.service.repo.ProductRepo;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${couponservice.url}")
	String couponServiceUrl;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Product saveProduct(@RequestBody Product product) {
		
		Coupon coupon = restTemplate.getForObject(couponServiceUrl + product.getCouponCode(), Coupon.class);
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return productRepo.save(product);
	}
	
	@RequestMapping(value = "/get/{name}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable("name") String name) {
		
		return productRepo.findByName(name);
	}

}
