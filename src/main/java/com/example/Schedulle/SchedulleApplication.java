package com.example.Schedulle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.Schedulle.auth.UserEntity;
import com.example.Schedulle.auth.UserService;

@SpringBootApplication
public class SchedulleApplication {

	@Autowired
	UserService userService;

	public static void main(String[] args) {

		  ConfigurableApplicationContext ctx = SpringApplication.run(SchedulleApplication.class, args);
		 SchedulleApplication app = ctx.getBean(SchedulleApplication.class);
	        app.execStartup(args);
	}

	public void execStartup(String[] args){
		UserEntity user = new UserEntity("店長","aaaa","a@icloud.com");
		UserEntity user1 = new UserEntity("アルバイト1","1111","1@icloud.com");
		UserEntity user2 = new UserEntity("アルバイト2","2222","2@icloud.com");
		UserEntity user3 = new UserEntity("アルバイト3","3333","3@icloud.com");
		UserEntity user4 = new UserEntity("アルバイト4","4444","4@icloud.com");
		UserEntity user5 = new UserEntity("アルバイト5","5555","5@icloud.com");
		UserEntity user6 = new UserEntity("アルバイト6","6666","6@icloud.com");
		UserEntity user7 = new UserEntity("アルバイト7","7777","7@icloud.com");
		UserEntity user8 = new UserEntity("アルバイト8","8888","8@icloud.com");
		UserEntity user9 = new UserEntity("アルバイト9","9999","9@icloud.com");
		UserEntity user10 = new UserEntity("アルバイト10","1010","10@icloud.com");

		userService.saveUser(user);
		userService.saveUser(user1);
		userService.saveUser(user2);
		userService.saveUser(user3);
		userService.saveUser(user4);
		userService.saveUser(user5);
		userService.saveUser(user6);
		userService.saveUser(user7);
		userService.saveUser(user8);
		userService.saveUser(user9);
		userService.saveUser(user10);
	}

}
