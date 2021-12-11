package com.lazarev.moog.parameters;

import com.lazarev.moog.utils.RandomNumbers;

public class IntParameter extends Parameter
{

	private final int defaultValue;
	private final int minValue;
	private final int maxValue;
	
	public IntParameter(String name, String suffix, int minValue, int maxValue, int defaultValue)
	{
		super(name, suffix, Type.INTEGER);

		this.minValue = minValue;
		this.maxValue = maxValue;
		this.defaultValue = defaultValue;
	}
	
	
	@Override
	public String getRandomValue()
	{
		int randomInt = RandomNumbers.makeRandomInt(minValue, maxValue);
		return String.valueOf(randomInt);
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
