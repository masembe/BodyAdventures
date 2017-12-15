package gameobjects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GameObject {

    protected Image image;
    protected double x, y;
    protected static GraphicsContext graphicsContext;

    protected GameObject(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static void setGraphicsContext(GraphicsContext graphicsContext) {
        GameObject.graphicsContext = graphicsContext;
    }

    public void update() {
        if (image != null)
            graphicsContext.drawImage(image, x, y, 50, 50);
    }
}
