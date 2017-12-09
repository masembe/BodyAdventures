package gameobjects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Human extends GameObject {

    public List<Organ> organs;

    public Human(GraphicsContext graphicsContext) {
        super(graphicsContext, graphicsContext.getCanvas().getWidth() / 4, 0);
        image = new Image(getClass().getResourceAsStream("../resource/body.png"));
        organs = new ArrayList<>();


        setUpOrgans();
    }

    private void setUpOrgans() {

        addOrgan(
                new Organ.Builder(graphicsContext)
                        .name("heart")
                        .image("heart.png")
                        .description("pumps blood")
                        .position(0, 0)
                        .build()
        );

        addOrgan(
                new Organ.Builder(graphicsContext)
                        .name("kidney")
                        .image("kidney.png")
                        .description("got two")
                        .position(30, 0)
                        .build()
        );

        addOrgan(
                new Organ.Builder(graphicsContext)
                        .name("brain")
                        .image("brain.png")
                        .description("you smart")
                        .position(60, 0)
                        .build()
        );

        addOrgan(
                new Organ.Builder(graphicsContext)
                        .name("liver")
                        .image("liver.png")
                        .description("clean me")
                        .position(90, 0)
                        .build()
        );

        addOrgan(
                new Organ.Builder(graphicsContext)
                        .name("lungs")
                        .image("lungs.png")
                        .description("breathe")
                        .position(120, 0)
                        .build()
        );

        addOrgan(
                new Organ.Builder(graphicsContext)
                        .name("stomach")
                        .image("stomach.png")
                        .description("I'm hungry")
                        .position(150, 0)
                        .build()
        );
    }

    private void addOrgan(Organ organ) {
        organs.add(organ);
    }

    @Override
    public void update() {
        graphicsContext.drawImage(image, x, y, 542, 550);
        organs.forEach(Organ::update);
    }
}
