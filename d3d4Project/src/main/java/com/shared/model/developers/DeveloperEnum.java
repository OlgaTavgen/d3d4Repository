package com.shared.model.developers;

public enum DeveloperEnum {
	
	GRYFFINDOR_DEV1(
			"Harry",
			"Potter",
			"java",
			"Gryffindor",
			"1"),
	GRYFFINDOR_DEV2(
			"Ronald",
			"Weasley",
			"javascript",
			"Gryffindor",
			"2"),
	GRYFFINDOR_DEV3(
			"Hermione",
			"Granger",
			"automated testing",
			"Gryffindor",
			"3"),
	HUFFLEPUF_DEV1(
			"Cedric",
			"Diggory",
			"java",
			"Hufflepuf",
			"1"),
	HUFFLEPUF_DEV2(
			"Gregory",
			"Munslow",
			"javascript",
			"Hufflepuf",
			"2"),
	HUFFLEPUF_DEV3(
			"Nymphadora",
			"Tonks",
			"automated testing",
			"Hufflepuf",
			"3"),
	RAVENCLAW_DEV1(
			"Luna",
			"Lovegood",
			"java",
			"Ravenclaw",
			"1"),
	RAVENCLAW_DEV2(
			"Cho",
			"Chang",
			"javascript",
			"Ravenclaw",
			"2"),
	RAVENCLAW_DEV3(
			"Padma",
			"Patil",
			"automated testing",
			"Ravenclaw",
			"3"),
	SLYTHERIN_DEV1(
			"Draco",
			"Malfoy",
			"java",
			"Slytherin",
			"1"),
	SLYTHERIN_DEV2(
			"Severus",
			"Snape",
			"automated testing",
			"Slytherin",
			"2"),
	SLYTHERIN_DEV3(
			"Bellatrix",
			"Black",
			"javascript",
			"Slytherin",
			"3");
	
	private final String firstName;
	private final String lastName;
	private final String primarySkill;
	private final String team;
	private final String id;
	
	DeveloperEnum(final String firstName, final String lastName, final String primarySkill, final String team, final String id)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.primarySkill = primarySkill;
		this.team = team;
		this.id = id;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public String getPrimarySkill()
	{
		return primarySkill;
	}
	
	public String getTeam()
	{
		return team;
	}
	
	public String getId()
	{
		return id;
	}
}