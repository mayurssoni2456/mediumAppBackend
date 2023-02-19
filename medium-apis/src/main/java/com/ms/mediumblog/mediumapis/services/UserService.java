package com.ms.mediumblog.mediumapis.services;

import java.util.List;

import com.ms.mediumblog.mediumapis.payloads.UserDto;

public interface UserService {

	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user, Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto> getAllUsers();
	void deleteUser(Integer userId);
}
