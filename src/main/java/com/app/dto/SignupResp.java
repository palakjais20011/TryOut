package com.app.dto;

import java.time.LocalDate;

import com.app.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SignupResp {
private Long id;
private String firstName;
private String lastName;
private Role role;
private LocalDate DOB;
private String panNumber;
private String email;
}