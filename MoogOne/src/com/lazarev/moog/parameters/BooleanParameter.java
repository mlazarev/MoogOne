package com.lazarev.moog.parameters;

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
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public String getMaxValue()
	{
		return "true";
	}

	@Override
	public String getMinValue()
	{
		return "false";
	}

	@Override
	public String getDefaultValue()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
