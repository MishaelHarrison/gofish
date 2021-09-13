package com.goFish.fishing.Service;

import com.goFish.fishing.Repo.GameRepo;
import com.goFish.fishing.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    private GameRepo gameRepo;
    private UserRepo userRepo;

    @Autowired
    public GameService(GameRepo gameRepo,UserRepo userRepo)
    {
        this.gameRepo = gameRepo;
        this.userRepo = userRepo;
    }

}
