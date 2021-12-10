package com.lazarev.moog;

public class Parameter
{

	public enum Type
	{
		STRING, DOUBLE, BOOLEAN, INTEGER
	}

	private final String name;
	private final Parameter.Type type;

	private String stringKey;
	private String stringValue;

	/** When randomizing numeric values, we want to have limits **/
	private final double minDoubleValue;
	private final double maxDoubleValue;
	
	private final int minIntValue;
	private final int maxIntValue;
	
	
	public Parameter(String name, Parameter.Type type, double minValue, double maxValue)
	{
		this.name = name;
		this.type = type;
		
		this.minDoubleValue = minValue;
		this.maxDoubleValue = maxValue;
		
		this.minIntValue = 0;
		this.maxIntValue = 0;
	}

	public Parameter(String name, Parameter.Type type, int minValue, int maxValue)
	{
		this.name = name;
		this.type = type;

		this.minIntValue = minValue;
		this.maxIntValue = maxValue;
		
		this.minDoubleValue = 0;
		this.maxDoubleValue = 0;
	}
	
	
	public void setStringKey(String key)
	{
		stringKey = key;
	}

	public String getKey()
	{
		return stringKey;
	}

	public String getName()
	{
		return name;
	}

	public String getStringValue()
	{
		return stringValue;
	}

	public void setStringValue(String stringValue)
	{
		this.stringValue = stringValue;
	}

	public double getMinDoubleValue()
	{
		return minDoubleValue;
	}

	public double getMaxDoubleValue()
	{
		return maxDoubleValue;
	}

	public int getMinIntValue()
	{
		return minIntValue;
	}

	public int getMaxIntValue()
	{
		return maxIntValue;
	}

	public Type getType() {
		return type;
	}
	
}
