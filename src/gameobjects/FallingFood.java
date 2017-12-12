package gameobjects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public abstract class FallingFood extends GameObject {

    private static Random random = new Random();
    private Rectangle rectangle;

    protected FallingFood(Image image) {
        super(random.nextInt((int) graphicsContext.getCanvas().getWidth()), 0);
        this.image = image;
        rectangle = new Rectangle(x, y, 30, 30);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void fall() {
        rectangle.setY(++y);
    }

}
