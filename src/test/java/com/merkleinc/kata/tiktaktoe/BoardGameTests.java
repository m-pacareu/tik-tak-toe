package com.merkleinc.kata.tiktaktoe;

import com.merkleinc.kata.tiktaktoe.model.BoardGame;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
/**
 * a game has nine fields in a 3x3 grid
 */
public class BoardGameTests {


    /**
     * Size  tests
     */
    @Test
    public void heightSize(){

        BoardGame boardGame = new BoardGame();

        assertEquals(3,boardGame.getHeight());

    }

    @Test
    public void widthSize(){

        BoardGame boardGame = new BoardGame();

        assertEquals(3, boardGame.getWidth());

    }


    /**
     * Grid tests
     */

    @Test
    public void gridNotNull(){
        BoardGame boardGame = new BoardGame();

        assertNotNull(boardGame.getGrid());
    }

    @Test
    public void totalFields_equalsNine(){
        BoardGame boardGame = new BoardGame();
        assertEquals(9, boardGame.getTotalFields());
    }
}
