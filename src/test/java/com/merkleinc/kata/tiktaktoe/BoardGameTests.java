package com.merkleinc.kata.tiktaktoe;

import com.merkleinc.kata.tiktaktoe.model.BoardGame;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@SpringBootConfiguration
public class BoardGameTests {

    /**
     * a game has nine fields in a 3x3 grid
     */
    @Test
    public void correctGridSize(){

        BoardGame boardGame = new BoardGame();

        assertEquals(3, boardGame.getWith());
        assertEquals(3,boardGame.getHeight());

    }
}
