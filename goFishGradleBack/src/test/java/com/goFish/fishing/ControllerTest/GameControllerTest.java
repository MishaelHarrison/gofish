package com.goFish.fishing.ControllerTest;

import com.goFish.fishing.Controller.GameController;
import com.goFish.fishing.Model.*;
import com.goFish.fishing.Repo.GameRepo;
import com.goFish.fishing.Repo.UserRepo;
import com.goFish.fishing.Service.GameService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameControllerTest {
    private GameRepo gameRepo;
    private GameController subject;
    private UserRepo userRepo;

    @BeforeAll
    public void setup(){
        gameRepo = mock(GameRepo.class);
        userRepo = mock(UserRepo.class);
        subject = new GameController((new GameService(gameRepo,userRepo)));


    }
    //User not found
    @Test
    public void userDoesNotExists()
    {
        when(userRepo.findByUsername("Bobby")).thenReturn(Optional.empty());
        int response = subject.Ping(new Ping("Bobby",0)).getStatusCodeValue();
        Assertions.assertTrue(response<500 && response>=400);
    }
    //User Has no game that they are assigned to
    @Test
    public void userNotAssigned()
    {
        when(userRepo.findByUsername("Bobby")).thenReturn(Optional.of(new User("Bobby",null)));
        int response = subject.Ping(new Ping("Bobby",0)).getStatusCodeValue();
        Assertions.assertTrue(response<500 && response>=400);
    }
    //Tests to see if game state in a ping is equal to gamestate in
    // the back end and does not respond with A new game object
    @Test
    public void noUpdate()
    {
        when(userRepo.findByUsername("Bobby")).thenReturn(Optional.of(new User("Bobby",1L)));
        when(gameRepo.findById(1L)).thenReturn(Optional.of(new Game(1,"Yee")));
        ResponseEntity<GameDTO> response = subject.Ping(new Ping("Bobby",1L));
        int responseCode = response.getStatusCodeValue();
        Assertions.assertNull(response.getBody());
        Assertions.assertTrue(responseCode>=200&&responseCode<300);
    }
    @Test
    public void updated(){

        when(userRepo.findByUsername("Bobby")).thenReturn(Optional.of(new User("Bobby",1L)));
        when(gameRepo.findById(1L)).thenReturn(Optional.of(new Game(2,"Yee")));
        ResponseEntity<GameDTO> response = subject.Ping(new Ping("Bobby",1L));
        int responseCode = response.getStatusCodeValue();
        Assertions.assertNotNull(response.getBody());
        Assertions.assertTrue(responseCode>=200&&responseCode<300);
    }
    @Test
    public void valueNotValid()
    {
        int response = subject.play(new Play("Vietnam War","Jimmerson","1")).getStatusCodeValue();
        Assertions.assertTrue(response>=400&&response<500);


    }
    @Test
    public void playerNotFound()
    {
        when(userRepo.findByUsername("Bobby")).thenReturn(Optional.empty());
        int response = subject.play(new Play("Bobby","some kind of string","2")).getStatusCodeValue();
        Assertions.assertTrue(response>=400&&response<500);
    }

    @Test
    public void gameDoesNotExist()
    {
        when(userRepo.findByUsername("Bobby")).thenReturn(Optional.of(new User("Bobby",1L)));
        when(gameRepo.findById(1L)).thenReturn(Optional.empty());
        int response = subject.join("Bobby",1L).getStatusCodeValue();
        Assertions.assertTrue(response>=400&&response<500);
    }
    @Test
    public void joinUserDoesNotExist()
    {
        when(userRepo.findByUsername("Bobby")).thenReturn(Optional.empty());
        int response = subject.join("Bobby",1).getStatusCodeValue();
        Assertions.assertTrue(response>=400&&response<500);

    }
    @Test
    public void createUserDoesNotExist()
    {
        when(userRepo.findByUsername("Bobby")).thenReturn(Optional.empty());
        int response = subject.create("Bobby").getStatusCodeValue();
        Assertions.assertTrue(response>=400&&response<500);
    }
    @Test
    public void playOnSelf()
    {
        int response = subject.play(new Play("Bobby","Bobby","3")).getStatusCodeValue();
        Assertions.assertTrue(response>=400&&response<500);
    }




}
