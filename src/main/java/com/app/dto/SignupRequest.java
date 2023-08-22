package com.app.dto;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
/*
 * Validation rules : first name n last name : non blank email : valid n not
 * blank password : string password , not null emp designation : must be
 * supplied. join date : must be in present or future
 */
public class SignupRequest {
	@NotBlank(message = "first name can't be blank")
	private String firstName;
	@Length(min = 3, max = 20, message = "Invalid length of last name")
	private String lastName;
	@Email
	private String email;
	@NotNull(message = "invalid join date!!")
	private LocalDate DOB;
	@NotNull(message = "pan number cannot be blank")
	private String panNumber;
	@NotNull
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})",message = "invalid password format!!!!")
	private String password;
	//@NotNull(message = "role must be supplied!!!!")
	private Set<String> role;
}