package com.lazarev.moog.parameters;

import com.lazarev.moog.utils.RandomNumbers;

public class IntParameter extends Parameter
{

	private final int minValue;
	private final int maxValue;
	
	public IntParameter(String name, String suffix, int minValue, int maxValue)
	{
		super(name, suffix, Type.INTEGER);

		this.minValue = minValue;
		this.maxValue = maxValue;		
	}
	
	
	@Override
	public String getRandomValue()
	{
		int randomInt = RandomNumbers.makeRandomInt(minValue, maxValue);
		return String.valueOf(randomInt);
	}
	
}
