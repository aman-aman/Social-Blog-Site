package com.javatpoint.beans;

public class blog
{
	private String blog_content,blog_title,blog_creation_date,username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBlog_content()
	{
		return blog_content;
	}

	public void setBlog_content(String blog_content) 
	{
		this.blog_content = blog_content;
	}

	public String getBlog_title() 
	{
		return blog_title;
	}

	public void setBlog_title(String blog_title) 
	{
		this.blog_title = blog_title;
	}

	public String getBlog_creation_date() 
	{
		return blog_creation_date;
	}

	public void setBlog_creation_date(String blog_creation_date)
	{
		this.blog_creation_date = blog_creation_date;
	}

}
