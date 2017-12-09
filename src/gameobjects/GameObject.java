package gameobjects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GameObject {

    protected Image image;
    protected double x, y;
    protected GraphicsContext graphicsContext;

    protected GameObject(GraphicsContext graphicsContext, double x, double y) {
        this.graphicsContext = graphicsContext;
        this.x = x;
        this.y = y;
    }

    public void update() {
        if (image != null)
            graphicsContext.drawImage(image, x, y, 30, 30);
    }
}
