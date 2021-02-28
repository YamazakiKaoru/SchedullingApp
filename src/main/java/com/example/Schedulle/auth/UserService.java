package com.example.Schedulle.auth;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	UserRepostitory userRepository;

	@Autowired
	BCryptPasswordEncoder encoder;


	@Transactional
	public List<UserEntity> findAllUser(){
		return userRepository.findAll();
	}

	@Transactional
	public void saveUser(UserEntity user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	@Transactional
	public UserEntity findById(Integer id) {
		return userRepository.getOne(id);
	}

	@Transactional
	public void update(UserEntity user) {
	userRepository.save(user);
	}


	@Transactional
	@Override
	public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
	UserEntity user = userRepository.findBymail(mail);
	if(user == null) {
		throw new UsernameNotFoundException("Cloud not find " + mail);
	}
		return user;
			}
}
