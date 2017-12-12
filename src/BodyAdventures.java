import gameobjects.FallingFood;
import gameobjects.Fats;
import gameobjects.GameObject;
import gameobjects.Player;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BodyAdventures extends Application {

    static final int WINDOW_WIDTH = 1024;
    static final int WINDOW_HEIGHT = 768;
    Stage stage;
    Scene scene;
    Pane root;
    Canvas canvas;
    GraphicsContext graphicsContext;
    List<FallingFood> food;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setTitle("Body Adventtures");
        stage.setResizable(false);
        root = new Pane();
        scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

        Pane stackPane = new StackPane();
        Button playButton = new Button("Play");
        stackPane.getChildren().add(playButton);
        Scene newGameScene = new Scene(stackPane, WINDOW_WIDTH, WINDOW_HEIGHT);
        stage.setScene(newGameScene);
        stage.show();

        playButton.setOnAction(actionEvent -> startGame());
    }

    private void startGame() {
        stage.setScene(scene);
        canvas = new Canvas(1024, 768);
        graphicsContext = canvas.getGraphicsContext2D();
        GameObject.setGraphicsContext(graphicsContext);
        root.getChildren().add(canvas);
        redrawBackground();

        food = new ArrayList<>();

        food.add(new Fats(new Image(getClass().getResourceAsStream("resource/brain.png"))));

        Player player = Player.getInstance();

        canvas.setOnMouseMoved(mouseEvent -> {
            player.move(mouseEvent.getSceneX());
        });

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                redrawBackground();
                Iterator<FallingFood> it = food.iterator();
                while (it.hasNext()) {
                    FallingFood f = it.next();
                    f.fall();
                    if (player.intersects(f)) {
                        System.err.println("Got it");
                        it.remove();
                    }
                }

                food.forEach(GameObject::update);
                player.update();
            }
        };

        animationTimer.start();

    }

    private void redrawBackground() {
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

}

