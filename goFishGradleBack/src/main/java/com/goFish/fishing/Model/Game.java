package com.goFish.fishing.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private long gameState;
    private String gameSerialized;
    

    public Game(long gameState, String gameSerialized) {
        this.gameState = gameState;
        this.gameSerialized = gameSerialized;
    }
}
