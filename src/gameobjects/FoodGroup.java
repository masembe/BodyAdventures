package gameobjects;

import java.util.Random;

public enum FoodGroup {

    CARBOHYDRATES,
    PROTEIN,
    FATS;
    static final Random random = new Random();

    public static FoodGroup getRandom(){
        return values()[random.nextInt(values().length)];
    }


}
