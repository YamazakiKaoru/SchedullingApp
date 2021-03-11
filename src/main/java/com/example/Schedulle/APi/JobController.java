package com.example.Schedulle.APi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Schedulle.auth.UserEntity;
import com.example.Schedulle.auth.account.ProfileService;

@Controller
public class JobController {

    @Autowired
    JobService jobService;

    @Autowired
    ProfileService profileEditService;

    @GetMapping("/job")
    public String index(Model model,@AuthenticationPrincipal UserEntity ownUser) {

		//ログイン情報の取得
		model.addAttribute("ownUser", ownUser);

		//画像処理
		String imagedata = profileEditService.getProfileData(ownUser);
		model.addAttribute("imageFile", imagedata);

    	JobDto zipCodeDto = jobService.service();
        // thymeleafでリストを展開して表示する
        model.addAttribute("zipcodeList", zipCodeDto.getResults());
    	return "jobHome";
    }

}