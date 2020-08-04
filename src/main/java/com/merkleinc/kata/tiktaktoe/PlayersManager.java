package com.merkleinc.kata.tiktaktoe;

import com.merkleinc.kata.tiktaktoe.model.Players;
import org.springframework.stereotype.Component;

import static com.merkleinc.kata.tiktaktoe.model.Players.O;
import static com.merkleinc.kata.tiktaktoe.model.Players.X;

@Component
public class PlayersManager {

    private Players lastPlayer = O;

    public Players getLastPlayer() {
        return this.lastPlayer;
    }

    public Players nextPlayer() {
        switch (lastPlayer){
            case X:
                lastPlayer = O;
                break;
            case O:
                lastPlayer = X;
                break;
        }
        return lastPlayer;
    }

    public void setLastPlayer(Players lastPlayer) {
        this.lastPlayer = lastPlayer;
    }
}
