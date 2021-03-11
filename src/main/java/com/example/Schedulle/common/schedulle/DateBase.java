package com.example.Schedulle.common.schedulle;

import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * 一日の基本データを持つクラス
 */
@Data
public class DateBase {

	public static List<String> YOUBI = List.of("日","月","火","水","木","金","土");

	private Date date;

	private static String HOLIDAY = "休";

	//曜日を表す
	private String dayOfWeek;

	//状態
	private String state ;

	public DateBase(Date date) {
		this.date = date;
		this.state = HOLIDAY;
	}


	/**
	 * htmlのidを指定するためのメソッド
	 * 休みなら id = "Holiday"
	 * 以外なら id = "unHoliday"
	 * @return　id用のString
	 */
	public String isHoliday() {
		if(state == HOLIDAY)return HOLIDAY;
		else return "unHoliday";
	}

}
