package com.example.twopower;

import com.example.twopower.game.engine.Direction;
import com.example.twopower.game.engine.Engine;
import com.example.twopower.game.engine.GameResult;
import com.example.twopower.game.engine.GraphicEngine;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    @FXML
    private VBox root;

    @FXML
    private Canvas canvas;

    private Engine engine;
    private Stage stage;

    public GameController(Stage stage) {
        this.stage = stage;
    }

    @FXML
    protected void onKeyReleased(KeyEvent event) {
        GameResult result = GameResult.NOTHING;
        switch (event.getCode()) {
            case LEFT:
                result = engine.action(Direction.LEFT);
                break;
            case RIGHT:
                result = engine.action(Direction.RIGHT);
                break;
            case UP:
                result = engine.action(Direction.UP);
                break;
            case DOWN:
                result = engine.action(Direction.DOWN);
                break;
            default:
                break;
        }
        switch (result) {
            case WIN:
                Alert winAlert = new Alert(Alert.AlertType.CONFIRMATION);
                winAlert.setTitle("Сообщение");
                winAlert.setHeaderText("Победа!");
                winAlert.setContentText("Кажется, вы победили! Начнем новую игру?");
                winAlert.showAndWait().filter(buttonType -> buttonType.equals(ButtonType.OK))
                        .ifPresent(buttonType -> {
                            this.engine = new Engine(4, 4, new GraphicEngine(canvas));
                            this.canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                        });
                break;
            case LOSE:
                Alert loseAlert = new Alert(Alert.AlertType.CONFIRMATION);
                loseAlert.setTitle("Сообщение");
                loseAlert.setHeaderText("Проигрыш:C");
                loseAlert.setContentText("Кажется, вы проиграли... Начнем новую игру?");
                loseAlert.showAndWait().filter(buttonType -> buttonType.equals(ButtonType.OK))
                        .ifPresent(buttonType -> {
                            this.engine = new Engine(4, 4, new GraphicEngine(canvas));
                            this.canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                        });
                break;
            case NOTHING:
                break;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        engine = new Engine(4, 4, new GraphicEngine(canvas));
        stage.widthProperty().addListener((observableValue, number, t1) -> {
            canvas.setWidth(stage.getWidth());
            engine.resize();
        });
        stage.heightProperty().addListener((observableValue, number, t1) -> {
            canvas.setHeight(stage.getHeight());
            engine.resize();
        });
    }
}