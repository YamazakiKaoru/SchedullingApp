package com.example.Schedulle.common.schedulle;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;

/**
 * カレンダーの月情報を持つクラス
 */
@Data
public class MonthBase {

	private LocalDate currentDate;
	/** ユーザー名 **/
	private String userName;

	private Map<Integer,DateBase> details = new HashMap<>();

	public MonthBase(int currentMonth) {
		LocalDate nowDate = LocalDate.now();
		currentDate = LocalDate.of(nowDate.getYear(), nowDate.getMonthValue(),1);
		setdetailsDate(currentMonth);
	}

	/**
	 * mapの月を設定し
	 * 月の長さ分だけmapを確保する
	 * @param plusMonth 指定月
	 */
	public void setdetailsDate(int plusMonth) {
		currentDate = currentDate.plusMonths(plusMonth-LocalDate.now().getMonthValue());
		int firstDayOfWeek = currentDate.getDayOfWeek().getValue();
		int lastDay = currentDate.lengthOfMonth();
		details.clear();
		for(int day=1;day<=lastDay;day++) {
			DateBase date = new DateBase();
			date.setDayOfWeek(DateBase.YOUBI.get((day+firstDayOfWeek-1)%7));
			details.put(day, date);
		}
	}

	/**
	 * 指定した日付の状態を設定する
	 * @param day　指定する日程
	 * @param state　状態
	 */
	public void setDateState(int day,String state) {
		details.get(day).setState(state);
	}



}
