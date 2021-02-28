package com.example.Schedulle.auth.account;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Schedulle.auth.UserEntity;
import com.example.Schedulle.auth.UserService;

@Service
public class ProfileEditService {

	@Autowired
	UserService userService;

	@Transactional
	public void editProfile(MultipartFile file,UserEntity user) {


	}

}
