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

/**
 * プロフィール編集を行うコントローラー
 */
@Controller
public class ProfileEditController {

	@Autowired
	UserService userService;

	@Autowired
	ProfileService profileEditService;

	@GetMapping("/ProfileEdit")
	public String profileEdit(Model model, @AuthenticationPrincipal UserEntity ownUser) {

		//画像処理
		String imagedata = profileEditService.getProfileData(ownUser);

		model.addAttribute("imageFile", imagedata);

		model.addAttribute("ownUser", ownUser);
		return "ProfileEdit";
	}

	@PostMapping("/ProfilePictureEdit")
	public String changePicture(@RequestParam("file") MultipartFile multipartFile, Model model,
			@AuthenticationPrincipal UserEntity ownUser) throws IOException {

		profileEditService.updatePhoto(multipartFile, ownUser);


		return "redirect:/home";
	}
}
