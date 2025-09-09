package com.liaa.service;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liaa.dto.UserRequestDto;
import com.liaa.entity.UserRegister;
import com.liaa.repository.UserRegisterRepo;
//import com.liaa.service.UserRegisterService;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {

    @Autowired
    private UserRegisterRepo userRegisterRepo;

    @Override
    public UserRegister createdSwiggyRegister(UserRequestDto dto) {
        UserRegister user = new UserRegister();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setPassword(Base64.getEncoder().encodeToString(dto.getPassword().getBytes()));
        user.setContactId(dto.getContactId());

        return userRegisterRepo.save(user);
    }

	@Override
	public UserRegister createdSwiggyRegisterUserRegister(UserRequestDto userRequestDto) {
		// TODO Auto-generated method stub
		return null;
	}
}
