package liuhuan.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		System.out.println("1111111111111");
		return new Class<?>[]{RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		System.out.println("222222222222222");
		return new Class<?>[]{WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		System.out.println("33333333333");
		return new String[]{"/"};
	}

	@Override
	protected Filter[] getServletFilters() {
		// TODO Auto-generated method stub
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8", true);
		return new Filter[]{characterEncodingFilter};
	}

}
