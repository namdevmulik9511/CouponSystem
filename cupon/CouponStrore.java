package com.FlynautSaaS.cupon;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class CouponStrore 
{
	private final DelayQueue<Coupon> delayQueue=new DelayQueue<Coupon>();
	public void addCoupon(String unCode, long delay, TimeUnit unit)
	{
		Coupon coupon=new Coupon(unCode, delay, unit);
		delayQueue.put(coupon);
		 System.out.println("Added coupon: " + unCode + ", expiring in " + delay + " " + unit.toString().toLowerCase());
	}
	
	public void startThread()
	{
		Thread thread=new Thread(()->{
			while(true)
			{
				try
				{
					Coupon couponExp=delayQueue.take();
					processExpires(couponExp);	
				} 
				catch (Exception e)
				{
					Thread.currentThread().interrupt();
					break;
				}
			}
		});
		thread.start();
	}
	private void processExpires(Coupon couponExp) {
		System.out.println("Processing expired coupon: " + couponExp.getunCode());	
	}

}
