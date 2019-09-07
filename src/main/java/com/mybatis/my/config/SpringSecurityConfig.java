package com.mybatis.my.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mybatis.my.bean.RespBean;
import com.mybatis.my.common.UserUtils;
import com.mybatis.my.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import java.io.PrintWriter;

/**
 * @author 17715
 */
@Configuration
//增加权限
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserServer userServer;
    @Autowired
    CustomMetadataSource metadataSource;
    @Autowired
    UrlAccessDecisionManager urlAccessDecisionManager;
    @Autowired
    AuthenticationAccessDeniedHandler deniedHandler;


    @Override
    public void configure(WebSecurity web) throws Exception {
        //不拦截静态资源的访问
        web.ignoring().antMatchers("/js/**", "/css/**", "/images/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      /*  http.authorizeRequests()                 //开启登陆验证
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and().logout().permitAll()
                .and().formLogin();*/
        http.authorizeRequests()
                .antMatchers("/login", "/login_p").permitAll()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setSecurityMetadataSource(metadataSource);
                        o.setAccessDecisionManager(urlAccessDecisionManager);
                        return o;
                    }
                })
                .and()
                .formLogin()/*.loginPage("/login").loginProcessingUrl("/login_p")*/
                .usernameParameter("username").passwordParameter("password")
                .failureHandler((req, resp, e) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    RespBean respBean = null;
                    if (e instanceof BadCredentialsException ||
                            e instanceof UsernameNotFoundException) {
                        respBean = RespBean.error("账户名或者密码输入错误!");
                    } else if (e instanceof LockedException) {
                        respBean = RespBean.error("账户被锁定，请联系管理员!");
                    } else if (e instanceof CredentialsExpiredException) {
                        respBean = RespBean.error("密码过期，请联系管理员!");
                    } else if (e instanceof AccountExpiredException) {
                        respBean = RespBean.error("账户过期，请联系管理员!");
                    } else if (e instanceof DisabledException) {
                        respBean = RespBean.error("账户被禁用，请联系管理员!");
                    } else {
                        respBean = RespBean.error("登录失败!");
                    }
                    resp.setStatus(401);
                    ObjectMapper om = new ObjectMapper();
                    PrintWriter out = resp.getWriter();
                    out.write(om.writeValueAsString(respBean));
                    out.flush();
                    out.close();
                })
                .successHandler((req, resp, auth) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    RespBean respBean = RespBean.ok("登录成功!", UserUtils.getCurrentUser().getUser());
                    ObjectMapper om = new ObjectMapper();
                    PrintWriter out = resp.getWriter();
                    out.write(om.writeValueAsString(respBean));
                    out.flush();
                    out.close();
                })
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler((req, resp, authentication) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    RespBean respBean = RespBean.ok("注销成功!");
                    ObjectMapper om = new ObjectMapper();
                    PrintWriter out = resp.getWriter();
                    out.write(om.writeValueAsString(respBean));
                    out.flush();
                    out.close();
                })
                .permitAll()
                .and().csrf().disable()
                .exceptionHandling().accessDeniedHandler(deniedHandler);

        // 禁用缓存
        http.headers().cacheControl();

        /* http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);*/
    }

    /**
     * 用于登陆的验证
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userServer).passwordEncoder(new BCryptPasswordEncoder());
    }
}
