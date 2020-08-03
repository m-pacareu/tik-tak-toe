package com.merkleinc.kata.tiktaktoe;

import com.merkleinc.kata.tiktaktoe.model.BoardGame;
import com.merkleinc.kata.tiktaktoe.model.Players;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static com.merkleinc.kata.tiktaktoe.model.Players.O;
import static com.merkleinc.kata.tiktaktoe.model.Players.X;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
public class GameManagerTests {

    @Mock
    BoardGame boardGame;

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



}
