package com.shared.model.developers;

public class Developer {
	
	private String firstName;
	private String lastName;
	private String nickname;
	private String primarySkill;
	private String level;
	
	private Developer(final Developer prototype)
	{
		if (prototype != null)
		{
			//@formatter:off
			firstName = prototype.firstName;
			lastName = prototype.lastName;
			nickname = prototype.nickname;
			primarySkill = prototype.primarySkill;
			level = prototype.level;
			//@formatter:on
		}		
	}
	
	public static Builder builder()
	{
		return builder(null);
	}
	
	public static Builder builder(final Developer prototype)
	{
		return new Builder(prototype);
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public String getNickname()
	{
		return nickname;
	}
	
	public String getPrimarySkill()
	{
		return primarySkill;
	}	
	
	public String getLevel()
	{
		return level;
	}	

	public static final class Builder
	{
		private final Developer prototype;
		
		private Builder(final Developer prototype)
		{
			this.prototype = new Developer(prototype);
		}
		
		public Builder firstName(String firstName)
		{
			prototype.firstName = firstName;
			
			return this;
		}
		
		public Builder lastName(String lastName)
		{
			prototype.lastName = lastName;
			
			return this;
		}
		
		public Builder nickname(String firstName, String lastName)
		{
			prototype.nickname = String.valueOf(prototype.firstName.charAt(0)).concat(prototype.lastName);
			
			return this;
		}
		
		public Builder primarySkill(String primarySkill)
		{
			prototype.primarySkill = primarySkill;
			
			return this;
		}
		
		public Builder level(String level)
		{
			prototype.level = level;
			
			return this;
		}
		
		public Developer build()
		{
			return new Developer(prototype);
		}
	}
}