package com.example.twopower.game.state;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class GameState implements Serializable {
    private ArrayList<ArrayList<Integer>> field;
    private final int maxX;
    private final int maxY;
    public static final short MAX_SPAWN_COUNT = 3;
    public static final short MAX_SPAWN_POWER = 3;

    public GameState(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.field = new ArrayList<>();
        for (int x = 0; x < maxX; x++) {
            field.add(new ArrayList<>());
            for (int y = 0; y < maxY; y++)
                field.get(x).add(0);
        }
    }

    public GameState(int[][] array) {
        maxX = array.length;
        maxY = array[0].length;
        field = new ArrayList<>();
        for (int x = 0; x < maxX; x++) {
            field.add(new ArrayList<>());
            for (int y = 0; y < maxY; y++)
                field.get(x).add(array[x][y]);
        }
    }

    public ArrayList<ArrayList<Integer>> getField() {
        return field;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameState gameState = (GameState) o;
        return maxX == gameState.maxX && maxY == gameState.maxY && Objects.equals(field, gameState.field);
    }

    @Override
    public int hashCode() {
        return Objects.hash(field, maxX, maxY);
    }
}
