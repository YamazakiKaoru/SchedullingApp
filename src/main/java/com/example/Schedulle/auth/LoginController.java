package com.example.Schedulle.auth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * ログインを行うコントローラー
 */
@Controller
public class LoginController {

	@Autowired
	UserService userService;

	@GetMapping("/")
	public String login(Model model) {
		List<UserEntity> list = userService.findAllUser();
		model.addAttribute("userlist", list);
		return "login";
	}

	@GetMapping("/signIn")
	public String signIn(Model model) {
		model.addAttribute("userForm", new UserEntity());
		return "signIn";
	}

	@PostMapping("/signInDone")
	public String signInDone(UserEntity user,Model model) {
		userService.saveUser(user);
		model.addAttribute("addUser", user);
		return "signInConfirm";
	}
}
