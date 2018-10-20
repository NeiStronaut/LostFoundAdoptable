package org.neistronaut.lostfoundadoptable.dogs;

public class Dog {

    public enum DOG_SIZES {
        MINI, SMALL, MEDIUM, LARGE, UNDEFINED;
    }

    private long id;
    private String name;
    private int age;
    private DOG_SIZES size;
    private String breed;
    private String description;

    public Dog(long id, String name, int age, DOG_SIZES size, String breed, String description) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.size = size;
        this.breed = breed;
        this.description = description;
    }
    public Dog(long id, String name, int age, String size, String breed, String description) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.size = DOG_SIZES.valueOf(size);
        this.breed = breed;
        this.description = description;
    }

    public Dog() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public DOG_SIZES getSize() {
        return size;
    }

    public void setSize(DOG_SIZES size) {
        this.size = size;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object[] serializeForDb() {
        return new String[] {Long.toString(id), name, Integer.toString(age), size.toString(), breed, description};
    }
}
