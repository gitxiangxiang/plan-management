//package com.sxp.planmanagement.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
///**
// * @author sxp
// * @create 2019-07-04 22:02
// **/
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                //访问"/"和"/login"路径的请求都允许
//                .antMatchers("/", "/login", "/register", "/static")
//                .permitAll()
//                //而其他的请求都需要认证
//                .anyRequest()
//                .authenticated()
//                .and()
//                //修改Spring Security默认的登陆界面
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        //基于内存来存储用户信息
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("user").password(new BCryptPasswordEncoder().encode("123")).roles("USER").and()
//                .withUser("admin").password(new BCryptPasswordEncoder().encode("456")).roles("USER","ADMIN");
//    }
//
//}
