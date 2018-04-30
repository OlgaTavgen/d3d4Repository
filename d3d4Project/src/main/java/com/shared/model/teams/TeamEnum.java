package com.shared.model.teams;

public enum TeamEnum {
	
	GRYFFINDOR("Gryffindor"),
	HUFFLEPUF("Hufflepuf"),
	RAVENCLAW("Ravenclaw"),
	SLYTHERIN("Slytherin");
	
	private final String name;
	
	TeamEnum(final String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}	
}
