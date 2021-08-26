package com.example.twopower.game.engine.logical;

import com.example.twopower.game.engine.Direction;
import com.example.twopower.game.state.GameState;

import java.util.Objects;

public class MoveProcessor {

    public static boolean process(GameState gameState, Direction direction) {
        boolean needNext;
        boolean somethingHappens = false;
        do {
            needNext = false;
            switch (direction) {
                case LEFT:
                    for (int x = 1; x < gameState.getMaxX(); x++) {
                        for (int y = 0; y < gameState.getMaxY(); y++) {
                            if (gameState.getField().get(x).get(y) == 0) continue;
                            if (gameState.getField().get(x - 1).get(y) == 0) {
                                needNext = true;
                                gameState.getField().get(x - 1).set(y, gameState.getField().get(x).get(y));
                                gameState.getField().get(x).set(y, 0);
                            } else if (Objects.equals(gameState.getField().get(x - 1).get(y), gameState.getField().get(x).get(y))) {
                                needNext = true;
                                gameState.getField().get(x - 1).set(y, gameState.getField().get(x).get(y) * 2);
                                gameState.getField().get(x).set(y, 0);
                            }
                        }
                    }
                    break;
                case RIGHT:
                    for (int x = gameState.getMaxX() - 2; x >= 0; x--)
                        for (int y = 0; y < gameState.getMaxY(); y++) {
                            if (gameState.getField().get(x).get(y) == 0) continue;
                            if (gameState.getField().get(x + 1).get(y) == 0) {
                                needNext = true;
                                gameState.getField().get(x + 1).set(y, gameState.getField().get(x).get(y));
                                gameState.getField().get(x).set(y, 0);
                            } else if (Objects.equals(gameState.getField().get(x + 1).get(y), gameState.getField().get(x).get(y))) {
                                needNext = true;
                                gameState.getField().get(x + 1).set(y, gameState.getField().get(x).get(y) * 2);
                                gameState.getField().get(x).set(y, 0);
                            }
                        }
                    break;
                case UP:
                    for (int y = 1; y < gameState.getMaxY(); y++)
                        for (int x = 0; x < gameState.getMaxX(); x++) {
                            if (gameState.getField().get(x).get(y) == 0) continue;
                            if (gameState.getField().get(x).get(y - 1) == 0) {
                                needNext = true;
                                gameState.getField().get(x).set(y - 1, gameState.getField().get(x).get(y));
                                gameState.getField().get(x).set(y, 0);
                            } else if (Objects.equals(gameState.getField().get(x).get(y), gameState.getField().get(x).get(y - 1))) {
                                needNext = true;
                                gameState.getField().get(x).set(y - 1, gameState.getField().get(x).get(y) * 2);
                                gameState.getField().get(x).set(y, 0);
                            }
                        }
                    break;
                case DOWN:
                    for (int y = gameState.getMaxY() - 2; y >= 0; y--)
                        for (int x = 0; x < gameState.getMaxX(); x++) {
                            if (gameState.getField().get(x).get(y) == 0) continue;
                            if (gameState.getField().get(x).get(y + 1) == 0) {
                                needNext = true;
                                gameState.getField().get(x).set(y + 1, gameState.getField().get(x).get(y));
                                gameState.getField().get(x).set(y, 0);
                            } else if (Objects.equals(gameState.getField().get(x).get(y), gameState.getField().get(x).get(y + 1))) {
                                needNext = true;
                                gameState.getField().get(x).set(y + 1, gameState.getField().get(x).get(y) * 2);
                                gameState.getField().get(x).set(y, 0);
                            }
                        }
                    break;
            }
            somethingHappens |= needNext;
        } while (needNext);
        return somethingHappens;
    }
}
