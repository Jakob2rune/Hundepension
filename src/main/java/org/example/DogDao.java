package org.example;

public interface DogDao {
    void readDog(String no) throws Exception;
    void readAllDogs() throws Exception;
    void createDog(Dog dog) throws Exception;
}