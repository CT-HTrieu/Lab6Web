package poly.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import ptithcm.entity.Staff;

@Transactional
@Controller
@RequestMapping("/staff/")
public class StaffController {
	@Autowired
	SessionFactory factory;
	
	@RequestMapping("index")
	public String index(ModelMap model)
	{
		Session session = factory.getCurrentSession();
		String hql = "from Staff";
		Query query = session.createQuery(hql);
		List<Staff> list = query.list();
		model.addAttribute("staffs", list);
		return "staff/index";
	}	
	
	@RequestMapping("report")
	public String report(ModelMap model)
	{
		Session session = factory.getCurrentSession();
		String hql = "select r.staff.id, sum (case when r.type = 1 then 1 else 0 end), sum (case when r.type = 0 then 1 else 0 end) "
				+ "from Record as r "
				+ "group by r.staff.id";
		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();
		model.addAttribute("reports", list);
		return "staff/report";
	}
}
