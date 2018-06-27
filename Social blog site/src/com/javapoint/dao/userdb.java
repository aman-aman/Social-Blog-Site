package com.javatpoint.dao;

import java.sql.*;  
import java.util.ArrayList;  
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.javatpoint.beans.user;

public class userdb
{   
	JdbcTemplate template;  
	  
	public void setTemplate(JdbcTemplate template)
	{  
	    this.template = template;  
	}
	
	public int save(user p)
	{  
			String sql="insert into Table1 (firstname,lastname,username,address,password,phone)  values('"+p.getFirstname()+"','"+p.getLastname()+"','"+p.getUsername()+"','"+p.getAddress()+"','"+p.getPassword()+"','"+p.getPhone()+"')";  
		    return template.update(sql); 
	}
	
	public int update(user p)
	{  
		//String sql1="update Emp99 set name='"+p.getName()+"', salary="+p.getSalary()+",designation='"+p.getDesignation()+"' where id="+p.getId()+"";  
	    String sql="update Table1 set firstname='"+p.getFirstname()+"',lastname='"+p.getLastname()+"',address='"+p.getAddress()+"',phone='"+p.getPhone()+"',password='"+p.getPassword()+"' where username='"+p.getUsername()+"'";  
	    return template.update(sql);  
	}
	
	public int delete(int id)
	{  
	    String sql="delete from Table1 where uid="+Integer.toString(id);  
	    return template.update(sql);  
	} 
	
	public boolean search(String username,String password)
	{
		 String check="select count(*) from Table1 where username='"+username+"'and password='"+password+"'";
		 if(template.queryForInt(check)>0)
			 return true;
		 return false;
	}
	public List<user> getuser()
	{  
	    return template.query("select * from table1",new RowMapper<user>()
	    {  
	        public user mapRow(ResultSet rs, int row) throws SQLException
	        {  
	            user e=new user();
	            e.setFirstname(rs.getString(1));
	            e.setLastname(rs.getString(2));
	            e.setUsername(rs.getString(3));
	            e.setAddress(rs.getString(4));
	            e.setPassword(rs.getString(5));
	            e.setPhone(rs.getString(6));
	            return e;  
	        }  
	    });  
	}
	
	public List<user> getuserbyusername(String username)
	{  
	    return template.query("select * from table1 where username='"+username+"'",new RowMapper<user>()
	    {  
	        public user mapRow(ResultSet rs, int row) throws SQLException
	        {  
	            user e=new user();
	            e.setFirstname(rs.getString(2));
	            e.setLastname(rs.getString(4));
	            e.setUsername(rs.getString(3));
	            e.setAddress(rs.getString(1));
	            e.setPassword(rs.getString(5));
	            e.setPhone(rs.getString(6));
	            return e;  
	        }  
	    });  
	}
	
	public List<user> getPassword(String username)
	{  
		    return template.query("Select * from Table1 where username='"+username+"'",new RowMapper<user>()
		    {  
		        public user mapRow(ResultSet rs, int row) throws SQLException
		        {  
		            user e=new user();
		            e.setFirstname(rs.getString(2));
		            e.setLastname(rs.getString(1));
		            e.setUsername(rs.getString(3));
		            e.setAddress(rs.getString(4));
		            e.setPassword(rs.getString(5));
		            e.setPhone(rs.getString(6));
		            return e;  
		        }  
		    });  
	}
	
	public List<user> getuserdetail(String username,String password)
	{  
	    return template.query("select * from table1 where username='"+username+"' and password='"+password+"'",new RowMapper<user>()
	    {  
	        public user mapRow(ResultSet rs, int row) throws SQLException
	        {  
	            user e=new user();
	            e.setFirstname(rs.getString(2));
	            e.setLastname(rs.getString(4));
	            e.setUsername(rs.getString(3));
	            e.setAddress(rs.getString(1));
	            e.setPassword(rs.getString(5));
	            e.setPhone(rs.getString(6));
	            return e;  
	        }  
	    });  
	}
}  