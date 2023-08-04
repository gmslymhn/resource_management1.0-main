package com.lc.demo.config;


import com.lc.demo.interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//使用WebMvcConfigurerAdapter可以来扩展SpringMVC的功能
//@EnableWebMvc   不要接管SpringMVC
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//       // super.addViewControllers(registry);
//    }

    //所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean //将组件注册在容器
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/").setViewName("login");
//                registry.addViewController("/index.html").setViewName("login");
//                registry.addViewController("/register.html").setViewName("register");
//                registry.addViewController("/admmain.html").setViewName("/adm/adminindex");
//                registry.addViewController("/usermain.html").setViewName("/user/userindex");
//                registry.addViewController("/goodsadmin.html").setViewName("/adm/goodslist");
//                registry.addViewController("/goodsuser.html").setViewName("/user/goodslist");
//                registry.addViewController("/addgoods.html").setViewName("/adm/addgoods");

            }

            //注册拦截器
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                super.addInterceptors(registry);
////                静态资源；  *.css , *.js
////                SpringBoot已经做好了静态资源映射
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                        .excludePathPatterns("/login.html","/","/login","/adm/login","/tea/login");
//            }
        };
        return adapter;
    }

}
