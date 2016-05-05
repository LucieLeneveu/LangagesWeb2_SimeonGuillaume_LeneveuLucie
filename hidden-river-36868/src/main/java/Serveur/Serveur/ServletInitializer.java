package Serveur.Serveur;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import Serveur.Serveur.config.AppConfig;

public class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[0];
	}
	  
	  @Override
	  protected Class<?>[] getServletConfigClasses() {
	         return new Class<?>[]{AppConfig.class};
	  }
	  
	  @Override
	  protected String[] getServletMappings() {
	         return new String[]{"/"};
	  }
}
