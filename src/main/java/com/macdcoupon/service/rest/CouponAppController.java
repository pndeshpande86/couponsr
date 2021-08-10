package com.macdcoupon.service.rest;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.macdcoupon.service.data.CouponDataRepository;
import com.macdcoupon.service.model.Coupon;

@RestController
@RequestMapping("/coupon")
public class CouponAppController {
	
	@Autowired
	CouponDataRepository couponDataRepository;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Coupon saveCoupon(@RequestBody Coupon coupon) {
		
		return couponDataRepository.save(coupon);
	}
	
	@RequestMapping(value = "/get/{code}", method = RequestMethod.GET)
	public Coupon getCoupon(@PathVariable("code") String code) {
		
		return couponDataRepository.findByCode(code);
	}

}
