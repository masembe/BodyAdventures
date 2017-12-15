package gameobjects;

import java.util.Random;

public enum FoodGroup {

    CARBOHYDRATES("carbohydrates.png"),
    PROTEIN("protein.png"),
    FATS("fats.png");

    private static final Random random = new Random();
    private final String[] images;

   //Variable number of images of food items per food group can be stored
    FoodGroup(String... images) {
        this.images = images;
    }

    String getImageName() {
        return images[random.nextInt(images.length)];
    }
}
