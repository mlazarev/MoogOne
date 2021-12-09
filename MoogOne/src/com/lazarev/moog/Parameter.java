package com.lazarev.moog;

public class Parameter {

	public enum Type {
		STRING, FLOAT, BOOLEAN, INTEGER
	}
	
	private final String name;
	private final Parameter.Type type;
	
	private String stringKey;
	private String stringValue;
	
	/** When randomizing numeric values, we to have specified limits **/
	private float minValue;
	private float maxValue;
	
	
	public Parameter(String name, Parameter.Type type ) {
		this.name = name;
		this.type = type;
	}

	
	public Parameter(String name, Parameter.Type type, float minValue, float maxValue ) {
		this(name, type);
		setMinValue(minValue);
		setMaxValue(maxValue);
	}


	public void setStringKey(String key) {
		stringKey = key;
	}
	
	public String getKey() {
		return stringKey;
	}
	
	public String getName() {
		return name;
	}
	
	
	public Parameter.Type getType() {
		return type;
	}
	
	
	public String getStringValue() {
		return stringValue;
	}


	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}


	public float getMinValue() {
		return minValue;
	}


	public void setMinValue(float minValue) {
		this.minValue = minValue;
	}


	public float getMaxValue() {
		return maxValue;
	}


	public void setMaxValue(float maxValue) {
		this.maxValue = maxValue;
	}


	

}
