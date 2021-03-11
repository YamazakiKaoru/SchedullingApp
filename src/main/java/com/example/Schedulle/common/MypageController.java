package com.example.Schedulle.common;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.Schedulle.auth.UserEntity;
import com.example.Schedulle.auth.UserService;
import com.example.Schedulle.auth.account.ProfileService;
import com.example.Schedulle.common.schedulle.MonthMap;
import com.example.Schedulle.common.schedulle.MonthMapService;
import com.example.Schedulle.common.schedulle.SchedulleEntity;

/**
 *　ホームページの処理を行うコントローラー
 */
@Controller
public class MypageController {

	@Autowired
	MonthMapService monthMapService;

	@Autowired
	UserService userSeivice;

	@Autowired
	ProfileService profileService;

	@GetMapping("/home")
	public String home(Model model,@AuthenticationPrincipal UserEntity ownUser){

		//ログイン情報の取得
		model.addAttribute("ownUser", ownUser);

		//シフト情報の取得(リダイレクト用)
		List<MonthMap> userSchedulle = (List<MonthMap>) model.getAttribute("userSchedulle");

		if(userSchedulle == null) {//初回リクエスト時
			userSchedulle = monthMapService.getMonthMap(LocalDate.now().getMonthValue());
		}

		model.addAttribute("userSchedulle", userSchedulle);
		model.addAttribute("currentDate", userSchedulle.get(0).getCurrentDate());

		//UserListの情報の取得
		List<UserEntity> users = userSeivice.findAllUser();
		model.addAttribute("users", users);

		//シフト申請をするオブジェクトをadd
		model.addAttribute("shiftRegistForm", new SchedulleEntity());

		//画像処理
		String imagedata = profileService.getProfileData(ownUser);
		model.addAttribute("imageFile", imagedata);

		return "home";
	}

	/**
	 *　シフトカレンダーの月を一月増やす
	 */
	@GetMapping("/previous")
	public String previous(RedirectAttributes redirectAttributes) {
		List<MonthMap> userSchedulle = monthMapService.getMonthMap(monthMapService.getCurrentMonth()-1);
		redirectAttributes.addFlashAttribute("userSchedulle", userSchedulle);
		return "redirect:/home";
	}

	/**
	 *　シフトカレンダーの月を一月減らす
	 */
	@GetMapping("/next")
	public String next(RedirectAttributes redirectAttributes) {
		List<MonthMap> userSchedulle = monthMapService.getMonthMap(monthMapService.getCurrentMonth()+1);
		redirectAttributes.addFlashAttribute("userSchedulle",userSchedulle);
		return "redirect:/home";
	}


}

