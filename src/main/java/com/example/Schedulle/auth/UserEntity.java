package com.example.Schedulle.auth;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.Schedulle.BaseEntity;

import lombok.Data;

/**
 * ユーザー情報を持つEntity
 */
@Entity
@Table(name="user",schema="public")
@Data
public class UserEntity extends BaseEntity implements UserDetails{

	@Column(name="name",nullable=false)
	private String name;

	@Column(name="password",nullable=false)
	private String password;

	@Column(name="mail",nullable=false)
	private String mail;

	//アカウント作成時の時間を持つ
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	//プロフィール画像のパス
	@Column(name = "fileName")
	private String fileName = "NoImages.png";

	public UserEntity() {
	}

	public UserEntity(String name,String pass,String mail) {
		this.name= name;
		this.password=pass;
		this.mail=mail;
	}

	//登録時に、日時を自動セットする
	@PrePersist
	public void prePersist() {
		this.createdAt = new Date();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	public void setPassword(String pass) {
		this.password = pass;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return mail;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



}
