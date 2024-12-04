package de.thws.fiw.backendsystems.templates.graphql.models;

public class PersonInput
{
	private long id;

	private String firstName;

	private String lastName;

	public String getFirstName( )
	{
		return firstName;
	}

	public void setFirstName( final String firstName )
	{
		this.firstName = firstName;
	}

	public String getLastName( )
	{
		return lastName;
	}

	public void setLastName( final String lastName )
	{
		this.lastName = lastName;
	}

	public long getId( )
	{
		return id;
	}

	public void setId( final long id )
	{
		this.id = id;
	}
}
