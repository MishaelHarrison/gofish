package com.goFish.fishing.Service;

import com.goFish.fishing.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private UserRepo userRepo;
    @Autowired
    public LoginService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
}
