package gameobjects;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class Player extends GameObject {

    private final Rectangle rectangle;
    private static Player instance = null;
    private int points;
    private int health;

    private Player() {
        super((graphicsContext.getCanvas().getWidth() / 2), (graphicsContext.getCanvas().getHeight() ));
        image = new Image(getClass().getResourceAsStream("../resource/boy.png"));
        y -= 30;
        rectangle = new Rectangle(x, y, 30, 30);
        points = 0;
        health = 3;
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

    public int loseHealth() {
        return --health;
    }

    public int getHealth() {
        return health;
    }

    public int addPoints(int points) {
        this.points += points;
        return points;
    }

    public int getPoints() {
        return points;
    }
}
