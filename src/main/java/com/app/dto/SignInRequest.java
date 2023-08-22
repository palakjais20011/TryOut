package com.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SignInRequest {
	@Email(message = "Invalid email format")
	private String email;
	@NotBlank
	//@Length(min = 5,max=20,message = "Invalid password length")
	private String password;
}
