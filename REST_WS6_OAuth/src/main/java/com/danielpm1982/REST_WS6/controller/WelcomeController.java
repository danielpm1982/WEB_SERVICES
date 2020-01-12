package com.danielpm1982.REST_WS6.controller;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.danielpm1982.REST_WS6.entity.User;
import com.danielpm1982.REST_WS6.service.UserServiceInterface;

@Controller
public class WelcomeController {
	@Value("${welcomeMessage}")
	private String welcomeMessage;
	@Value("${credits}")
	private String credits;
	@Value("${email}")
	private String email;
	@Autowired
    @Qualifier("userService")
    private UserServiceInterface userService;
	@RequestMapping("/")
	public String showHomePage(Model model) {
		model.addAttribute("welcomeMessage", welcomeMessage);
		model.addAttribute("credits", credits);
		model.addAttribute("email", email);
		return "home";
	}
	@GetMapping("/welcome")
	public String showWelcomePage(HttpServletRequest request) {
		Object access_token = request.getSession().getAttribute("access_token");
		SecurityContextHolder.getContext().setAuthentication((Authentication)request.getSession().getAttribute("authentication"));
		if(access_token!=null) {
	        return "welcome";
		}
		return "redirect:/login";
	}
	@GetMapping("/error")
	public String showErrorPage() {
		return "error";
	}
	@GetMapping("/login")
	public String showloginPage() {
		return "login";
	}
	@PostMapping("/loginResult")
	public String showloginResultPage(HttpServletRequest request) {
		//setting the access_token request-scoped parameter value to an attribute at the Session for later use
		request.getSession().setAttribute("access_token", request.getParameter("access_token"));
		//setting the last Spring SecurityContext Authentication to an attribute in the Session for later use 
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		request.getSession().setAttribute("authentication", authentication);
		//getting from the userService and setting in an attribute at the Session the authenticated User for later use
		User user = userService.findByUserName(authentication.getName());
		request.getSession().setAttribute("user", user);
		return "welcome";
	}
	@GetMapping("/logoutResult")
	public String showlogoutResultPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//cleaning access_token and authentication attributes from the Session before logging out
		request.getSession().setAttribute("access_token", null);
		request.getSession().setAttribute("authentication", null);
		request.getSession().setAttribute("user", null);
		return "redirect:/login?logout";
	}
	@GetMapping("/accessDenied")
	public String showAccessDeniedPage() {
		return "accessDenied";
	}
}

/*
This Controller deals with general mapping paths to this web application, including authentication
and error handling ones.
/loginResult and /logoutResult could have been implemented at the config package using 
AuthenticationSuccessHandler and LogoutSuccessHandler classes instead, later set at the http 
configuration, similar to the implementation at the former REST_WS6 project.
*/
