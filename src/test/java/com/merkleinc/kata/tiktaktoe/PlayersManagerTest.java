package com.merkleinc.kata.tiktaktoe;

import com.merkleinc.kata.tiktaktoe.model.Players;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PlayersManagerTest {

    /**
     * there are two players in the game (X and O)
     */
    @Test
    public void nextPlayer_nextX() {
        PlayersManager pm = new PlayersManager();
        pm.setLastPlayer(Players.O);
        assertEquals(Players.X, pm.nextPlayer());
    }

    @Test
    public void nextPlayer_nextO() {
        PlayersManager pm = new PlayersManager();
        pm.setLastPlayer(Players.X);
        assertEquals(Players.O, pm.nextPlayer());
    }

    @Test
    public void nextPlayer_firstMove() {
        PlayersManager pm = new PlayersManager();
        assertEquals(Players.X, pm.nextPlayer());
    }

}
