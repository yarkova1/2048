package com.example.twopower.game.engine.logical;

import com.example.twopower.game.state.GameState;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;

public class SpawnProcessor {
    public static boolean process(GameState gameState) {
        int spawnCount = random(1, GameState.MAX_SPAWN_COUNT);
        List<Pair<Integer, Integer>> freeCells = freeCells(gameState);
        boolean somethingHappens = false;
        for (int i = 0; i < spawnCount && i < freeCells.size(); i++) {
            freeCells.stream().skip(random(0, freeCells.size())).findAny().ifPresent(pair ->
                    gameState.getField().get(pair.getKey()).set(pair.getValue(),
                            (int) Math.pow(2, random(1, GameState.MAX_SPAWN_POWER))));
            somethingHappens = true;
        }
        return somethingHappens;
    }

    private static int random(int max, int min) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private static List<Pair<Integer, Integer>> freeCells(GameState gameState) {
        List<Pair<Integer, Integer>> result = new LinkedList<>();
        for (int x = 0; x < gameState.getMaxX(); x++)
            for (int y = 0; y < gameState.getMaxY(); y++)
                if (gameState.getField().get(x).get(y) == 0)
                    result.add(new Pair<>(x, y));

        return result;
    }
}
