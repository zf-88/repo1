package com.bdqn.config.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;


/**
 * @author zf
 * @create 2020-02-16 20:49
 */
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {

                   //获取语言中的参数

                String language=   httpServletRequest.getParameter("l");
        Locale locale=Locale.getDefault();//如果没有就使用默认的
        if (!StringUtils.isEmpty(language)) {
            String [] split= language.split("_");
         locale=   new Locale(split[0],split[1]);
        }

        return locale;
    }



    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
