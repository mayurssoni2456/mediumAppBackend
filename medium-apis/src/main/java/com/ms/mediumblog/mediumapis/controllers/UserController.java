package com.ms.mediumblog.mediumapis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ms.mediumblog.mediumapis.payloads.ApiResponse;
import com.ms.mediumblog.mediumapis.payloads.UserDto;
import com.ms.mediumblog.mediumapis.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	// post-create user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
		UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}
	
	// PUT  user
	@PutMapping("/{userId}")
		public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable Integer userId) {
			UserDto updatedUser = this.userService.updateUser(userDto, userId);
			return ResponseEntity.ok(updatedUser);
		}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId) {
		this.userService.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Sucessfully", true), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUser(@PathVariable Integer userId) {
		
			UserDto userD = this.userService.getUserById(userId);
			return ResponseEntity.ok(userD);			
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers() {
		List <UserDto> userDtos = this.userService.getAllUsers();
		return ResponseEntity.ok(userDtos);
	}
}
