package com.goFish.fishing.Model;


import lombok.AllArgsConstructor;
import lombok.Data;

//class for making in-game plays
@AllArgsConstructor
@Data
public class Play {
    private String player;
    private String target;
    private String value;


}
