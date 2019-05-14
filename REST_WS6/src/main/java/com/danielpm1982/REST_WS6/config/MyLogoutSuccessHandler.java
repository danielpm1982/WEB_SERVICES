package com.danielpm1982.REST_WS6.config;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;
import com.danielpm1982.REST_WS6.entity.User;
import com.danielpm1982.REST_WS6.service.UserServiceInterface;

@Component
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {
    @Autowired
    @Qualifier("userService")
    private UserServiceInterface userService;
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		String userName = authentication.getName();
		User user = userService.findByUserName(userName);
		System.out.println("Logged out User: "+user);
		request.getSession().setAttribute("user", null);
		response.sendRedirect(request.getContextPath() + "/login?logout");
	}
}

/*
Similar to MyAuthenticationSuccessHandler, only to show on server console which user has logged 
out successfully.
*/
