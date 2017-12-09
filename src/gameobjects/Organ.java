package gameobjects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Organ extends GameObject {
    private final String name;
    private final String description;

    private Organ(GraphicsContext gc, Image image, String name, String description, double x, double y) {
        super(gc, x, y);
        this.name = name;
        this.description = description;
        this.image = image;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static class Builder {
        private String name;
        private String description;
        private Image image;
        private GraphicsContext graphicsContext;
        private int x, y;

        public Builder(GraphicsContext graphicsContext) {
            this.graphicsContext = graphicsContext;
        }

        public Builder image(String imagePath) {
            image = new Image(getClass().getResourceAsStream(String.format("../resource/%s", imagePath)));
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder position(int x, int y) {
            this.x = x;
            this.y = y;
            return this;
        }

        public Organ build() {
            return new Organ(graphicsContext, image, name, description, x, y);
        }

    }
}
