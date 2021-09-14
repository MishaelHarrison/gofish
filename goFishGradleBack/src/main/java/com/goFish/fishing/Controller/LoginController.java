package com.goFish.fishing.Controller;

import com.goFish.fishing.Exceptions.UserAddError;
import com.goFish.fishing.Service.Impl.LoginServiceImpl;
import com.goFish.fishing.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private LoginService loginService;
    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    public ResponseEntity addUser(String userName){
        try{
            loginService.addUser(userName);
            return ResponseEntity.ok().build();
        }
        catch(UserAddError e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }


}
