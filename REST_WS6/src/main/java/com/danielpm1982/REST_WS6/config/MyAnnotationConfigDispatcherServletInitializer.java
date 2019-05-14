package com.danielpm1982.REST_WS6.config;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyAnnotationConfigDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	public MyAnnotationConfigDispatcherServletInitializer() {
	}
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{ MyApplicationContextConfig.class };
	}
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
}

/*
This config class initializes the dispatcher servlet, pointing to the MyApplicationContextConfig class.
It extends AbstractAnnotationConfigDispatcherServletInitializer and overrides the three methods above.
*/
