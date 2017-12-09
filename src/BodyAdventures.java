import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import gameobjects.Human;

public class BodyAdventures extends Application {

    Scene scene;
    Pane root;
    Canvas canvas;
    GraphicsContext graphicsContext;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Body Adventtures");
        stage.setResizable(false);
        root = new Pane();
        scene = new Scene(root, 1024, 768);
        stage.setScene(scene);
        stage.show();


        canvas = new Canvas(1024, 768);
        graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        root.getChildren().add(canvas);

        Human human = new Human(graphicsContext);
        human.update();
    }


    public void addOrgans() {

    }
}

