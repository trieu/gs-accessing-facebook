package vidzeo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.social.security.SpringSocialConfigurer;

import vidzeo.user.services.SimpleSocialUsersDetailService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	public void configure(WebSecurity webSecurity) throws Exception {
		webSecurity.ignoring().antMatchers("/static/**");
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource).withDefaultSchema();
		// auth.inMemoryAuthentication().withUser("root").password("qazxsw").roles("USER");
	}

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("kleber").password("123").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// http.csrf().disable();
		// http.authorizeRequests().antMatchers("/**").permitAll();

		http.formLogin().loginPage("/login").loginProcessingUrl("/login/authenticate")
				.failureUrl("/login?param.error=bad_credentials").permitAll().and().logout().logoutUrl("/logout")
				.deleteCookies("JSESSIONID").and().authorizeRequests()
				.antMatchers("/favicon.ico", "/static-resources/**").permitAll().antMatchers("/**").permitAll().and()
				.rememberMe().and().apply(new SpringSocialConfigurer().postLoginUrl("/").alwaysUsePostLoginUrl(true));
	}

	@Bean
	public SocialUserDetailsService socialUsersDetailService() {
		return new SimpleSocialUsersDetailService(userDetailsService());
	}

}
