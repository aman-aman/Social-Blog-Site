package com.javatpoint.controllers;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.javatpoint.beans.blog;
import com.javatpoint.beans.user;
import com.javatpoint.beans.validation;
import com.javatpoint.dao.blogdb;
import com.javatpoint.dao.userdb;

@Controller
public class usercontroller
{
	    @Autowired  
	    userdb dao;
	    
	    @Autowired
	    blogdb db; 
	    
	    @RequestMapping(value="/registration",method = RequestMethod.GET)  
	    public ModelAndView registration(@ModelAttribute("command")  user u)
	    {  
	    	String message="";
	        return new ModelAndView("registration","message",message);  
	    } 
	    
	    @RequestMapping(value="/")  
	    public ModelAndView index()
	    {  
	    	String message="";
	        return new ModelAndView("index","message",message);  
	    } 
	    
	    @RequestMapping(value="/retreivepassword")  
	    public ModelAndView retreivepassword()
	    {  
	    	String message="Retreive Password";
	        return new ModelAndView("retreivepassword","message",message);  
	    } 
	    
	    @RequestMapping(value="/logout",method = RequestMethod.POST)  
	    public RedirectView logout(HttpServletRequest req,HttpServletResponse res)
	    {  
	    	String message="Bye!!!";
			RedirectView view = new RedirectView("index.jsp");
			view.setExposeModelAttributes(false);
			return view;
	    } 
	    
	    @RequestMapping(value="/allblog")  
	    public String allblog(ModelMap map)
	    {  
	    	List<blog> list=db.getblog(); 
	    	String message="All Blogs";
	        map.addAttribute("message",message);
	        map.addAttribute("list", list);
	        return "allblog" ;
	    } 
	    
	    @RequestMapping("/myblogs/{username}")  
	    public String myblogs(@PathVariable("username") String username,ModelMap map)
	    {  
	    	List<blog> list=db.getblogbyusername(username);
	    	String message="My Blogs";
	        map.addAttribute("message",message);
	        map.addAttribute("list", list);
	        return "myblogs";
	    } 
	     
	    @RequestMapping(value="/saveblog" ,method=RequestMethod.POST)  
	    public String saveblog(HttpServletRequest req,HttpServletResponse res,ModelMap map)
	    {  
	    	blog p=new blog();
	    	DateFormat sdf = new SimpleDateFormat("yyyy/MM/ddHH:mm:ss");
	    	Date date = new Date();
	    	String d=sdf.format(date);
	    	String dt=d;
	    	d=d.replaceAll("/","");
	    	String blog_creation_date=d;
	    	p.setBlog_content(req.getParameter("blog_content"));
	    	p.setBlog_creation_date(blog_creation_date);
	    	p.setBlog_title(req.getParameter("blog_title"));
	    	p.setUsername(req.getParameter("username"));
	    	System.out.print(p.getBlog_content()+"  "+p.getBlog_creation_date()+"  "+p.getBlog_title());
	    	db.save(p);
	    	String message="Blog Saved!!!";
	    	List<blog> list=db.getblogbyusername(req.getParameter("username"));
	    	map.addAttribute("username",req.getParameter("username"));
	    	map.addAttribute("list", list);
	    	return "viewuser";
	    } 
	    
	     @RequestMapping(value="/errorpage/{message}")  
	    public String errorpage(@PathVariable("message") String message,ModelMap map)
	    {  
	    	 map.addAttribute("message", message);
	        return "errorpage";
	    } 
	    
	    @RequestMapping(value="/viewuser/{username}")  
	    public RedirectView viewuser(@PathVariable("username") String username,ModelMap map)
	    {  
	    	List<blog> list=db.getblogbyusername(username);
    		map.addAttribute("username", username);
    		map.addAttribute("list", list);
    		RedirectView view = new RedirectView("/temp/viewuser/"+username);
			view.setExposeModelAttributes(false);
			return view;
	    } 
	    
	    
	    
	    @RequestMapping(value="/validate",method = RequestMethod.POST)  
	    public String validate(HttpServletRequest req,HttpServletResponse res,ModelMap map)
	    {  
	    	String message="Hello";
	    	//System.out.println(message);
	    	String username=req.getParameter("username");
	    	String password=req.getParameter("password");
	    	
	    	if((dao.search(username,password)))
	    	{
	    		List<blog> list=db.getblogbyusername(username);
	    		map.addAttribute("username", username);
	    		map.addAttribute("list", list);
	    		return "viewuser" ;
	    	}
	    	else
	    	{
	    		message="Wrong Username or password !!! .";
	    		map.addAttribute("message", message);
	    		RedirectView view = new RedirectView();
				view.setExposeModelAttributes(false);
				return "errorpage";
	    	}
	    		
	    }  
	    
	    
	 
	    @SuppressWarnings("null")
		@RequestMapping(value="/save",method = RequestMethod.POST)  
	    public String save(HttpServletRequest request,HttpServletResponse response,ModelMap map)
	    {  
	    	DateFormat sdf = new SimpleDateFormat("yyyy/MM/ddHH:mm:ss");
	    	Date date = new Date();
	    	String d=sdf.format(date);
	    	String dt=d;
	    	d=d.replaceAll("/","");
	    	
			String firstname=request.getParameter("firstname");
			String lastname=request.getParameter("lastname");
			String address=request.getParameter("address");
			String phone=request.getParameter("phone");
			String password=request.getParameter("password");
			String message=null;
			validation obj=new validation();
			if(obj.validname(request.getParameter("firstname"))==false||obj.validname(request.getParameter("lastname"))==false||obj.validnumber(request.getParameter("phone"))==false)
			{
				message="Enter the data in proper format.";
				String s1="Phone number should only contain Letter";
				String s2="Firstname,lastname should consist only of lettes";
				String s3="Password should be alpha-numeric";
				map.addAttribute("message", message);
				map.addAttribute("s1", s1);
				map.addAttribute("s2", s2);
				map.addAttribute("s3", s3);
				
				return "temp/errorpage/"+message;
			}
			else
			{
				user u=new user();
				u.setFirstname(firstname);
				u.setLastname(lastname);
				String username=u.getFirstname()+u.getLastname()+d;
				u.setUsername(username);
				u.setPassword(password);
				u.setPhone(phone);
				u.setAddress(address);
				map.addAttribute("message", message);
				map.addAttribute("username", username);
		        if(dao.save(u)>0)  
		        	return "viewuser";
		        else
		        	return "index.jsp";
			}
			/*}*/
	    }  
	     
	    @RequestMapping(value="/getpassword")  
	    public String retreivepassword(HttpServletRequest req,HttpServletResponse res,ModelMap map)
	    {  
	    	String username=req.getParameter("username");
	    	List<user> list=dao.getPassword(username);
	    	String message="";
	    	if(list.size()==0)
	    	{
	    		message="Currently there is no user!!! or Such username does not exist.";
	    		map.addAttribute("message", message);
	    		//map.addAttribute("list", list);
	    	}
	    	else
	    	{
	    		message="Your current username and Password";
	    		map.addAttribute("message", message);
	    		map.addAttribute("list",list);
	    	}
	    	
	        return "showpassword";  
	    }
	    
	    @RequestMapping(value="/edituser/{username}")  
	    public String edituser(@PathVariable("username") String username,ModelMap map,@ModelAttribute("command")  user p)
	    {  
	    	/*dao.update(p);
			List<blog>list=db.getblogbyusername(username);
	    	map.addAttribute("username", username);
	    	map.addAttribute("list",list);*/
	    	map.addAttribute("username", username);
	    	return "edituser";
	    } 
	    
	    @RequestMapping(value="edituser/editsaveuser/{username}",method=RequestMethod.POST)  
	    public RedirectView editsaveuser(@PathVariable("username") String username,ModelMap map,@ModelAttribute("command")  user p,HttpServletRequest request,HttpServletResponse response) 
	    {  
				List<user> user_detail=dao.getuserdetail(username, request.getParameter("password"));
				validation obj=new validation();
				if(user_detail.size()==0)
				{
					String message="No such record found enter your own password to update the data";
					map.addAttribute("message", message);
					RedirectView view = new RedirectView("/temp/errorpage/"+message);
					view.setExposeModelAttributes(false);
					return view;
				}
				else if(obj.validname(request.getParameter("firstname"))==false||obj.validname(request.getParameter("lastname"))==false||obj.validnumber(request.getParameter("phone"))==false)
				{
					String message="Enter the data in correct format";
					map.addAttribute("message",message);
					String s="inside of edit save user";
					RedirectView view = new RedirectView("/temp/get_guidelines");
					view.setExposeModelAttributes(false);
					return view;
				}
				else
				{
					String message="Data updated Succefully!!!";
					System.out.print("inside of editsaveuser\n");
					p.setUsername(username);
					dao.update(p);
					List<blog>list=db.getblogbyusername(username);
					map.addAttribute("username",username);
					map.addAttribute("list",list);
					map.addAttribute("message", message);
					//return "editsuccesspage";
					RedirectView view = new RedirectView("/temp/editsuccesspage");
					view.setExposeModelAttributes(false);
					return view;
				}
	    } 
	    
	    @RequestMapping(value="/personaldetail/{username}")  
	    public String personaldetail(@PathVariable("username") String username,ModelMap map,@ModelAttribute("command")  user p)
	    {  
	    	
				List<blog>listofblog=db.getblogbyusername(username);
				List<user>listofpersonaldetail=dao.getuserbyusername(username);
				map.addAttribute("username",username);
				map.addAttribute("listofblog",listofblog);
				map.addAttribute("listofpersonaldetail",listofpersonaldetail);
				return "mydetail";
	    } 
	     
	    @RequestMapping(value="/editsuccesspage")  
	    public RedirectView editsuccesspage(ModelMap map,@ModelAttribute("command")  user p)
	    {  
	    	
	    	RedirectView view = new RedirectView("index.jsp");
			view.setExposeModelAttributes(false);
			return view;	
	    } 
	    
	    @RequestMapping(value="/goback/{username}")  
	    public RedirectView goback(@PathVariable("username") String username,ModelMap map,@ModelAttribute("command")  user p)
	    {  
	    	
	    	RedirectView view = new RedirectView("/temp/viewuser/"+username);
			view.setExposeModelAttributes(false);
			return view;	
	    } 
	    
	    @RequestMapping(value="/getblogdetail/{blog_title}/{blog_creation_date}")  
	    public String getblogdetail(@PathVariable("blog_title") String blog_title,@PathVariable("blog_creation_date") String blog_creation_date,ModelMap map,@ModelAttribute("command")  user p)
	    {  
	    	List<blog> list=db.getspecificblog(blog_title,blog_creation_date);
	    	map.addAttribute("list", list);
	    	map.addAttribute("blog_title", blog_title);
	    	/*RedirectView view = new RedirectView("/temp/blogdetailpage");
			view.setExposeModelAttributes(false);
			return view;*/
	    	return "blogdetailpage";
	    } 
	    
	    @RequestMapping(value="/get_guidelines")  
	    public String goback(ModelMap map)
	    {  
	    	
	    	String message="Enter the data in proper format as mention below to create an account";
			String s1="Phone number should only contain Letter";
			String s2="Firstname,lastname should consist only of lettes";
			String s3="Password Should be alpha-numeric";
			map.addAttribute("message", message);
			map.addAttribute("s1", s1);
			map.addAttribute("s2", s2);
			map.addAttribute("s3", s3);
			return "get_guidelines";
	    	
	    } 
}
