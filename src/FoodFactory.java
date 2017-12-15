
import gameobjects.FallingFood;
import gameobjects.FoodGroup;
import javafx.scene.image.Image;

import java.util.Random;

public class FoodFactory {

    private static final String[] carbohydrateImages = {"carbohydrates.png",  "pasta.gif" ,"rice.png"};
    private static final String[] proteinImages = {"protein.png","fish.png","peas.png"};
    private static final String[] fatsImages = {"fats.png","burger.png","icecream.png"};
    private static final Random random = new Random();

    public static FallingFood createFood(FoodGroup foodGroup){
        String imageName;
        Image image = null;
        switch (foodGroup) {
            case CARBOHYDRATES:
                 imageName =  carbohydrateImages[random.nextInt(carbohydrateImages.length)];
                //Formats the pathname of the various falling food images
                 image = new Image(FoodFactory.class.getResourceAsStream(String.format("resource/%s", imageName)));
                 break;

            case PROTEIN:
                 imageName =  proteinImages[random.nextInt(proteinImages.length)];
                //Formats the pathname of the various falling food images
                image = new Image(FoodFactory.class.getResourceAsStream(String.format("resource/%s", imageName)));
                break;

            case FATS:
                 imageName =  fatsImages[random.nextInt(carbohydrateImages.length)];
                //Formats the pathname of the various falling food images
                image = new Image(FoodFactory.class.getResourceAsStream(String.format("resource/%s", imageName)));


        }
        return new FallingFood(image,foodGroup);
    }
}
