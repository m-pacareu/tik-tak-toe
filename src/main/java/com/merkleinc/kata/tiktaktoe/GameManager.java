package com.merkleinc.kata.tiktaktoe;

import com.merkleinc.kata.tiktaktoe.exceptions.FullBoardGameException;
import com.merkleinc.kata.tiktaktoe.exceptions.NotEmptyCellException;
import com.merkleinc.kata.tiktaktoe.model.BoardGame;
import com.merkleinc.kata.tiktaktoe.model.Players;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class GameManager {

    @Autowired
    private BoardGame boardGame;

    @Autowired
    PlayersManager playersManager;

    public boolean existsWinningRow() {
        boolean result = false;
        Players[] grid = boardGame.getGrid();
        //1st row
        if (grid[0] != null && grid[0] == grid[1] && grid[1] == grid[2] ||
                //2nd row
                grid[3] != null && grid[3] == grid[4] && grid[4] == grid[5] ||
                //3rd row
                grid[6] != null && grid[6] == grid[7] && grid[7] == grid[8]
        ) {
            result = true;
        }

        return result;
    }

    public boolean existsWiningCol() {
        boolean result = false;

        Players[] grid = boardGame.getGrid();
        //1st col
        if (grid[0] != null && grid[0] == grid[3] && grid[3] == grid[6] ||
                //2nd col
                grid[1] != null && grid[1] == grid[4] && grid[4] == grid[7] ||
                //3rd col
                grid[2] != null && grid[2] == grid[5] && grid[5] == grid[8]
        ) {
            result = true;
        }

        return result;
    }

    public boolean existsWiningDiagonal() {
        boolean result = false;
        Players[] grid = boardGame.getGrid();
        //Descendant diagonal
        if (grid[0] != null && grid[0] == grid[4] && grid[4] == grid[8] ||
        //Ascendant diagonal
                grid[6] != null && grid[6] == grid[4] && grid[4] == grid[2]
        ){
            result = true;
        }
        return result;
    }

    public boolean isGridFull() {
        boolean result = false;
        Players[] grid = boardGame.getGrid();
        List<Players> nullValues = Arrays.asList(grid).stream().filter(Objects::isNull).collect(Collectors.toList());
        return nullValues.isEmpty();
    }

    public Players[] nextMove(int i) {
        Players[] grid = boardGame.getGrid();

        if(isGridFull()){
            throw new FullBoardGameException("Full boardgame. Game should have ended before last movement.");
        }
        if (grid[i] != null){
            throw new NotEmptyCellException("Cannot take field that has been alredy taken.");
        }
        grid[i] = playersManager.nextPlayer();

        boardGame.setGrid(grid);

        return grid;
    }
}
