package com.example.Schedulle.common.schedulle;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;

/**
 * 一か月のデータを持つクラス
 */
@Data
public class MonthMap {

	private LocalDate currentDate;
	/** ユーザー名 **/
	private String userName;

	private Map<Integer,DateBase> details = new HashMap<>();

	public MonthMap(int currentMonth) {
		LocalDate nowDate = LocalDate.now();
		currentDate = LocalDate.of(nowDate.getYear(), nowDate.getMonthValue(),1);
		setdetailsDate(currentMonth);
	}

	/**
	 * mapの月を設定し
	 * 月の長さ分だけmapを確保する
	 * @param plusMonth 指定月
	 */
	@SuppressWarnings("deprecation")
	public void setdetailsDate(int plusMonth) {
		//
		currentDate = currentDate.plusMonths(plusMonth-LocalDate.now().getMonthValue());

	    //月初めの曜日
		int firstDayOfWeek = currentDate.getDayOfWeek().getValue();

	    //月の長さ
		int lastDay = currentDate.lengthOfMonth();
		details.clear();

		//
		for(int day=1;day<=lastDay;day++) {
			DateBase date = new DateBase(new Date(currentDate.getDayOfYear(),currentDate.getDayOfMonth(),day));
			date.setDayOfWeek(DateBase.YOUBI.get((day+firstDayOfWeek-1)%7));
			details.put(day, date);
		}
	}

	public int getHow(int data) {
		int count = 0;
		while(true) {
			int i=1;
		if(details.get(data+i).getState() != DateBase.HOLIDAY) {
			i++;
			count++;
		}
		else break;
		}
		while(true) {
			int i=1;
			if(details.get(data-i).getState() != DateBase.HOLIDAY) {
				i++;
				count++;
			}
			else break;
		}

		return count;
	}



	/**
	 * 指定した日付の状態を設定する
	 * @param day　指定する日程
	 * @param state　状態
	 */
	public void setDateState(int day,String state) {
		details.get(day).setState(state);
	}

	public DateBase getDate(int date) {
		return details.get(date);
	}



}
