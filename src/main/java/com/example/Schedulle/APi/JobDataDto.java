package com.example.Schedulle.APi;

import java.util.Date;
import java.util.List;

public class JobDataDto {

	private static final List<String> salaryType = List.of("時給","日給","月給","年収");
	/*private static Map<Integer,String> employmentTypeCode = new HashMap<>() {
	 {
		 put(100,"正社員");
		 put(110,"新卒採用");
		 put(120,"パート・アルバイト");
		 put(130,"派遣社員");
		 put(140,"インターン");
		 put(150,"ボランティア");
		 put(160,"契約社員");
		 put(170,"業務委託");
		 put(180,"プロボノ");
	 }
 };
	 */


	//掲載記事について
	Date startDate;


	Date endDate;


	String title;

	//住所
	String workLocationPrefecture;
	String workLocationCity;
	String workLocationTown;
	String workLocationBlock;
	String workLocationBuilding;
	String accessRoute;

	//会社内容
	String officeAtmosphere;
	String cpName;

	//画像
	String imgUrlPc;

	//雇用内容
	String workingTimeNote;

	//給与
	String salalyNote;
	int salaryTypeCode;
	int salaryMax;
	int salaryMin;

	//応募について
	String receptionMethod;
	String receptionTell;
	String receptionMail;
	String receptionUrl;

	public String getDateFormat() {
		if(endDate == null) {
			return "no!!";
		}
		return endDate.getMonth()+"月"+endDate.getDay()+"日";
	}


	public int getSalaryMax() {
		return salaryMax;
	}


	public void setSalaryMax(int salaryMax) {
		this.salaryMax = salaryMax;
	}


	public int getSalaryMin() {
		return salaryMin;
	}


	public void setSalaryMin(int salaryMin) {
		this.salaryMin = salaryMin;
	}


	public static List<String> getSalarytype() {
		return salaryType;
	}


	public String getSalaryType() {
		if(salaryTypeCode == 0)return "no";
		return salaryType.get(salaryTypeCode-1);
	}
	public int getkeisaiDate() {
		int ans = endDate.getDate()- startDate.getDate();
		return ans;
	}

	public String getImgUrlPc() {
		return imgUrlPc;
	}

	public void setImgUrlPc(String imgUrlPc) {
		this.imgUrlPc = imgUrlPc;
	}
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getOfficeAtmosphere() {
		return officeAtmosphere;
	}

	public void setOfficeAtmosphere(String officeAtmosphere) {
		this.officeAtmosphere = officeAtmosphere;
	}

	public String getWorkingTimeNote() {
		return workingTimeNote;
	}

	public void setWorkingTimeNote(String workingTimeNote) {
		this.workingTimeNote = workingTimeNote;
	}

	public String getSalalyNote() {
		return salalyNote;
	}

	public void setSalalyNote(String salalyNote) {
		this.salalyNote = salalyNote;
	}

	public int getSalaryTypeCode() {
		return salaryTypeCode;
	}

	public void setSalaryTypeCode(int salaryTypeCode) {
		this.salaryTypeCode = salaryTypeCode;
	}

	public String getReceptionMethod() {
		return receptionMethod;
	}

	public void setReceptionMethod(String receptionMethod) {
		this.receptionMethod = receptionMethod;
	}

	public String getReceptionTell() {
		return receptionTell;
	}

	public void setReceptionTell(String receptionTell) {
		this.receptionTell = receptionTell;
	}

	public String getReceptionMail() {
		return receptionMail;
	}

	public void setReceptionMail(String receptionMail) {
		this.receptionMail = receptionMail;
	}

	public String getReceptionUrl() {
		return receptionUrl;
	}

	public void setReceptionUrl(String receptionUrl) {
		this.receptionUrl = receptionUrl;
	}


	public String getCpName() {
		return cpName;
	}

	public void setCpName(String cpName) {
		this.cpName = cpName;
	}

	public String getTitle() {
		return title;
	}

	public String getWorkLocationPrefecture() {
		return workLocationPrefecture;
	}

	public void setWorkLocationPrefecture(String workLocationPrefecture) {
		this.workLocationPrefecture = workLocationPrefecture;
	}

	public String getWorkLocationCity() {
		return workLocationCity;
	}

	public void setWorkLocationCity(String workLocationCity) {
		this.workLocationCity = workLocationCity;
	}

	public String getWorkLocationTown() {
		return workLocationTown;
	}

	public void setWorkLocationTown(String workLocationTown) {
		this.workLocationTown = workLocationTown;
	}

	public String getWorkLocationBlock() {
		return workLocationBlock;
	}

	public void setWorkLocationBlock(String workLocationBlock) {
		this.workLocationBlock = workLocationBlock;
	}

	public String getWorkLocationBuilding() {
		return workLocationBuilding;
	}

	public void setWorkLocationBuilding(String workLocationBuilding) {
		this.workLocationBuilding = workLocationBuilding;
	}

	public String getAccessRoute() {
		return accessRoute;
	}

	public void setAccessRoute(String accessRoute) {
		this.accessRoute = accessRoute;
	}

	public void setTitle(String title) {
		this.title = title;
	}




}
