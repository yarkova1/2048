package com.example.twopower.game.engine.logical;

import com.example.twopower.game.engine.Direction;
import com.example.twopower.game.state.GameState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MoveProcessorTest {
    //region init arrays
    private final int[][] leftBoundArray = {{2, 2, 2, 2},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}};
    private final int[][] rightBoundArray = {{0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {2, 2, 2, 2}};
    private final int[][] upBoundArray = {{2, 0, 0, 0},
            {2, 0, 0, 0},
            {2, 0, 0, 0},
            {2, 0, 0, 0}};
    private final int[][] downBoundArray = {{0, 0, 0, 2},
            {0, 0, 0, 2},
            {0, 0, 0, 2},
            {0, 0, 0, 2}};
    private final int[][] leftUpAngleArray = {{8, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}};
    private final int[][] leftDownAngleArray = {{0, 0, 0, 8},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}};
    private final int[][] rightUpAngleArray = {{0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {8, 0, 0, 0}};
    private final int[][] rightDownAngleArray = {{0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 8}};
    private final int[][] emptyArray = {{0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}};
    private final int[][] full2Array = {{2, 2, 2, 2},
            {2, 2, 2, 2},
            {2, 2, 2, 2},
            {2, 2, 2, 2}};
    private final int[][] up8BoundArray = {{8, 0, 0, 0},
            {8, 0, 0, 0},
            {8, 0, 0, 0},
            {8, 0, 0, 0}};
    private final int[][] left8BoundArray = {{8, 8, 8, 8},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}};
    private final int[][] right8BoundArray = {{0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {8, 8, 8, 8}};
    private final int[][] down8BoundArray = {{0, 0, 0, 8},
            {0, 0, 0, 8},
            {0, 0, 0, 8},
            {0, 0, 0, 8}};
    private final int[][] loseArray = {{2, 4, 8, 16},
            {4, 8, 16, 32},
            {8, 16, 32, 64},
            {16, 32, 64, 128}};
    //endregion

    private GameState gameStateLeftBound;
    private GameState gameStateRightBound;
    private GameState gameStateUpBound;
    private GameState gameStateDownBound;
    private GameState gameStateEmpty;
    private GameState gameStateFull2;
    private GameState gameStateFull2_1;
    private GameState gameStateFull2_2;
    private GameState gameStateFull2_3;
    private GameState gameStateFull2_4;
    private GameState gameStateLose;

    @BeforeEach
    void setUp() {
        gameStateLeftBound = new GameState(leftBoundArray);
        gameStateRightBound = new GameState(rightBoundArray);
        gameStateUpBound = new GameState(upBoundArray);
        gameStateDownBound = new GameState(downBoundArray);
        gameStateEmpty = new GameState(emptyArray);
        gameStateFull2 = new GameState(full2Array);
        gameStateFull2_1 = new GameState(full2Array);
        gameStateFull2_2 = new GameState(full2Array);
        gameStateFull2_3 = new GameState(full2Array);
        gameStateFull2_4 = new GameState(full2Array);
        gameStateLose = new GameState(loseArray);
    }

    //region test left bound
    @Test
    void processLeftBoundGoLeft() {
        MoveProcessor.process(gameStateLeftBound, Direction.LEFT);
        Assertions.assertEquals(gameStateLeftBound, new GameState(leftBoundArray));
    }

    @Test
    void processLeftBoundGoRight() {
        MoveProcessor.process(gameStateLeftBound, Direction.RIGHT);
        Assertions.assertEquals(gameStateLeftBound, new GameState(rightBoundArray));
    }

    @Test
    void processLeftBoundGoUp() {
        MoveProcessor.process(gameStateLeftBound, Direction.UP);
        Assertions.assertEquals(gameStateLeftBound, new GameState(leftUpAngleArray));
    }

    @Test
    void processLeftBoundGoDown() {
        MoveProcessor.process(gameStateLeftBound, Direction.DOWN);
        Assertions.assertEquals(gameStateLeftBound, new GameState(leftDownAngleArray));
    }
    //endregion

    //region test right bound
    @Test
    void processRightBoundGoLeft() {
        MoveProcessor.process(gameStateRightBound, Direction.LEFT);
        Assertions.assertEquals(gameStateRightBound, new GameState(leftBoundArray));
    }

    @Test
    void processRightBoundGoRight() {
        MoveProcessor.process(gameStateRightBound, Direction.RIGHT);
        Assertions.assertEquals(gameStateRightBound, new GameState(rightBoundArray));
    }

    @Test
    void processRightBoundGoUp() {
        MoveProcessor.process(gameStateRightBound, Direction.UP);
        Assertions.assertEquals(gameStateRightBound, new GameState(rightUpAngleArray));
    }

    @Test
    void processRightBoundGoDown() {
        MoveProcessor.process(gameStateRightBound, Direction.DOWN);
        Assertions.assertEquals(gameStateRightBound, new GameState(rightDownAngleArray));
    }
    //endregion

    //region test up bound
    @Test
    void processUpBoundGoLeft() {
        MoveProcessor.process(gameStateUpBound, Direction.LEFT);
        Assertions.assertEquals(gameStateUpBound, new GameState(leftUpAngleArray));
    }

    @Test
    void processUpBoundGoRight() {
        MoveProcessor.process(gameStateUpBound, Direction.RIGHT);
        Assertions.assertEquals(gameStateUpBound, new GameState(rightUpAngleArray));
    }

    @Test
    void processUpBoundGoUp() {
        MoveProcessor.process(gameStateUpBound, Direction.UP);
        Assertions.assertEquals(gameStateUpBound, new GameState(upBoundArray));
    }

    @Test
    void processUpBoundGoDown() {
        MoveProcessor.process(gameStateUpBound, Direction.DOWN);
        Assertions.assertEquals(gameStateUpBound, new GameState(downBoundArray));
    }
    //endregion

    //region test down bound
    @Test
    void processDownBoundGoLeft() {
        MoveProcessor.process(gameStateDownBound, Direction.LEFT);
        Assertions.assertEquals(gameStateDownBound, new GameState(leftDownAngleArray));
    }

    @Test
    void processDownBoundGoRight() {
        MoveProcessor.process(gameStateDownBound, Direction.RIGHT);
        Assertions.assertEquals(gameStateDownBound, new GameState(rightDownAngleArray));
    }

    @Test
    void processDownBoundGoUp() {
        MoveProcessor.process(gameStateDownBound, Direction.UP);
        Assertions.assertEquals(gameStateDownBound, new GameState(upBoundArray));
    }

    @Test
    void processDownBoundGoDown() {
        MoveProcessor.process(gameStateDownBound, Direction.DOWN);
        Assertions.assertEquals(gameStateDownBound, new GameState(downBoundArray));
    }
    //endregion

    //region test full 2
    @Test
    void processFull2GoLeft() {
        MoveProcessor.process(gameStateFull2, Direction.LEFT);
        Assertions.assertEquals(gameStateFull2, new GameState(left8BoundArray));
    }

    @Test
    void processFull2GoRight() {
        MoveProcessor.process(gameStateFull2, Direction.RIGHT);
        Assertions.assertEquals(gameStateFull2, new GameState(right8BoundArray));
    }

    @Test
    void processFull2GoUp() {
        MoveProcessor.process(gameStateFull2, Direction.UP);
        Assertions.assertEquals(gameStateFull2, new GameState(up8BoundArray));
    }

    @Test
    void processFull2GoDown() {
        MoveProcessor.process(gameStateFull2, Direction.DOWN);
        Assertions.assertEquals(gameStateFull2, new GameState(down8BoundArray));
    }
    //endregion

    //region test win/lose condition
    @Test
    void processNothingHappensEmptyField(){
        Assertions.assertFalse(MoveProcessor.process(gameStateEmpty, Direction.UP));
        Assertions.assertEquals(gameStateEmpty, new GameState(emptyArray));
        Assertions.assertFalse(MoveProcessor.process(gameStateEmpty, Direction.DOWN));
        Assertions.assertEquals(gameStateEmpty, new GameState(emptyArray));
        Assertions.assertFalse(MoveProcessor.process(gameStateEmpty, Direction.LEFT));
        Assertions.assertEquals(gameStateEmpty, new GameState(emptyArray));
        Assertions.assertFalse(MoveProcessor.process(gameStateEmpty, Direction.RIGHT));
        Assertions.assertEquals(gameStateEmpty, new GameState(emptyArray));
    }

    @Test
    void processNothingHappensBlockedField(){
        Assertions.assertFalse(MoveProcessor.process(gameStateLose, Direction.UP));
        Assertions.assertEquals(gameStateLose, new GameState(loseArray));
        Assertions.assertFalse(MoveProcessor.process(gameStateLose, Direction.DOWN));
        Assertions.assertEquals(gameStateLose, new GameState(loseArray));
        Assertions.assertFalse(MoveProcessor.process(gameStateLose, Direction.LEFT));
        Assertions.assertEquals(gameStateLose, new GameState(loseArray));
        Assertions.assertFalse(MoveProcessor.process(gameStateLose, Direction.RIGHT));
        Assertions.assertEquals(gameStateLose, new GameState(loseArray));
    }

    @Test
    void processSomethingHappensFull2Field(){
        Assertions.assertTrue(MoveProcessor.process(gameStateFull2_1, Direction.UP));
        Assertions.assertEquals(gameStateFull2_1, new GameState(up8BoundArray));
        Assertions.assertTrue(MoveProcessor.process(gameStateFull2_2, Direction.DOWN));
        Assertions.assertEquals(gameStateFull2_2, new GameState(down8BoundArray));
        Assertions.assertTrue(MoveProcessor.process(gameStateFull2_3, Direction.LEFT));
        Assertions.assertEquals(gameStateFull2_3, new GameState(left8BoundArray));
        Assertions.assertTrue(MoveProcessor.process(gameStateFull2_4, Direction.RIGHT));
        Assertions.assertEquals(gameStateFull2_4, new GameState(right8BoundArray));
    }
    //endregion
}