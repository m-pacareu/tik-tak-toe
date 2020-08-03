package com.merkleinc.kata.tiktaktoe.model;

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
    public void getHeight_SizeEqualsThree(){

        BoardGame boardGame = new BoardGame();

        assertEquals(3,boardGame.getHeight());

    }

    @Test
    public void getWidth_SizeEqualsThree(){

        BoardGame boardGame = new BoardGame();

        assertEquals(3, boardGame.getWidth());

    }


    /**
     * Grid tests
     */

    @Test
    public void getGrid_NotNull(){
        BoardGame boardGame = new BoardGame();

        assertNotNull(boardGame.getGrid());
    }

    @Test
    public void getTotalFields_equalsNine(){
        BoardGame boardGame = new BoardGame();
        assertEquals(9, boardGame.getTotalFields());
    }

    @Test
    public void setterGetterGrid_indirectTest(){
        BoardGame boardGame = new BoardGame();
        String[] demoBoard = {"X", "O", null, "A","","0","9","x","o"};
        boardGame.setGrid(demoBoard);
        assertEquals(demoBoard, boardGame.getGrid());
    }
}
