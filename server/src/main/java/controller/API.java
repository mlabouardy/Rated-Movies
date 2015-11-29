package controller;

import java.util.List;

import javax.ejb.EJB;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bean.CategoryIt;
import entity.Category;

@RestController
@RequestMapping("/api")
public class API {
	
	@EJB(mappedName="java:app/jersey-jax-rs/CategoryBean!bean.CategoryIt")
	private CategoryIt categoryBean;

	@CrossOrigin
	@RequestMapping(value="/categories", method=RequestMethod.GET, produces = "application/json")
	public List<Category> getCategories(){
		return categoryBean.getCategories();
	}
}
