package com.lazarev.moog.parameters;

public abstract class Parameter
{

	public static enum Type
	{
		STRING, DOUBLE, BOOLEAN, INTEGER
	}

	
	private final String name;
	private final String suffix;
	
	private String stringKey;
	private String stringValue;
	
	private final Type type;
	

	protected Parameter(String name, String suffix, Type type) 
	{
		this.name = name;
		this.suffix = suffix;
		this.type = type;
	}
	
	public abstract String getRandomValue();
	
	public abstract String getMaxValue();
	
	public abstract String getMinValue();
	
	public abstract String getDefaultValue();
	
	
	public String getName()
	{
		return name;
	}


	public void setKey(String key)
	{
		stringKey = key;
	}


	public String getKey()
	{
		return stringKey;
	}


	public String getSuffix()
	{
		return suffix;
	}


	public String getStringValue()
	{
		return stringValue;
	}


	public void setStringValue(String stringValue)
	{
		this.stringValue = stringValue;
	}


	public Type getType()
	{
		return type;
	}
	
}
