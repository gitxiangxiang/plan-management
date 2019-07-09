package com.sxp.planmanagement.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author sxp
 * @create 2019-07-04 22:10
 **/
@Configuration
public class ViewMapConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
//        registry.addViewController("/").setViewName("index");
        registry.addViewController("/products").setViewName("products");
        registry.addViewController("/accounts").setViewName("accounts");
        registry.addViewController("/edit-product").setViewName("edit-product");
        registry.addViewController("/new-project").setViewName("new-project");

    }
}
