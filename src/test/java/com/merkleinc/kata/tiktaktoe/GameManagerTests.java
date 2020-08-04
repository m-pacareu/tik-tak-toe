package com.merkleinc.kata.tiktaktoe;

import com.merkleinc.kata.tiktaktoe.exceptions.FullBoardGameException;
import com.merkleinc.kata.tiktaktoe.model.BoardGame;
import com.merkleinc.kata.tiktaktoe.model.Players;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static com.merkleinc.kata.tiktaktoe.model.Players.O;
import static com.merkleinc.kata.tiktaktoe.model.Players.X;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class GameManagerTests {

    @Mock
    BoardGame boardGame;
    @Mock
    PlayersManager playersManager;

    @InjectMocks
    GameManager gameManager;

    /**
     * a game is over when all fields in a row are taken by a player
     */
    @Test
    public void existsWinningRow_winningFirstRow(){
        Players[] expectedGrid = {X, X, X, null, null, null, null, null, null};
        when(boardGame.getGrid()).thenReturn(expectedGrid);
        assertTrue(gameManager.existsWinningRow());
    }
    @Test
    public void existsWinningRow_winningSecondtRow(){
        Players[] expectedGrid = {X, X, null, O, O, O, null, null, null};
        when(boardGame.getGrid()).thenReturn(expectedGrid);
        assertTrue(gameManager.existsWinningRow());
    }
    @Test
    public void existsWinningRow_winningThirdRow(){
        Players[] expectedGrid = {X, X, null, X, O, O, X, X, X};
        when(boardGame.getGrid()).thenReturn(expectedGrid);
        assertTrue(gameManager.existsWinningRow());
    }
    @Test
    public void existsWinningRow_nullRows(){
        Players[] expectedGrid = {null, null, null, null, null, null,null, null, null};
        when(boardGame.getGrid()).thenReturn(expectedGrid);
        assertFalse(gameManager.existsWinningRow());
    }

    /**
     * a game is over when all fields in a column are taken by a player
     */
    @Test
    public void existsWinningCol_winningFirstCol(){
        Players[] expectedGrid = {X, null, null, X, null, null, X, null, X};
        when(boardGame.getGrid()).thenReturn(expectedGrid);
        assertTrue(gameManager.existsWiningCol());
    }
    @Test
    public void existsWinningCol_winningSecondCol(){
        Players[] expectedGrid = {X, O, null, X, O, null, X, O, O};
        when(boardGame.getGrid()).thenReturn(expectedGrid);
        assertTrue(gameManager.existsWiningCol());
    }
    @Test
    public void existsWinningCol_winningThirdCol(){
        Players[] expectedGrid = {X, X, O, X, O, O, O, null, O};
        when(boardGame.getGrid()).thenReturn(expectedGrid);
        assertTrue(gameManager.existsWiningCol());
    }
    @Test
    public void existsWinningCol_nullCols(){
        Players[] expectedGrid = {null, null, null, null, null, null,null, null, null};
        when(boardGame.getGrid()).thenReturn(expectedGrid);
        assertFalse(gameManager.existsWiningCol());
    }


    /**
     * a game is over when all fields in a diagonal are taken by a player
     */
    @Test
    public void existsWinningDiagonal_winningDescDiag(){
        Players[] expectedGrid = {X, O, null, O, X, null, null, O, X};
        when(boardGame.getGrid()).thenReturn(expectedGrid);
        assertTrue(gameManager.existsWiningDiagonal());
    }
    @Test
    public void existsWinningDiagonal_winningAscDiag(){
        Players[] expectedGrid = {null, X, X, null, X, null, X, O, O};
        when(boardGame.getGrid()).thenReturn(expectedGrid);
        assertTrue(gameManager.existsWiningDiagonal());
    }
    @Test
    public void existsWinningDiagonal_nullDiags(){
        Players[] expectedGrid = {null, null, null, null, null, null,null, null, null};
        when(boardGame.getGrid()).thenReturn(expectedGrid);
        assertFalse(gameManager.existsWiningDiagonal());
    }

        /**
         * a game is over when all fields are taken
         */

    @Test
    public void isGridFull_emptyGrid(){
        Players[] expectedGrid = {null, null, null, null, null, null, null, null, null};
        when(boardGame.getGrid()).thenReturn(expectedGrid);
        assertFalse(gameManager.isGridFull());
    }

    @Test
    public void isGridFull_emptySlots(){
        Players[] expectedGrid = {null, X, X, null, X, null, X, O, O};
        when(boardGame.getGrid()).thenReturn(expectedGrid);
        assertFalse(gameManager.isGridFull());
    }

    @Test
    public void isGridFull_fullGrid(){
        Players[] expectedGrid = {O, X, X, O, X, O, X, O, O};
        when(boardGame.getGrid()).thenReturn(expectedGrid);
        assertTrue(gameManager.isGridFull());
    }

    /**
     * players take turns taking fields until the game is over
     */

    @Test
    public void nextMove_firstTurn(){
        Players[] expectedGrid = {null, null, null, null, X, null, null, null, null};
        Players[] initialGrid = {null, null, null, null, null, null, null, null, null};
        when(boardGame.getGrid()).thenReturn(initialGrid);
        when(playersManager.nextPlayer()).thenReturn(X);
        assertArrayEquals(expectedGrid, gameManager.nextMove(4));
    }
    @Test
    public void nextMove_secondTurn(){
        Players[] expectedGrid = {O, null, null, null, X, null, null, null, null};
        Players[] initialGrid = {null, null, null, null, X, null, null, null, null};
        when(boardGame.getGrid()).thenReturn(initialGrid);
        when(playersManager.nextPlayer()).thenReturn(O);
        assertArrayEquals(expectedGrid, gameManager.nextMove(0));
    }

    @Test
    public void nextMove_extraTurnNotAllowed(){
        Players[] initialGrid = {O, X, O, X, X, O, O, X, O};
        when(boardGame.getGrid()).thenReturn(initialGrid);
        when(playersManager.nextPlayer()).thenReturn(O);
        assertThrows(FullBoardGameException.class, () -> gameManager.nextMove(0));
    }
}
