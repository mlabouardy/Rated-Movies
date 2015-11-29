package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import bean.CategoryBean;
import bean.CategoryIt;
import entity.Category;

@Controller
public class HomeCtrl {
	
	@EJB(mappedName="java:app/jersey-jax-rs/CategoryBean!bean.CategoryIt")
	private CategoryIt categoryBean;

	@RequestMapping("/index")
	public String index(Model model){
		List<Category> categories=categoryBean.getCategories();
		model.addAttribute("categories", categories);
		return "index";
	}
	
	private CategoryBean lookupCategoryBean(){
		CategoryBean categoryBean=null;
		try {
			Context context=new InitialContext();
			categoryBean=(CategoryBean)context.lookup("");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return categoryBean;
	}
}
