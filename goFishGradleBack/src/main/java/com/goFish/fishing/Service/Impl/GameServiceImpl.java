package com.goFish.fishing.Service.Impl;

import com.goFish.fishing.Repo.GameRepo;
import com.goFish.fishing.Repo.UserRepo;
import com.goFish.fishing.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {
    private GameRepo gameRepo;
    private UserRepo userRepo;

    @Autowired
    public GameServiceImpl(GameRepo gameRepo, UserRepo userRepo)
    {
        this.gameRepo = gameRepo;
        this.userRepo = userRepo;
    }

}
