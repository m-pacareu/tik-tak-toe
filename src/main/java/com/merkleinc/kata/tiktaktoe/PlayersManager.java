package com.merkleinc.kata.tiktaktoe;

import com.merkleinc.kata.tiktaktoe.model.Players;

public class PlayersManager {

    public Players validatePlayer(String player) {
        if (player == null){
            throw new IllegalArgumentException("String player representation should not be null");
        }
        return Players.valueOf(player.toUpperCase());
    }
}
