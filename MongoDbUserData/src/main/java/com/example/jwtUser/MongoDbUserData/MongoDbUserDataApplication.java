package com.example.jwtUser.MongoDbUserData;

import com.example.jwtUser.MongoDbUserData.filter.Filter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MongoDbUserDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDbUserDataApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean jwtFilter()
	{
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new Filter());
		filterRegistrationBean.addUrlPatterns("/usermovieapp/user/addMovie/*");
		return filterRegistrationBean;

	}
}
