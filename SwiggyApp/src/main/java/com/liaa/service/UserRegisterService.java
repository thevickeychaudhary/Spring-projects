package com.liaa.service;


import com.liaa.dto.UserRequestDto;
import com.liaa.entity.UserRegister;

public interface UserRegisterService {
    UserRegister createdSwiggyRegisterUserRegister(UserRequestDto userRequestDto);

	UserRegister createdSwiggyRegister(UserRequestDto userRequestDto);
}
