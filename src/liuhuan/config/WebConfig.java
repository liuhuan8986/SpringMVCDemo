package liuhuan.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
@EnableWebMvc
@ComponentScan("liuhuan.web")
public class WebConfig extends WebMvcConfigurerAdapter {

/*	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}*/
	
/*	@Bean
	public ViewResolver viewResolver(){
		return new TilesViewResolver();
	}
	*/
	@Bean
	public ViewResolver viewResolver(){
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());
		viewResolver.setCharacterEncoding("UTF-8");
		return viewResolver;
		
	}
	
	@Bean
	public TemplateEngine templateEngine(){
		/*SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		return templateEngine;*/
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
//		templateEngine.addDialect(new SpringSecurityDialect());
		return templateEngine;
	}
	
	@Bean
	public ITemplateResolver templateResolver(){
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setPrefix("/WEB-INF/templates/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode("HTML5");
		return templateResolver;
	}
	
	
	@Bean
	public MessageSource message(){
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("classpath:message");
		//messageSource.setUseCodeAsDefaultMessage(true);
		return messageSource;
	}

	@Bean
	public TilesConfigurer tilesConfigurer(){
		TilesConfigurer configurer = new TilesConfigurer();
		//指定tile的位置
		configurer.setDefinitions("/WEB-INF/layout/tiles.xml");
		//启用刷新功能
		configurer.setCheckRefresh(true);
		return configurer;
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// TODO Auto-generated method stub
		super.configureDefaultServletHandling(configurer);
		configurer.enable();
	}

	
}
