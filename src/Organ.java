import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Organ extends GameObject {
    private final String name;
    private final String description;

    public Organ(GraphicsContext gc, Image image, String name, String description, double x, double y) {
        super(gc, x, y);
        this.name = name;
        this.description = description;
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

        public Builder(GraphicsContext graphicsContext) {
            this.graphicsContext = graphicsContext;
        }

        public Builder image(String imagePath) {
            image = new Image(Organ.class.getResource(imagePath).toExternalForm());
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

        public Organ build() {
            // TODO: x, y positions
            return new Organ(graphicsContext, image, name, description, 0, 0);
        }

    }
}
