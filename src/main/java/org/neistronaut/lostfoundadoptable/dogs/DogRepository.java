package org.neistronaut.lostfoundadoptable.dogs;

import java.util.ArrayList;
import java.util.List;

public class DogRepository {

    public static List<Dog> DOG_INITIAL_DATABASE = createDogDatabase();

    private static List<Dog> createDogDatabase() {
        List<Dog> dogs = new ArrayList<Dog>();
        dogs.add(new Dog(10L, "Puka", 2, Dog.DOG_SIZES.MINI, "Chihuahua", "Healthy"));
        dogs.add(new Dog(11L, "Kuma", 8, Dog.DOG_SIZES.MEDIUM, "Husky mix", "Healthy"));
        dogs.add(new Dog(12L, "Lolo", 10, Dog.DOG_SIZES.MEDIUM, "German Shepherd mix", "Healthy"));
        dogs.add(new Dog(13L, "Luna", 4, Dog.DOG_SIZES.SMALL, "Poodle mix", "Healthy"));
        dogs.add(new Dog(14L, "Cami", 3, Dog.DOG_SIZES.MINI, "Pug", "Heart disease"));
        dogs.add(new Dog(15L, "Momo", 2, Dog.DOG_SIZES.MEDIUM, "Lab mix", "Right eye blind"));
        dogs.add(new Dog(16L, "Chai", 7, Dog.DOG_SIZES.MEDIUM, "Mix", "Deaf"));
        dogs.add(new Dog(17L, "Moka", 2, Dog.DOG_SIZES.LARGE, "Giant Schnauzer", "Healthy"));
        dogs.add(new Dog(18L, "Paris", 6, Dog.DOG_SIZES.SMALL, "Corgi", "Healthy"));
        return dogs;
    }
}
