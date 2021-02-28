package com.example.Schedulle.auth;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepostitory extends JpaRepository<UserEntity, Integer> {
	public UserEntity findBymail(String mail);
	public UserEntity findByid(Integer Id);

}
