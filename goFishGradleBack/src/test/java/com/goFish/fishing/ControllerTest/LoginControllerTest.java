package com.goFish.fishing.ControllerTest;

import com.goFish.fishing.Controller.LoginController;
import com.goFish.fishing.Repo.UserRepo;
import com.goFish.fishing.Service.LoginService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoginControllerTest {
    private UserRepo userRepo;
    private LoginController subject;

    @BeforeAll
    public void setup(){
        userRepo = mock(UserRepo.class);
        subject = new LoginController(new LoginService(userRepo));
    }
    @Test
    public void successfulAdd(){
        when(userRepo.findByUsername("Bobby")).thenReturn(Optional.empty());
        ResponseEntity response = subject.addUser("Bobby");
        Assertions.assertEquals(200,response.getStatusCode().value());
    }
    @Test
    public void unsuccessfulAdd(){
        when(userRepo.findByUsername("Bobby")).thenReturn(Optional.empty());
        int response = subject.addUser("Bobby").getStatusCode().value();
        Assertions.assertTrue(response<500 && response>=400);
    }
}
