package com.javatpoint.beans;

public class validation 
{
	//firstname.matches("")==false||lastname.matches("^[a-zA-Z]+")==false||phone.matches("[0-9]{10}")==false||password.matches("^[a-zA-Z0-9_]+")==false
	public boolean validname(String name)
	{
		return name.matches("^[a-zA-Z]+");
	}
	public boolean validnumber(String number)
	{
		return number.matches("^[0-9]{10}");
	}
	
	
}
