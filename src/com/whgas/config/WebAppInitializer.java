package com.whgas.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
	@Override
	protected String[] getServletMappings() {					//DispatcherServlet映射,从"/"开始
		return new String[] { "/" };
	}
	
	@Override
	protected Class<?>[] getRootConfigClasses() {					//根容器
		return new Class<?>[]	{RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {				//Spring mvc容器
		return new Class<?>[]	{WebConfig.class};
	}
}
