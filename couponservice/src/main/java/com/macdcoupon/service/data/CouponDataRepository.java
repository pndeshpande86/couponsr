package com.macdcoupon.service.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.macdcoupon.service.model.Coupon;

public interface CouponDataRepository extends JpaRepository<Coupon, Long> {

	Coupon findByCode(String code);

}
