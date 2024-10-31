package org.example;

public class DogOwner {
    private int ownerID;       // Identifier for the ownerID
    private String name;  // Name of the owner
    private String address; // Address  of the owner
    private String phonenumber;

    public DogOwner(int ownerID, String name, String address, String phonenumber) {
        this.ownerID = ownerID;
        this.name = name;
        this.address = address;
        this.phonenumber = phonenumber;
    }

    public DogOwner() {

    }

    public int getownerID() {
        return ownerID;
    }


    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}


