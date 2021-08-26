package com.example.twopower.game.engine.logical;

import com.example.twopower.game.state.GameState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WinProcessorTest {
    //region init arrays
    private final int[][] emptyArray = {{0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}};
    private final int[][] winArray = {{1024, 1024, 1024, 1024},
            {1024, 1024, 1024, 2048},
            {1024, 1024, 1024, 8096},
            {1024, 1024, 1024, 1024}};
    //endregion
    private GameState gameStateWin;
    private GameState gameStateNothing;

    @BeforeEach
    void setUp() {
        gameStateWin = new GameState(winArray);
        gameStateNothing = new GameState(emptyArray);
    }

    @Test
    void processWin() {
        Assertions.assertTrue(WinProcessor.process(gameStateWin));
    }

    @Test
    void processNothing() {
        Assertions.assertFalse(WinProcessor.process(gameStateNothing));
    }
}