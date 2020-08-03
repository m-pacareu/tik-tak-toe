package com.merkleinc.kata.tiktaktoe.model;

import org.springframework.stereotype.Component;

@Component
public class BoardGame {

    public static final Integer height = 3;
    public static final Integer width = 3;

    private Players[] grid;

    public BoardGame() {
        this.grid = new Players[height * width];
    }

    public Integer getHeight() {
        return this.height;
    }

    public Integer getWidth() {
        return this.width;
    }

    public Players[] getGrid() {
        return grid;
    }

    public void setGrid(Players[] grid) {
        this.grid = grid;
    }

    public Integer getTotalFields() {
        return this.grid.length;
    }

    public Players getField(Integer i) {
        return this.grid[i];
    }
}


