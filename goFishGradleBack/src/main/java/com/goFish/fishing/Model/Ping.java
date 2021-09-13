package com.goFish.fishing.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;


//Our individual user cannot receive an individual request. Player makes a request to the server every second.
// Checks for changes
@Data
@AllArgsConstructor
public class Ping {
    private String user;
    private long gameState;

}
