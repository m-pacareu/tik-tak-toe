package com.merkleinc.kata.tiktaktoe.model;


public class BoardGame {

    public static final Integer height = 3;
    public static final Integer width = 3;

    private String[] grid;

    public BoardGame() {
        this.grid = new String[height*width];
    }

    public Integer getHeight() {
        return this.height;
    }

    public Integer getWidth(){
        return this.width;
    }

    public String[] getGrid() {
        return grid;
    }

    public Integer getTotalFields() {
        return this.grid.length;
    }
}


