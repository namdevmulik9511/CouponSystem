package com.FlynautSaaS.cupon;

import java.util.concurrent.TimeUnit;

public class CouponCreate {

	public static void main(String[] args) 
	{
		CouponStrore couponStrore=new CouponStrore();
		couponStrore.addCoupon("SAVE01",5,TimeUnit.SECONDS);
		couponStrore.addCoupon("SAVE02",15,TimeUnit.SECONDS);
		couponStrore.addCoupon("SAVE03",2,TimeUnit.SECONDS);
		
		couponStrore.startThread();
	}

}
