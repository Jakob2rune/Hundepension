package org.example;

/**
 * Made by Louise
 * The class that
 */

public interface DogDao {
    void readDog(int dogId) throws Exception;
    void readAllDogs() throws Exception;
    void createDog(Dog dog) throws Exception;
    void deleteDog(int dogId) throws Exception;
}