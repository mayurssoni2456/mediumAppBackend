package com.ms.mediumblog.mediumapis.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	private int id;
	private String name;
	private String email;
	private int salt;
	private String hash;
	private String about;
	}
