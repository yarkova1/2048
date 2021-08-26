package com.example.twopower.game.engine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EngineTest {
    //region init arrays
    private final int[][] winArray = {{1024, 1024, 1024, 1024},
            {1024, 1024, 1024, 1024},
            {1024, 1024, 1024, 1024},
            {1024, 1024, 1024, 1024}};
    private final int[][] loseArray = {{2, 4, 8, 16},
            {4, 8, 16, 32},
            {8, 16, 32, 64},
            {16, 32, 64, 128}};
    //endregion

    Engine winEngine;
    Engine loseEngine;

    @BeforeEach
    void setUp() {
        winEngine = new Engine(winArray);
        loseEngine = new Engine(loseArray);
    }

    @Test
    void actionWin() {
        Assertions.assertEquals(GameResult.WIN, winEngine.action(Direction.UP));
    }

    @Test
    void actionDoubleWin(){
        winEngine.action(Direction.UP);
        Assertions.assertEquals(GameResult.NOTHING, winEngine.action(Direction.UP));
    }

    @Test
    void actionLose() {
        Assertions.assertEquals(GameResult.LOSE, loseEngine.action(Direction.UP));
    }
}