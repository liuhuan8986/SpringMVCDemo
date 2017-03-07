package liuhuan.config;

import java.io.IOException;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
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
		templateResolver.setCharacterEncoding("UTF-8");
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
	
/*	@Bean
	public MultipartResolver multipartResolver() throws IOException{
		
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		//这个地址  会在 workspace 上级目录下 建立： 意思就是这个目录会和workspace同一级别
		//比如 我的workspace是D:\\javaEEDevSpace
		//那这tmp的目录就是：D:\\tmp\\spittr\\uploads
		multipartResolver.setUploadTempDir(new FileSystemResource("/tmp/spittr/uploads"));
		multipartResolver.setMaxInMemorySize(0);
		multipartResolver.setMaxUploadSize(30*1024*1024);
		return multipartResolver;
	}
	*/
	
	@Bean
	public MultipartResolver multipartResolver() throws IOException{
		
		StandardServletMultipartResolver multipartResolver = new StandardServletMultipartResolver();
		//这个地址  会在 workspace 上级目录下 建立： 意思就是这个目录会和workspace同一级别
		//比如 我的workspace是D:\\javaEEDevSpace
		//那这tmp的目录就是：D:\\tmp\\spittr\\uploads
		return multipartResolver;
	}
	
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// TODO Auto-generated method stub
		super.configureDefaultServletHandling(configurer);
		configurer.enable();
	}

	
}
