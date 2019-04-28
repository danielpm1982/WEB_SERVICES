package com.danielpm1982.REST_WS2_Client.controller;
import java.util.List;
import javax.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.danielpm1982.REST_WS2_Client.helper.Helper;
import com.danielpm1982.REST_WS2_Client.helper.HelperImpl;
import com.danielpm1982.REST_WS2_Client.model.Person;

@Controller
public class WSController {
	@Autowired
	@Qualifier("helperImpl")
	Helper helper;
	@RequestMapping("/webServices")
	public String showWebServices(Model model) {
		model.addAttribute("personsURL", helper.getPersonsURL());
		return "webServices";
	}
	@RequestMapping("/getPersonAllResult")
	public String getPersonAllResult(Model model) {
		Helper helper = new HelperImpl("http://localhost:8080/REST_WS2/api/personManager/persons");
		try {
			List<Person> personList = helper.getPersonAll();
			if(personList!=null) {
				model.addAttribute("personList", personList);
			}	
		} catch(NotFoundException e) {
			model.addAttribute("personList", null);
		}
		model.addAttribute("personsURL", helper.getPersonsURL());
		return "getResult";
	}
	@RequestMapping("/getPersonUniqueResult")
	public String getPersonUniqueResult(@RequestParam("id") long id, Model model) {
		try {
			Person person = helper.getPersonUnique(id);
			if(person!=null) {
				model.addAttribute("person", person);
			}
		} catch (NotFoundException e) {
			model.addAttribute("person", null);
		}
		model.addAttribute("personsURL", helper.getPersonsURL());
		return "getResult";
	}
	@RequestMapping("/addPerson")
	public String addPerson(Model model) {
		model.addAttribute("add", true);
		model.addAttribute("personsURL", helper.getPersonsURL());
		model.addAttribute("personModelAttribute", new Person());
		return "personForm";
	}
	@RequestMapping("/addPersonResult")
	public String addPersonResult(@ModelAttribute("personModelAttribute") Person person, Model model) {
		Person addedPerson = helper.addPerson(person);
		model.addAttribute("person", addedPerson);
		model.addAttribute("personsURL", helper.getPersonsURL());
		return "addResult";
	}
	@RequestMapping("/updatePerson")
	public String updatePerson(Model model) {
		model.addAttribute("update", true);
		model.addAttribute("personsURL", helper.getPersonsURL());
		model.addAttribute("personModelAttribute", new Person());
		return "personForm";
	}
	@RequestMapping("/updatePersonResult")
	public String updatePersonResult(@ModelAttribute("personModelAttribute") Person person, Model model) {
		try {
			Person updatedPerson = helper.updatePerson(person);
			model.addAttribute("person", updatedPerson);
		} catch(NotFoundException e) {
			model.addAttribute("person", null);
		}
		model.addAttribute("personsURL", helper.getPersonsURL());
		return "updateResult";
	}
	@RequestMapping("/deletePersonResult")
	public String deletePersonResult(@RequestParam("id") long id, Model model) {
		try {
			Person deletingPerson = helper.getPersonUnique(id);
			boolean deleted = helper.deletePerson(id);
			model.addAttribute("deleted", deleted);
			model.addAttribute("person", deletingPerson);
		} catch(NotFoundException e) {
			model.addAttribute("person", null);
		}
		model.addAttribute("personsURL", helper.getPersonsURL());
		return "deleteResult";
	}
	@RequestMapping("/truncateAndClearDBResult")
	public String truncateAndClearDB(Model model) {
		boolean cleared = helper.truncateAndClearDB();
		model.addAttribute("cleared", cleared);
		return "truncateAndClearDBResult";
	}
}

/*
This is a Spring Controller for the mapping of browser requests that will trigger the execution of the Provider 
REST services through the Helper @Service interface towards the Provider Server REST services and 
will return the html response back to the browser that sent the initial call to this Consumer Client Server.

Instead of instantiating the @Service HelperImpl class here, and considering it is a Spring Enterprise Bean,
already instantiated, injected with its internal dependencies and added to the current context path of this
Consumer Client Server application, it only has to be injected with @Autowired Spring annotation.    

The same calls can be tested through the standalone main java class TestHelper.java, in a console level
(instead of web) perspective.
*/
