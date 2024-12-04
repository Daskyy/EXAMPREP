package de.thws.fiw.backendsystems.templates.graphql.models;

public class Person extends AbstractModel
{
	private String firstName;

	private String lastName;

	private Address address;

	public Person( )
	{
	}

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

	public Address getAddress( )
	{
		return address;
	}

	public void setAddress( final Address address )
	{
		this.address = address;
	}
}
