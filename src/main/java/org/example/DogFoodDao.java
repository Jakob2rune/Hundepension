package org.example;

public interface DogFoodDao {
    void readDogFood(String no) throws Exception;
    void readAllDogFoods() throws Exception;
    void createDogFood(DogFood dogFood) throws Exception;
}