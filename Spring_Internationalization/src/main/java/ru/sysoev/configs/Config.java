package ru.sysoev.configs;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class Config implements WebMvcConfigurer{

	// Determine which locale is currently in use
	@Bean
	LocaleResolver localeResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver(); 
		//Also can be "CookieLocaleResolver", "AcceptHeaderLocaleResolver" 
		localeResolver.setDefaultLocale(Locale.US);
		localeResolver.setLocaleAttributeName("session.current.locale");
		localeResolver.setTimeZoneAttributeName("session.current.timezone");
		return localeResolver;
	}

	// Switch to a new locale based on the value of the lang parameter when present on the request
    @Bean
    LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("language");
        return localeChangeInterceptor;
    }
    
    //from interface -> WebMvcConfigurer
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
    
    //define the base name of our resource bundle 
    //Alternative -> spring.messages.basename=language/messages
    @Bean
    MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("languages/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

}
