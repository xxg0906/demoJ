package top.xxgo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author xxg
 */
@Configuration
@EnableWebSecurity
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//
//                .authorizeRequests().antMatchers("/getPublicKey","/oauth/logout").permitAll()
//
//
//                 // @link https://gitee.com/xiaoym/knife4j/issues/I1Q5X6 (Security放行url)
//                .antMatchers("/webjars/**","/doc.html","/swagger-resources/**","/v2/api-docs").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .csrf().disable();

        http.formLogin()
                .and()
                .authorizeRequests()
                .antMatchers("/auth/**").permitAll()
                .and().authorizeRequests().anyRequest().authenticated();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }




}
