package com.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.entities.Person;
import com.services.PersonDaoService;

@Controller
public class PersonController {
	private Logger log = Logger.getLogger(PersonController.class);
	@Autowired
	private PersonDaoService personService;

	@RequestMapping(value = "/")
	public ModelAndView index() {
		log.debug("Enter into Index Controller...!");
		return new ModelAndView("index", "message", "Welcome To Spring ORM Web Application");
	}

	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public ModelAndView getPersonList() {
		log.debug("Enter into Get Person List Controller Action...!");
		return new ModelAndView("person", "listPerson", this.personService.listPersons());
	}

	@RequestMapping(value = "/addPerson", method = RequestMethod.POST)
	public ModelAndView addPerson(@ModelAttribute("person") Person p) {
		log.debug("Enter into Add Person Controller Action...!");
		this.personService.addPerson(p);
		return new ModelAndView("person", "listPerson", this.personService.listPersons());
	}
	
	@RequestMapping(value = "/editPerson/{personId}")
	public String editPerson(@PathVariable("personId") int id, Model model){
		model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("listPersons", this.personService.listPersons());
		return "person";
	}
}