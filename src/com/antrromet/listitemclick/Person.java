package com.antrromet.listitemclick;

/*
 * Model class to save the info for a person
 */
public class Person
{

	String	name;
	String	number;

	public Person(String name, String number)
	{
		this.name = name;
		this.number = number;
	}

	/*
	 * Returns the name of the person
	 */
	public String getName()
	{
		return name;
	}

	/*
	 * Returns the number of the person
	 */
	public String getNumber()
	{
		return number;
	}

}
