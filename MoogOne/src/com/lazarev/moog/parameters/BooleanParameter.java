package com.lazarev.moog.parameters;

import com.lazarev.moog.utils.RandomNumbers;

public class BooleanParameter extends Parameter
{

	private final boolean defaultValue;
	
	public BooleanParameter(String name, String suffix, boolean defaultValue)
	{
		super(name, suffix, Type.BOOLEAN);
		
		this.defaultValue = defaultValue;
	}
	
	@Override
	public String getRandomValue()
	{
		int randomInt = RandomNumbers.makeRandomInt(0, 1);
		return (randomInt == 0) ? "true" : "false";
	}

	
	@Override
	public String getMaxValue() { return "true"; }

	@Override
	public String getMinValue()	{ return "false"; }

	@Override
	public String getDefaultValue()	{ return (defaultValue) ? "true" : "false";	}

}
