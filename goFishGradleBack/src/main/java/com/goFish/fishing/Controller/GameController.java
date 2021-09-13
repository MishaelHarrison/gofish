package com.goFish.fishing.Controller;

import com.goFish.fishing.Model.GameDTO;
import com.goFish.fishing.Model.Ping;
import com.goFish.fishing.Model.Play;
import com.goFish.fishing.Repo.GameRepo;
import com.goFish.fishing.Service.GameService;
import com.goFish.fishing.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
    private GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public ResponseEntity<GameDTO> Ping(Ping ping)
    {
        return null;
    }
    public ResponseEntity<GameDTO> play(Play play)
    {
        return null;
    }
    public ResponseEntity join(String userName, long gameId)
    {
        return null;
    }
    public ResponseEntity create(String userName)
    {
        return null;
    }


}
