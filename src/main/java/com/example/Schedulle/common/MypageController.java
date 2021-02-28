package com.example.Schedulle.common;

import java.time.LocalDate;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.Schedulle.auth.UserEntity;
import com.example.Schedulle.auth.UserService;
import com.example.Schedulle.common.schedulle.MonthBase;
import com.example.Schedulle.common.schedulle.MonthBaseService;
import com.example.Schedulle.common.schedulle.SchedulleEntity;
import com.example.Schedulle.common.schedulle.SchedulleService;

/**
 *
 * @author kaoru
 *
 */
@Controller
public class MypageController {

	@Autowired
	MonthBaseService MonthBaseService;

	@Autowired
	UserService userSeivice;

	@Autowired
	SchedulleService schedulleService;

	@GetMapping("/home")
	public String home(Model model,@AuthenticationPrincipal UserEntity ownUser){

		model.addAttribute("ownUser", ownUser);

		//カレンダー情報の取得(リダイレクト用)
		List<MonthBase> userSchedulle = (List<MonthBase>) model.getAttribute("userSchedulle");

		if(userSchedulle == null) {//初回リクエスト時
			userSchedulle = MonthBaseService.getMonthMap(LocalDate.now().getMonthValue());
		}

		//
		List<SchedulleEntity> schedulleList = schedulleService.findAllByMonthValue
				(userSchedulle.get(0).getCurrentDate().getMonthValue());

		model.addAttribute("userSchedulle", userSchedulle);
		model.addAttribute("currentDate", userSchedulle.get(0).getCurrentDate());

		//UserListの情報の取得
		List<UserEntity> users = userSeivice.findAllUser();
		model.addAttribute("users", users);

		//シフト申請をするオブジェクトをadd
		model.addAttribute("shiftRegistForm", new SchedulleEntity());

		//画像処理
		if(ownUser.getPictureData() == null) {
			System.out.println("called");
			model.addAttribute("image", "images/NoImage.png");
			return "home";
		}
		String image = Base64.getEncoder().encodeToString(ownUser.getPictureData());
		model.addAttribute("image", image);


		return "home";
	}

	@GetMapping("/previous")
	public String previous(RedirectAttributes redirectAttributes) {
		List<MonthBase> userSchedulle = MonthBaseService.getMonthMap(MonthBaseService.getCurrentMonth()-1);
		redirectAttributes.addFlashAttribute("userSchedulle", userSchedulle);
		return "redirect:/home";
	}

	@GetMapping("/next")
	public String next(RedirectAttributes redirectAttributes) {
		List<MonthBase> userSchedulle = MonthBaseService.getMonthMap(MonthBaseService.getCurrentMonth()+1);
		redirectAttributes.addFlashAttribute("userSchedulle",userSchedulle);
		return "redirect:/home";
	}
}

