package poly.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ptithcm.entity.User;

@Transactional
@Controller
@RequestMapping("/user/")
public class UserController {
	@Autowired
	SessionFactory factory;
	
	@RequestMapping("index")
	public String index(ModelMap model)
	{
		Session session = factory.getCurrentSession();
		String hql = "from User";
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		model.addAttribute("users", list);
		return "user/index";
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insert(ModelMap model)
	{
		model.addAttribute("user", new User());
		return "user/insert";
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(ModelMap model, @ModelAttribute("user") User user)
	{
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try
		{
			session.save(user);
			t.commit();
			model.addAttribute("message", "Thêm thành công");
		}catch (Exception ex)
		{
			t.rollback();
			model.addAttribute("message", "Thêm thất bại");
		}
		finally
		{
			session.close();
		}
		return "user/index";
	}
	
	public Integer deleteUser(User user) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try 
		{
			session.delete(user);
			t.commit();
		}catch (Exception ex) 
		{
			t.rollback();
			return 0;
		} 
		finally 
		{
			session.close();
		}
		return 1;
	}	
	
	public User getUser(String username) {
		Session session = factory.getCurrentSession();
		String hql = "from User where username = :username";
		Query query = session.createQuery(hql);
		query.setParameter("username", username);
		User user = (User) query.list().get(0);
		return user;
	}	
	
	@RequestMapping(value = "/delete/{username}.htm", params = "linkDelete")
	public String deleteUser(HttpServletRequest request, ModelMap model,
			@PathVariable("username") String username)
	{
		int result = this.deleteUser(this.getUser(username));
		if (result != 0) 
		{
			model.addAttribute("message", "xóa thành công");
		} 
		else 
		{
			model.addAttribute("message", "Xóa thất bại");
		}		
		return "user/index";
	}
	
	public Integer updateUser(User user) 
	{
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try 
		{
			session.update(user);
			t.commit();
		}catch (Exception ex) 
		{
			t.rollback();
			return 0;
		} 
		finally 
		{
			session.close();
		}
		return 1;
	}	
	
	@RequestMapping(value = "/update/{username}.htm", params = "linkEdit")
	public String updateUser(HttpServletRequest request, ModelMap model,
			@PathVariable("username") String username) 
	{
		model.addAttribute("user", this.getUser(username));
		return "user/update";
	}	
	
	@RequestMapping(value = "update")
	public String updateUser(HttpServletRequest request, ModelMap model,
			@ModelAttribute("user") User user) 
	{
		int result = this.updateUser(user);
		if (result != 0) 
		{
			model.addAttribute("message", "Update thành công");
		}
		else
		{
			model.addAttribute("message", "Update thất bại");
		}
		return "user/index";
	}
}


