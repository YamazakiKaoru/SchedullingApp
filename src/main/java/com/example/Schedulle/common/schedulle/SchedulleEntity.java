package com.example.Schedulle.common.schedulle;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.Schedulle.BaseEntity;

import lombok.Data;

@Entity
@Table(name="Schedulle",schema="public")
@Data
public class SchedulleEntity extends BaseEntity{

	//
	@Column(name="monthValue",nullable=false)
	private Integer monthValue;

	//
	@Column(name="date",nullable=false)
	private Integer date;

	//
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
	@Column(name="sDate",nullable=false)
	private Date sDate;

	//
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
	@Column(name="eDate",nullable=false)
	private Date eDate;

	//
	@Column(name="userId",nullable=false)
	private Integer userId;


	public SchedulleEntity() {
	}

	/**
	 *
	 * @param monthValue
	 * @param sDate
	 * @param eDate
	 */
	public void setData(Integer monthValue,Date sDate,Date eDate) {
		this.eDate=eDate;
		this.sDate=sDate;
	}

	/**
	 *
	 * @return
	 */
	public String getDateFormat() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
		String tmp = dateFormat.format(sDate) + "～" + dateFormat.format(eDate);
		return tmp;
	}




}
