package poly.controller;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import java.util.Date;
import java.util.List;

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

import ptithcm.entity.Record;
import ptithcm.entity.Staff;
import ptithcm.entity.User;

@Transactional
@Controller
@RequestMapping("/record/")
public class RecordController {
	@Autowired
	SessionFactory factory;
	
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insert(ModelMap model)
	{
		model.addAttribute("record", new Record());
		return "record/insert";
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(ModelMap model, @ModelAttribute("record") Record record)
	{
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try
		{
			record.setDate(new Date());
			session.save(record);
			t.commit();
			model.addAttribute("message", "Ghi nhận thành công");
		}catch (Exception ex)
		{
			t.rollback();
			model.addAttribute("message", "Ghi nhận thất bại");
		}
		finally
		{
			session.close();
		}
		return "record/insert";
	}
		
		@ModelAttribute("staffs")
		public List<Staff> getStaffs()
		{
			Session session = factory.getCurrentSession();
			String hql = "from Staff";
			Query query = session.createQuery(hql);
			List<Staff> list = query.list();
			return list;
		}
		
		@RequestMapping("index")
		public String index(ModelMap model)
		{
			Session session = factory.getCurrentSession();
			String hql = "from Record";
			Query query = session.createQuery(hql);
			List<User> list = query.list();
			model.addAttribute("records", list);
			return "record/index";
		}	
		
		public Integer deleteRecord(Record record) {
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try 
			{
				session.delete(record);
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
		
		public Record getRecord(int ID) {
			Session session = factory.getCurrentSession();
			String hql = "from Record where ID = :ID";
			Query query = session.createQuery(hql);
			query.setParameter("ID", ID);
			Record record = (Record) query.list().get(0);
			return record;
		}		
		
		@RequestMapping(value = "/delete/{ID}.htm", params = "linkDelete")
		public String deleteRecord(HttpServletRequest request, ModelMap model,
				@PathVariable("ID") int ID)
		{
			int result = this.deleteRecord(this.getRecord(ID));
			if (result != 0) 
			{
				model.addAttribute("message", "Delete thành công");
			} 
			else 
			{
				model.addAttribute("message", "Delete thất bại!");
			}		
			return "record/index";
		}	
}
