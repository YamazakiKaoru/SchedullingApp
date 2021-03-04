package com.example.Schedulle.common.schedulle;

import java.util.List;

import lombok.Data;

/**
 * シフトの一日情報を持つクラス
 *
 */
@Data
public class DateBase {

	public static List<String> YOUBI = List.of("日","月","火","水","木","金","土");

	private static String HOLIDAY = "休";

	//曜日を表す
	private String dayOfWeek;

	//状態
	private String state ;

	public DateBase() {
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
