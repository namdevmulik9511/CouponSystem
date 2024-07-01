package com.FlynautSaaS.cupon;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
public class Coupon implements Delayed 
{
	private String unCode;
	private long expirTime;

	public Coupon(String unCode, long dealy, TimeUnit unit) 
	{
		super();
		this.unCode = unCode;
		this.expirTime = System.currentTimeMillis()+unit.toMillis(dealy);
	}

	@Override
	public int compareTo(Delayed o)
	{
		if(this.expirTime<((Coupon)o).expirTime)
		{
			return -1;
		}
		if(this.expirTime>((Coupon)o).expirTime)
		{
			return 1;
		}
		else
			return 0;
	}
	@Override
	public long getDelay(TimeUnit unit) {
		long delay = expirTime - System.currentTimeMillis();
        return unit.convert(delay, TimeUnit.MILLISECONDS);
	}
	public String getunCode()
	{
		return unCode;
	}
}
