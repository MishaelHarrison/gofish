package com.goFish.fishing.Controller;

import com.goFish.fishing.Model.GameDTO;
import com.goFish.fishing.Model.Ping;
import com.goFish.fishing.Model.Play;
import com.goFish.fishing.Service.Impl.GameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
    private GameServiceImpl gameServiceImpl;

    @Autowired
    public GameController(GameServiceImpl gameServiceImpl) {
        this.gameServiceImpl = gameServiceImpl;
    }

    public ResponseEntity<GameDTO> ping(Ping ping)
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
