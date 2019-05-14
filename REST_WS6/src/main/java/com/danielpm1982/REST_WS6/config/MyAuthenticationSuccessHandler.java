package com.danielpm1982.REST_WS6.config;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import com.danielpm1982.REST_WS6.entity.User;
import com.danielpm1982.REST_WS6.service.UserServiceInterface;

@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    @Qualifier("userService")
    private UserServiceInterface userService;
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		String userName = authentication.getName();
		User user = userService.findByUserName(userName);
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		System.out.println("Authenticated User: "+user);
		response.sendRedirect(request.getContextPath() + "/welcome");
	}
}

/*
This is a basic event listener class, in which, when authentication succeeds, that catched event triggers
the method above to find the respective User at the DB, using its userName, and set that found User to the 
HttpSession, where the User data keeps alive until the session ends. It also redirects from the login processing
url - "/loginResult" - to the "/welcome" mapping url (see welcomeController).
The Authentication bean above guards some of the standard authenticated User info, but more custom data can be 
accessed from the User entity itself, and that's why both are set to the session here... and thus can be got from 
the view JSPs, for example. See the view pages.
For more about authentication/authorization, see MyWebSecurityConfigurerAdapter config class.
*/
