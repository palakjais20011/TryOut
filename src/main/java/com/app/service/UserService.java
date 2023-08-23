package com.app.service;

import java.util.List;

import com.app.payload.MyApiResponse;
import com.app.dto.SignupRequest;
public interface UserService {

	List<SignupRequest> getAllUsers();

	MyApiResponse deleteUser(Long uId);

	MyApiResponse updateUser(Long uId, SignupRequest user);
}
