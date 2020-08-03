package com.merkleinc.kata.tiktaktoe.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.merkleinc.kata.tiktaktoe.model.Players.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

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
        Players[] demoBoard = {X, O, null,null,null,null,null,null,null, };
        boardGame.setGrid(demoBoard);
        assertEquals(demoBoard, boardGame.getGrid());
    }


}
