package org.example;

/**
 * Made by Louise
 * The interface defines the methods that implementing classes must use and create
 * to work with the data from the Dog class.
 * The throws exception tells us that errors might occur and the implementing classes themselves
 * must handle these errors.
 */

public interface DogDao {
    void readDog(int dogId) throws Exception;
    void readAllDogs() throws Exception;
    void createDog(Dog dog) throws Exception;
    void deleteDog(int dogId) throws Exception;
    //void readDogID(int dogId) throws Exception;
}