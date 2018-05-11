package shared;


public enum HogwartsTags 
{
	TEAMS_BUTTON("button"),
	SAVE_DEVELOPER_BUTTON("button"),
	GRYFFINDOR_TEAM("a"),
	HUFFLEPUF_TEAM("a"),
	RAVENCLAW_TEAM("a"),
	SLYTHERIN_TEAM("a");
	
	private String tagName;
	
	HogwartsTags(final String tagName)
	{
		this.tagName = tagName;
	}
	
	public String getTagName()
	{
		return tagName;
	}
}
