package com.merkleinc.kata.tiktaktoe;

import com.merkleinc.kata.tiktaktoe.model.BoardGame;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@SpringBootConfiguration
public class BoardGameTests {

    /**
     * a game has nine fields in a 3x3 grid
     */
    @Test
    public void heightSize(){

        BoardGame boardGame = new BoardGame();

        assertEquals(3,boardGame.getHeight());

    }

    @Test
    public void widthSize(){

        BoardGame boardGame = new BoardGame();

        assertEquals(3, boardGame.getWith());

    }


}
