package com.example.twopower.game.engine;

import com.example.twopower.game.engine.logical.MoveProcessor;
import com.example.twopower.game.engine.logical.SpawnProcessor;
import com.example.twopower.game.engine.logical.WinProcessor;
import com.example.twopower.game.state.GameState;

public class Engine {
    private GameState gameState;
    private GraphicEngine graphicEngine;
    private boolean won = false;

    public Engine(int x, int y, GraphicEngine graphicEngine) {
        this.gameState = new GameState(x, y);
        this.graphicEngine = graphicEngine;
    }

    public Engine(int[][] field) {
        this.gameState = new GameState(field);
        this.graphicEngine = new GraphicEngine();
    }

    public GameResult action(Direction direction) {
        GameResult result = GameResult.NOTHING;
        if (!MoveProcessor.process(gameState, direction) & !SpawnProcessor.process(gameState))
            result = GameResult.LOSE;
        if (!won && WinProcessor.process(gameState)) {
            result = GameResult.WIN;
            won = true;
        }

        graphicEngine.action(gameState);
        return result;
    }

    public void resize() {
        graphicEngine.resize();
    }

}
