package com.lazarev.moog;

public class Parameter
{
	private final String name;
	
	public enum Type
	{
		STRING, DOUBLE, BOOLEAN, INTEGER
	}
	
	private final Parameter.Type type;

	private final String keySuffix;
	
	private String stringKey;
	private String stringValue;

	/** When randomizing numeric values, we want to have limits **/
	private final double minDoubleValue;
	private final double maxDoubleValue;
	
	private final int minIntValue;
	private final int maxIntValue;
	
	private final String[] possibleValues;
	
	public Parameter(String name, String keySuffix, Parameter.Type type, double minValue, double maxValue)
	{
		this.name = name;
		this.keySuffix = keySuffix;
		this.type = type;
		
		this.minDoubleValue = minValue;
		this.maxDoubleValue = maxValue;
		
		this.minIntValue = 0;
		this.maxIntValue = 0;
		
		this.possibleValues = null;
	}

	public Parameter(String name, String keySuffix, Parameter.Type type, int minValue, int maxValue)
	{
		this.name = name;
		this.keySuffix = keySuffix;
		this.type = type;

		this.minIntValue = minValue;
		this.maxIntValue = maxValue;
		
		this.minDoubleValue = 0;
		this.maxDoubleValue = 0;
		
		this.possibleValues = null;
	}
	
	public Parameter(String name, String keySuffix, Parameter.Type type, String[] possibleValues)
	{
		this.name = name;
		this.keySuffix = keySuffix;
		this.type = type;

		this.possibleValues = possibleValues;
		
		this.minIntValue = 0;
		this.maxIntValue = 0;
		this.minDoubleValue = 0;
		this.maxDoubleValue = 0;
	}
	
	
	public String getName()
	{
		return name;
	}
	
	public void setStringKey(String key)
	{
		stringKey = key;
	}

	public String getStringKey()
	{
		return stringKey;
	}

	public String getSuffixKey()
	{
		return keySuffix;
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
	
	public String[] getPossibleStringValues() {
		return possibleValues;
	}
	
}
