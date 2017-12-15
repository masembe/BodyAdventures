package gameobjects;

import java.util.Random;

public enum FoodGroup {

    CARBOHYDRATES("carbohydrates.png"),
    PROTEIN("protein.png"),
    FATS("fats.png");

    private static final Random random = new Random();
    private final String[] images;


    FoodGroup(String... images) {
        this.images = images;
    }

    String getImageName() {
        return images[random.nextInt(images.length)];
    }
}
