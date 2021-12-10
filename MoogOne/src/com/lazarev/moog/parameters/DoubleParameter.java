package com.lazarev.moog.parameters;

import com.lazarev.moog.utils.RandomNumbers;

public class DoubleParameter extends Parameter
{
	
	private final double minValue;
	private final double maxValue;
	
	public DoubleParameter(String name, String suffix, double minValue, double maxValue)
	{
		super(name, suffix, Type.DOUBLE);
		
		this.minValue = minValue;
		this.maxValue = maxValue;
	}
	
	@Override
	public String getRandomValue()
	{
		double randomDouble = RandomNumbers.makeRandomDouble(minValue, maxValue);
		return String.valueOf(randomDouble);
	}

}
