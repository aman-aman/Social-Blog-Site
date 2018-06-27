package com.javatpoint.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.javatpoint.beans.blog;
//private String blog_content,blog_title,blog_creation_date;
public class blogdb 
{
	JdbcTemplate template;  
	  
	public void setTemplate(JdbcTemplate template)
	{  
	    this.template = template;  
	}
	
	public int save(blog p)
	{  
			String sql="insert into Table2 (blog_title,blog_creation_date,blog_content,username)  values('"+p.getBlog_title()+"','"+p.getBlog_creation_date()+"','"+p.getBlog_content()+"','"+p.getUsername()+"')";  
		    return template.update(sql); 
	}
	
	public int update(blog p)
	{  
	    String sql="update table Table2 set )";  
	    return template.update(sql);  
	}
	
	public int delete(int id)
	{  
	    String sql="delete from Table2 where uid="+Integer.toString(id);  
	    return template.update(sql);  
	} 
	
	public boolean search(String blog_title,String blog_creation_date)
	{
		 String check="select count(*) from Table2 where blog_title='"+blog_title+"'and blog_creation_date='"+blog_creation_date+"'";
		 if(template.queryForInt(check)>0)
			 return true;
		 return false;
	}
	public List<blog> getblog()
	{  
	    return template.query("select * from table2",new RowMapper<blog>()
	    {  
	        public blog mapRow(ResultSet rs, int row) throws SQLException
	        {  
	        	blog e=new blog();
	            e.setBlog_title(rs.getString(3));
	            e.setBlog_creation_date(rs.getString(1));
	            e.setBlog_content(rs.getString(2));
	            e.setUsername(rs.getString(4));
	            return e;  
	        }  
	    });  
	}
	public List<blog> getblogbyusername(String username)
	{  
	    return template.query("select * from table2 where username='"+username+"'",new RowMapper<blog>()
	    {  
	        public blog mapRow(ResultSet rs, int row) throws SQLException
	        {  
	        		
	        		//System.out.print("inside of getblogbyusername\n");
	        		blog e=new blog();
		            e.setBlog_title(rs.getString(3));
		            e.setBlog_creation_date(rs.getString(1));
		            e.setBlog_content(rs.getString(2));
		            e.setUsername(rs.getString(4));
		           //System.out.print(e.getBlog_title()+" "+e.getBlog_creation_date()+" "+e.getBlog_title()+" "+e.getUsername()+"\n" );
		            return e;  
	        }  
	    });  
	}
	public List<blog> getspecificblog(String blog_title,String blog_creation_date)
	{  
	    return template.query("select * from table2 where blog_title='"+blog_title+"' and blog_creation_date='"+blog_creation_date+"'",new RowMapper<blog>()
	    {  
	        public blog mapRow(ResultSet rs, int row) throws SQLException
	        {  
	        		
	        		//System.out.print("inside of getblogbyusername\n");
	        		blog e=new blog();
		            e.setBlog_title(rs.getString(3));
		            e.setBlog_creation_date(rs.getString(1));
		            e.setBlog_content(rs.getString(2));
		            e.setUsername(rs.getString(4));
		           //System.out.print(e.getBlog_title()+" "+e.getBlog_creation_date()+" "+e.getBlog_title()+" "+e.getUsername()+"\n" );
		            return e;  
	        }  
	    });  
	}
	
	
	
}
