package com.bdqn.config.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

/**
 * @author zf
 * @create 2020-02-15 11:32
 */
//扩展springmvc
    //如果你想diy一些定制的功能，只需要写这个组件，然后将他交给springboot  ，springboot会帮我们自动装配
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //ViewResolver 实现了视图解析器接口的类，我们可以把他看作视图解析器
@Bean
public  ViewResolver myViewResolver(){

    return new MyViewResolver();
}
    @Bean
    public LocaleResolver localeResolver(){

        return  new MyLocaleResolver();
    }

    //自定义一个自己的视图解析器 MyViewResolver
    public  static  class  MyViewResolver implements ViewResolver{

        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }


    //视图跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    //访问路径/a 跳转到user页面
registry.addViewController("/").setViewName("indexT");
        registry.addViewController("/indexT.html").setViewName("indexT");
        registry.addViewController("/main.html").setViewName("dashboard");
        }

    @Override
    //实现自定义的拦截器interceptor
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).
                addPathPatterns("/**").
                excludePathPatterns("/","/indexT.html","/login","/css/**","/js/**","/img/**");
    }
}
