package com.lazarev.moog.parameters;

import com.lazarev.moog.utils.RandomNumbers;

public class StringParameter extends Parameter
{

	private final String possibleValues[];
	
	public StringParameter(String name, String suffix, String[] possibleValues )
	{
		super(name, suffix, Type.STRING);
		
		this.possibleValues = possibleValues;
		
		encloseInDoubleQuotes();
	}
	
	
	/* When we write out Strings they need to be inclosed in double quotes */
	private void encloseInDoubleQuotes() 
	{
		for (int i = 0; i < possibleValues.length; i++)
		{
			possibleValues[ i ] = "\"" + possibleValues [ i ] + "\"";
		}
		
	}
	
	
	@Override
	public String getRandomValue()
	{
		int randomInt = RandomNumbers.makeRandomInt(0, possibleValues.length - 1);
		return possibleValues[ randomInt ];
	}

}
