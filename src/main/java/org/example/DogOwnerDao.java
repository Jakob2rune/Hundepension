package org.example;

public interface DogOwnerDao {
    void readDogOwner(String no) throws Exception;
    void readAllDogOwners() throws Exception;
    void createDogOwner(DogOwner dogOwner) throws Exception;
}
