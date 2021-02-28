package com.example.Schedulle.auth.account;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.Schedulle.auth.UserEntity;
import com.example.Schedulle.auth.UserService;

@Controller
public class ProfileEditController {

	@Autowired
	UserService userService;

	@GetMapping("/ProfileEdit")
	public String profileEdit(Model model,@AuthenticationPrincipal UserEntity ownUser) {

		model.addAttribute("ownUser", ownUser);
		return "ProfileEdit";
	}

	@PostMapping("/ProfilePicture")
	public String changePicture(@RequestParam("file") MultipartFile file,Model model,@AuthenticationPrincipal UserEntity ownUser) throws IOException {

		if(file == null) {
			return "redirect:home";
		}

		byte[] bytes= file.getBytes();

		UserEntity user = userService.findById(ownUser.getId());
		user.setPictureData(bytes);
		userService.update(user);

		return "redirect:/home";
	}
}
