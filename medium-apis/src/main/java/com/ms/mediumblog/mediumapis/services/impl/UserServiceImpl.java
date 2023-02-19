package com.ms.mediumblog.mediumapis.services.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.mediumblog.mediumapis.entities.User;
import com.ms.mediumblog.mediumapis.exceptions.ResourceNotFoundException;
import com.ms.mediumblog.mediumapis.payloads.UserDto;
import com.ms.mediumblog.mediumapis.repositories.UserRepo;
import com.ms.mediumblog.mediumapis.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(userId).orElseThrow( () -> new ResourceNotFoundException("User", "id", userId));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		
		User updatedUser = this.userRepo.save(user);
		UserDto updatedDto = this.userToDto(updatedUser);
		return updatedDto;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId)); 	
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		
		List<User> users = this.userRepo.findAll();
		List<UserDto>userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId)); 	
		this.userRepo.delete(user);
		
	}
	
	private User dtoToUser(UserDto userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setSalt(userDto.getSalt());
		user.setHash(userDto.getHash());
		user.setAbout(userDto.getAbout());
		return user;
	}
	
	private UserDto userToDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setSalt(user.getSalt());
		userDto.setHash(user.getHash());
		userDto.setAbout(user.getAbout());
		return userDto;
	}

}
