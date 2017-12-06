import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.List;

public class Human extends GameObject {

    public List<Organ> organs;

    public Human(GraphicsContext graphicsContext) {
        super(graphicsContext, graphicsContext.getCanvas().getWidth() / 4, 0);
        image = new Image(getClass().getResourceAsStream("resource/body.png"));
    }

    @Override
    public void update() {
        graphicsContext.drawImage(image, x, y, 542, 550);
    }
}
