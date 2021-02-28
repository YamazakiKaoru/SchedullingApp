package com.example.Schedulle.common.schedulle;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Schedulle.auth.UserEntity;
import com.example.Schedulle.auth.UserService;

import lombok.Data;

/**
 *
 * @author kaoru
 *
 */
@Service
@Data
public class MonthBaseService {

	@Autowired
	UserService userService;

	@Autowired
	SchedulleService schedulleService;

	//現在月
	private Integer currentMonth;
	//一か月分の日程リスト
	private List<MonthBase> schedulleList = new ArrayList<>();

	public MonthBaseService() {
	}

	/**
	 * 指定月に合わせて
	 * ユーザーのテーブルと
	 * シフト申請用テーブルを合わせて返す。
	 * @param currentMonth 指定月
	 * @return ユーザーごとの月Map(List)
	 */
	@Transactional
	public List<MonthBase> getMonthMap(int currentMonth) {
		this.currentMonth = currentMonth;
		schedulleList.clear();
		//ユーザー情報の取得
		List<UserEntity> users = userService.findAllUser();
		//指定された月でシフトテーブルを取得
		List<SchedulleEntity> schedulles = schedulleService.findAllByMonthValue(currentMonth);

		//ユーザー分listにテーブルを追加
		users.forEach(user -> {
		MonthBase usertmp = new MonthBase(currentMonth);
		usertmp.setUserName(user.getName());
		schedulleList.add(usertmp);
		});

		//テーブルにスケジュールを追加
		schedulles.forEach(schedulle -> {
			setDateState(schedulle.getUserId()-1, schedulle.getDate(),schedulle.getDateFormat());
		});
		return schedulleList;
	}

	/**
	 * 指定された（ユーザーID、日にち）を状態を変更する
	 * @param userId ユーザーID
	 * @param data 日にち
	 * @param state 状態
	 */
	@Transactional
	public void setDateState(int userId,int data,String state) {
		schedulleList.get(userId).setDateState(data, state);
	}

}
