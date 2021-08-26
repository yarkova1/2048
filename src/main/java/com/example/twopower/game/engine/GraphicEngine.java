package com.example.twopower.game.engine;

import com.example.twopower.game.state.GameState;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class GraphicEngine {
    private final Canvas canvas;
    private GameState gameState;

    public GraphicEngine(Canvas canvas) {
        this.canvas = canvas;
    }

    public GraphicEngine(){
        canvas = null;
    }

    public void action(GameState gameState) {
        if (canvas == null || gameState == null) return;
        this.gameState = gameState;
        double cellWidth = ((canvas.getWidth()) / gameState.getMaxX()) - 5;
        double cellHeight = ((canvas.getHeight()) / gameState.getMaxY()) - 10;
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (int i = 0; i < gameState.getMaxX(); i++)
            for (int j = 0; j < gameState.getMaxY(); j++) {
                if (gameState.getField().get(i).get(j) != 0) {
                    canvas.getGraphicsContext2D().setFill(colors[(int)(Math.log(gameState.getField().get(i).get(j))/Math.log(2))]);
                    canvas.getGraphicsContext2D().fillRect(cellWidth * i, cellHeight * j, cellWidth, cellHeight);
                    canvas.getGraphicsContext2D().setFill(Color.BLACK);
                    canvas.getGraphicsContext2D().fillText(gameState.getField().get(i).get(j).toString(),
                            cellWidth * i + cellWidth / 2,
                            cellHeight * j + cellHeight / 2);
                }
                canvas.getGraphicsContext2D().setStroke(Color.BLACK);
                canvas.getGraphicsContext2D().strokeRect(cellWidth * i, cellHeight * j, cellWidth, cellHeight);
            }
    }

    public void resize() {
        action(this.gameState);
    }

    private final Color[] colors = {
            Color.LIGHTGREEN,
            Color.LIME,
            Color.LIMEGREEN,
            Color.YELLOWGREEN,
            Color.KHAKI,
            Color.DARKKHAKI,
            Color.GOLD,
            Color.ORANGE,
            Color.ORANGERED,
            Color.MEDIUMVIOLETRED,
            Color.RED
    };
}
