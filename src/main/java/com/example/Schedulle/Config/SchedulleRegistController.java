package com.example.Schedulle.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Schedulle.common.schedulle.SchedulleEntity;
import com.example.Schedulle.common.schedulle.SchedulleService;

@Controller
public class SchedulleRegistController {

	@Autowired
	SchedulleService schedulleSevice;


	@PostMapping("ShiftRegist")
	public String ShiftRegist(@RequestParam("monthValue")Integer month, SchedulleEntity schedulleEntitity,Model model) {
		schedulleEntitity.setMonthValue(month);
		schedulleSevice.insert(schedulleEntitity);
		return "redirect:/home";
	}
}
