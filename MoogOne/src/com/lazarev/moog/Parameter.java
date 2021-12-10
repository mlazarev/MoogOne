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
	private double minDoubleValue;
	private double maxDoubleValue;
	
	private int minIntValue;
	private int maxIntValue;
	
	
	public Parameter(String name, Parameter.Type type)
	{
		this.name = name;
		this.type = type;
	}

	public Parameter(String name, Parameter.Type type, double minValue, double maxValue)
	{
		this(name, type);
		setMinDoubleValue(minValue);
		setMaxDoubleValue(maxValue);
	}

	public Parameter(String name, Parameter.Type type, int minValue, int maxValue)
	{
		this(name, type);
		setMinIntValue(minValue);
		setMaxIntValue(maxValue);
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

	public Parameter.Type getType()
	{
		return type;
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

	public void setMinDoubleValue(double minValue)
	{
		this.minDoubleValue = minValue;
	}

	public double getMaxDoubleValue()
	{
		return maxDoubleValue;
	}

	public void setMaxDoubleValue(double maxValue)
	{
		this.maxDoubleValue = maxValue;
	}

	public int getMinIntValue()
	{
		return minIntValue;
	}

	public void setMinIntValue(int minIntValue)
	{
		this.minIntValue = minIntValue;
	}

	public int getMaxIntValue()
	{
		return maxIntValue;
	}

	public void setMaxIntValue(int maxIntValue)
	{
		this.maxIntValue = maxIntValue;
	}

	
	
}
