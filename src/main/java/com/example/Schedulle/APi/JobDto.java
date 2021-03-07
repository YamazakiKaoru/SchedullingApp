package com.example.Schedulle.APi;

import java.util.ArrayList;
import java.util.List;

public class JobDto {

	  /** ステータス */
    int total;

    /** メッセージ */
    List<JobDataDto> results = new ArrayList<>();

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<JobDataDto> getResults() {
		return results;
	}

	public void setResults(List<JobDataDto> results) {
		this.results = results;
	}



}
