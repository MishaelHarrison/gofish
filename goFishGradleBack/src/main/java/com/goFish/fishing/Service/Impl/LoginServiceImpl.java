package com.goFish.fishing.Service.Impl;

import com.goFish.fishing.Exceptions.UserAddError;
import com.goFish.fishing.Repo.UserRepo;
import com.goFish.fishing.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    private UserRepo userRepo;
    @Autowired
    public LoginServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public void addUser(String userName) {
        if(userRepo.findByUsername(userName).orElse(null) != null)
        {
            throw new UserAddError();
        }
    }
}
