package gameobjects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class Player extends GameObject {

    private final Rectangle rectangle;
    private static Player instance = null;

    private Player() {
        super((graphicsContext.getCanvas().getWidth() / 2), graphicsContext.getCanvas().getHeight());
        image = new Image(getClass().getResourceAsStream("../resource/lungs.png"));
        y -= 30;
        rectangle = new Rectangle(x, y, 30, 30);
    }

    public static Player getInstance() {
        if (instance == null) {
            instance = new Player();
        }
        return instance;
    }

    public boolean intersects(FallingFood food) {
        return rectangle.intersects(food.getRectangle().getBoundsInParent());

    }

    public void move(double sceneX) {
        x = sceneX;
        rectangle.setX(x);
    }
}
