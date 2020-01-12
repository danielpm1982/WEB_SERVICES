package com.danielpm1982.REST_WS6.controller;
import java.util.Arrays;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.danielpm1982.REST_WS6.entity.User;
import com.danielpm1982.REST_WS6.entity.UserModelAttribute;
import com.danielpm1982.REST_WS6.service.UserServiceInterface;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	@Autowired
    @Qualifier("userService")
    private UserServiceInterface userService;
	private final List<String> ROLE_OPTIONS = Arrays.asList("ROLE_USER","ROLE_ADMIN"); //ROLE_USER is default for all. ROLE_ADMIN is set based on user selection... in a real system this selection should be restricted to high-level credentials only, not to everyone, of course. This restriction has not been implemented here, though. 
	@GetMapping("/registrationForm")
	public String showRegistrationForm(Model model) {
		model.addAttribute("userModelAttribute", new UserModelAttribute());
		model.addAttribute("roleOptions", ROLE_OPTIONS);
		return "registrationForm";
	}
	@PostMapping("/registrationFormResult")
	public String showRegistrationFormResult(@Valid @ModelAttribute("userModelAttribute") UserModelAttribute userModelAttribute, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()){
			model.addAttribute("roleOptions", ROLE_OPTIONS);
			return "registrationForm";
        }
		String userName = userModelAttribute.getUserName();
		User user = userService.findByUserName(userName);
		if (user != null){
        	model.addAttribute("roleOptions", ROLE_OPTIONS);
        	model.addAttribute("registrationError", "Username already exists.");
        	return "registrationForm";
        } else {
        	userService.save(userModelAttribute);
        	User userSaveCheck = userService.findByUserName(userName); //finding again, from what has just been saved, for checking if saving really occurred.
        	if(userSaveCheck!=null) {
        		model.addAttribute("user", userSaveCheck);
            	return "registrationFormResult";
        	} else {
        		model.addAttribute("roleOptions", ROLE_OPTIONS);
    			model.addAttribute("registrationError", "Registration failed. Try again or call support.");
            	return "registrationForm";
        	}
        }
	}
	@GetMapping("/registrationFormUpdate")
	public String showRegistrationFormUpdate(Model model) {
		model.addAttribute("userModelAttribute", new UserModelAttribute());
		return "registrationFormUpdate";
	}
	@PostMapping("/registrationFormUpdateResult")
	public String showRegistrationFormUpdateResult(@Valid @ModelAttribute("userModelAttribute") UserModelAttribute userModelAttribute, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()){
			System.out.println(bindingResult);
			return "registrationFormUpdate";
        }
		String userName = userModelAttribute.getUserName();
		User oldUser = userService.findByUserName(userName); //finding existing user
        if (oldUser == null){
        	model.addAttribute("userModelAttribute", new UserModelAttribute());
			model.addAttribute("registrationUpdateError", "Username does not exist, and cannot be updated.");
        	return "registrationFormUpdate";
        } else {
        	if (!BCrypt.checkpw(userModelAttribute.getPassword(), oldUser.getPassword())){
            	model.addAttribute("userModelAttribute", new UserModelAttribute());
    			model.addAttribute("registrationUpdateError", "User password is wrong, and User cannot be updated.");
            	return "registrationFormUpdate";
            } else {
            	userService.save(userModelAttribute);
            	User newUser = userService.findByUserName(userName); //finding again the User with the updated data
            	model.addAttribute("oldUser", oldUser);
            	model.addAttribute("newUser", newUser);
            	return "registrationFormUpdateResult";
            }
        }
	}
	@PostMapping("/registrationFormQueryResult") //the view field that uses this query mapping is at the User update jsp page. It searches from a username and returns to the same page the modelAttribute already filled up (except passwords) with the respective data of the User that will be updated after user confirmation. 
	public String showRegistrationFormQueryResult(UserModelAttribute userModelAttribute, BindingResult bindingResult, Model model) {
		String userName = userModelAttribute.getUserName();
		User user = userService.findByUserName(userName); //finding existing user
        if (user == null){
        	model.addAttribute("userModelAttribute", new UserModelAttribute());
			model.addAttribute("registrationQueryError", "Username does not exist.");
        } else {
        	userModelAttribute.setPassword("");
        	userModelAttribute.setMatchingPassword("");
        	userModelAttribute.setFirstName(user.getFirstName());
        	userModelAttribute.setLastName(user.getLastName());
        	userModelAttribute.setEmail(user.getEmail());
        	model.addAttribute("userModelAttribute", userModelAttribute);
        }
        return "registrationFormUpdate";
	}
	@PostMapping("/registrationFormQueryResult2") //the view field that uses this query mapping is at the User delete jsp page. It searches from a username and returns to the same page the modelAttribute already filled up (except passwords) with the respective data of the User that will be deleted after user confirmation.
	public String showRegistrationFormQueryResult2(UserModelAttribute userModelAttribute, BindingResult bindingResult, Model model) {
		String userName = userModelAttribute.getUserName();
		User user = userService.findByUserName(userName); //finding existing user
        if (user == null){
        	model.addAttribute("userModelAttribute", new UserModelAttribute());
			model.addAttribute("registrationQueryError", "Username does not exist.");
        } else {
        	userModelAttribute.setPassword("");
        	userModelAttribute.setMatchingPassword("");
        	userModelAttribute.setFirstName(user.getFirstName());
        	userModelAttribute.setLastName(user.getLastName());
        	userModelAttribute.setEmail(user.getEmail());
        	model.addAttribute("userModelAttribute", userModelAttribute);
        }
        return "registrationFormDelete";
	}
	@GetMapping("/registrationFormDelete")
	public String showRegistrationFormDelete(Model model) {
		model.addAttribute("userModelAttribute", new UserModelAttribute());
		return "registrationFormDelete";
	}
	@PostMapping("/registrationFormDeleteResult")
	public String showRegistrationFormDeleteResult(@Valid @ModelAttribute("userModelAttribute") UserModelAttribute userModelAttribute, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()){
			System.out.println(bindingResult);
			return "registrationFormDelete";
        }
		User user = userService.findByUserName(userModelAttribute.getUserName()); //finding existing user to delete
        if (user == null){
			model.addAttribute("registrationDeleteError", "Username does not exist and User cannot be deleted.");
        	return "registrationFormDelete";
        } else {
        	if (!BCrypt.checkpw(userModelAttribute.getPassword(), user.getPassword())){
            	model.addAttribute("userModelAttribute", new UserModelAttribute());
    			model.addAttribute("registrationDeleteError", "User password is wrong, and User cannot be deleted.");
            	return "registrationFormDelete";
            } else {
	        	model.addAttribute("deletingUser", user); //the user that is supposed to be deleted, and will be shown at the view after deletion.
	        	userService.deleteUserById(user.getId()); //delete through the userId (PK)
	        	User deletedUser = userService.findByUserName(userModelAttribute.getUserName()); //finding again the deleted User only for confirming it is null (not for showing at the view)
	        	if(deletedUser==null) {
	        		return "registrationFormDeleteResult";
	        	} else {
	        		model.addAttribute("registrationDeleteError", "Deletion failed.");
	        		return "registrationFormDelete";
	        	}
            }
        }
	}
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) { //for eliminating left and right empty spaces at the request values from the html fields above. For ex.: a request value of "       abc   " is trimmed to "abc";
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
}

/*
This Controller uses the injected custom UserService enterprise bean to CRUD-manage the User registers
and associate the related mapping paths to each web page, along with the responses and some high-level 
error treatment (specially related to business logics). It's basically related to User Registration (Sign up).
*/
