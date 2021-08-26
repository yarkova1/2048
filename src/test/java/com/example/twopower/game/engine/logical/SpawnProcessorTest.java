package com.example.twopower.game.engine.logical;

import com.example.twopower.game.state.GameState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

class SpawnProcessorTest {
    //region init arrays
    private final int[][] emptyArray = {{0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}};
    private final int[][] fullArray = {{2, 2, 2, 2},
            {2, 2, 2, 2},
            {2, 2, 2, 2},
            {2, 2, 2, 2}};
    private final int[][] loseArray = {{2, 4, 8, 16},
            {4, 8, 16, 32},
            {8, 16, 32, 64},
            {16, 32, 64, 128}};
    //endregion

    private GameState gameStateEmpty;
    private GameState gameStateFull2;
    private GameState gameStateLose;

    @BeforeEach
    void setUp() {
        gameStateEmpty = new GameState(emptyArray);
        gameStateFull2 = new GameState(fullArray);
        gameStateLose = new GameState(loseArray);
    }

    //region test spawn work
    @Test
    void processSpawnAny() {
        SpawnProcessor.process(gameStateEmpty);
        Assertions.assertTrue(gameStateEmpty.getField().stream()
                .flatMap(Collection::stream).anyMatch(integer -> integer > 0));
    }

    @Test
    void processFull() {
        SpawnProcessor.process(gameStateFull2);
        Assertions.assertEquals(gameStateFull2, new GameState(fullArray));
    }
    //endregion

    //region test spawn conditions
    @Test
    void processSpawnCountInBounds() {
        SpawnProcessor.process(gameStateEmpty);
        Assertions.assertTrue(GameState.MAX_SPAWN_COUNT >= gameStateEmpty.getField().stream()
                .flatMap(Collection::stream)
                .filter(integer -> integer > 0)
                .count());
    }

    @Test
    void processSpawnPowerInBounds() {
        while (SpawnProcessor.process(gameStateEmpty)) {
            Assertions.assertTrue(gameStateEmpty.getField().stream()
                    .flatMap(Collection::stream)
                    .noneMatch(integer -> integer > 2 * GameState.MAX_SPAWN_POWER));
        }
    }
    //endregion

    //region test win/lose condition
    @Test
    void processNothingHappens() {
        Assertions.assertFalse(SpawnProcessor.process(gameStateLose));
    }

    @Test
    void processSomethingHappens() {
        Assertions.assertTrue(SpawnProcessor.process(gameStateEmpty));
    }
    //endregion
}