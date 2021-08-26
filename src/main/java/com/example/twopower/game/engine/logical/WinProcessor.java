package com.example.twopower.game.engine.logical;

import com.example.twopower.game.state.GameState;

import java.util.Collection;

public class WinProcessor {

    public static boolean process(GameState gameState){
        return gameState.getField().stream().flatMap(Collection::stream).anyMatch(integer -> integer >= 2048);
    }
}
