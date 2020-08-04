package com.merkleinc.kata.tiktaktoe;

import com.merkleinc.kata.tiktaktoe.model.Players;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class PlayersManagerTest {

     /**
     * there are two players in the game (X and O)
     */
    @Test
    public void validatePlayer_nullPlayer(){
        PlayersManager pm = new PlayersManager();
        assertThrows(IllegalArgumentException.class, () -> pm.validatePlayer(null));
    }

    @Test
    public void validatePlayer_xPlayer(){
        PlayersManager pm = new PlayersManager();
        assertEquals(Players.X, pm.validatePlayer("x"));
    }

    @Test
    public void validatePlayer_XPlayer(){
        PlayersManager pm = new PlayersManager();
        assertEquals(Players.X, pm.validatePlayer("X"));
    }

    @Test
    public void validatePlayer_oPlayer(){
        PlayersManager pm = new PlayersManager();
        assertEquals(Players.O, pm.validatePlayer("o"));
    }

    @Test
    public void validatePlayer_OPlayer(){
        PlayersManager pm = new PlayersManager();
        assertEquals(Players.O, pm.validatePlayer("O"));
    }

    @Test
    public void validatePlayer_intPlayer(){
        PlayersManager pm = new PlayersManager();
        assertThrows(IllegalArgumentException.class, () -> pm.validatePlayer("9"));
    }

    @Test
    public void validatePlayer_emptyStringPlayer(){
        PlayersManager pm = new PlayersManager();
        assertThrows(IllegalArgumentException.class, () -> pm.validatePlayer(""));
    }

    @Test
    public void validatePlayer_APlayer(){
        PlayersManager pm = new PlayersManager();
        assertThrows(IllegalArgumentException.class, () -> pm.validatePlayer("A"));
    }

    @Test
    public void validatePlayer_escapedStringPlayer(){
        PlayersManager pm = new PlayersManager();
        assertThrows(IllegalArgumentException.class, () -> pm.validatePlayer("\\u0153"));
    }
}
