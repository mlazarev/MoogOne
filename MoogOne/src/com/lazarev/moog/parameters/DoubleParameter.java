package com.lazarev.moog.parameters;

import com.lazarev.moog.utils.RandomNumbers;

public class DoubleParameter extends Parameter
{
	
	private final double minValue;
	private final double maxValue;
	private final double defaultValue;
	
	public DoubleParameter(String name, String suffix, double minValue, double maxValue, double defaultValue)
	{
		super(name, suffix, Type.DOUBLE);
		 
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.defaultValue = defaultValue;
	}
	
	@Override
	public String getRandomValue()
	{
		double randomDouble = RandomNumbers.makeRandomDouble(minValue, maxValue);
		return String.valueOf(randomDouble);
	}
	
	@Override
	public String getMinValue() 
	{
		return String.valueOf(minValue);
	}
	
	@Override
	public String getMaxValue() 
	{
		return String.valueOf(maxValue);
	}
	
	@Override
	public String getDefaultValue() 
	{
		return String.valueOf(defaultValue);
	}

}
