package com.example.Schedulle.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.Schedulle.auth.UserService;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	UserService userService;

	/**
	 * エンコードを行うBeanを定義
	 * @return
	 */

	  @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        // パスワードの暗号化用に、bcrypt（ビー・クリプト）を使用します
	        return new BCryptPasswordEncoder();
	    }
	/**
	 *
	 */
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService)
		.passwordEncoder(new BCryptPasswordEncoder());
		}

	/**
	 * 認可機能の設定
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		//ログイン設定
		http.formLogin()//コントローラーを経由しない
		.loginPage("/")//ログイン画面の指定
		.loginProcessingUrl("/loginDone")//ログイン処理を行うパスの指定
		.usernameParameter("mail")//今回はメールを認証機能の項目に設定
		.passwordParameter("password")
		.defaultSuccessUrl("/home")//
		.permitAll();

		//新規登録
		http.authorizeRequests()
		.antMatchers("/signIn").permitAll()
		.antMatchers("/signInDone").permitAll()
		.anyRequest().authenticated();

		//ログアウト
		http.logout()//
		.logoutUrl("/logout")
		.logoutSuccessUrl("/")
		.invalidateHttpSession(true)
		.deleteCookies("JSESSIONID")
		.permitAll();
	}

	/**
	 * 静的ファイルには認証をかけない
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("static/**");
	}



}


