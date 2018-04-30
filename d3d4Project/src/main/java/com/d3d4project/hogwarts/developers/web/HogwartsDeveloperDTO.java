package com.d3d4project.hogwarts.developers.web;


import com.d3d4project.hogwarts.developers.model.HogwartsDeveloper;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(
		creatorVisibility = Visibility.NONE,
		fieldVisibility = Visibility.NONE,
		getterVisibility = Visibility.NONE,
		isGetterVisibility = Visibility.NONE,
		setterVisibility = Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HogwartsDeveloperDTO
{	
	@JsonProperty
	private String firstName;
	
	@JsonProperty
	private String lastName;
	
	@JsonProperty
	private String nickname;
	
	@JsonProperty
	private String primarySkill;
	
	public HogwartsDeveloperDTO()
	{
	}
	
	public HogwartsDeveloperDTO(final HogwartsDeveloper developer)
	{
		this.firstName = developer.getFirstName();
		this.lastName = developer.getLastName();
		this.nickname = developer.getNickname();
		this.primarySkill = developer.getPrimarySkill();
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
	
	@Override
	public boolean equals(final Object object)
	{
		if (object == this)
		{
			return true;
		}
		if (object == null || object.getClass() != this.getClass())
		{
			return false;
		}

		final HogwartsDeveloperDTO that = (HogwartsDeveloperDTO) object;

		return Objects.equal(firstName, that.getFirstName())
			&& Objects.equal(lastName, that.getLastName())
			&& Objects.equal(nickname, that.getNickname())
			&& Objects.equal(primarySkill, that.getPrimarySkill());
	}

	@Override
	public int hashCode()
	{
		return Objects.hashCode(
				firstName,
				lastName,
				nickname,
				primarySkill);
	}

	@Override
	public String toString()
	{
		return MoreObjects.toStringHelper(this).add("firstName", firstName) //$NON-NLS-1$
			.add("lastName", lastName)//$NON-NLS-1$
			.add("nickname", nickname)//$NON-NLS-1$
			.add("primarySkill", primarySkill)//$NON-NLS-1$
			.toString();
	}
	
	public void show()
	{
        System.out.println("Hello World!");
 }
}
