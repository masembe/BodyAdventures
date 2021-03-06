package gameobjects;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class FallingFood extends GameObject {

    private static Random random = new Random(System.currentTimeMillis());
    private Rectangle rectangle;
    private FoodGroup foodGroup;

    public FallingFood(Image image, FoodGroup foodGroup) {
        super(random.nextInt((int) graphicsContext.getCanvas().getWidth()), 0);
        this.foodGroup = foodGroup;
        this.image = image;
        rectangle = new Rectangle(x, y, 30, 30);
    }
	
    
    public Rectangle getRectangle() {
        return rectangle;
    }

    public void fall() {
        y +=3;
        rectangle.setY(y);
    }


    public FoodGroup getFoodGroup() {
        return foodGroup;
    }
}
