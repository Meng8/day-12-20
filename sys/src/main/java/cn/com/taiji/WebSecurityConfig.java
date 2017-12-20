package cn.com.taiji;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//设置内存认证
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Throwable {
		//设置内存认证
		auth
		       .inMemoryAuthentication()
		 //设置用户名 密码 和 权限
		.withUser("root").password("root").roles("boss")
		//添加多个用户在后面.and()在用.就能调出来了
		       .and()
		.withUser("admin").password("admin").roles("bang");
		System.out.println("=====================");
	}
	
	
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
.antMatchers("/webjars/**", "/signup", "/about").permitAll()
		.antMatchers("/admin/**").hasRole("UADMINSER")
		.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
		.anyRequest().authenticated().and().formLogin()
		//设置跳转路径
		.loginPage("/login")
		//登陆成功后跳转的路径
		.permitAll()
		/*.successForwardUrl("/login")	*/
		.and().logout().and()
        .httpBasic();
		http.csrf().disable();
		
		System.out.println("=111111111111111111");
	}
}
