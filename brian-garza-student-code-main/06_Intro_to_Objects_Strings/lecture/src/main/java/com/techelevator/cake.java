package com.techelevator;

public class cake {
    //State
    private String size;

    private boolean hasSprinkles;

    //Constructor
    public cake(String size, boolean hasSprinkles ){
        this.size = size;
        this.hasSprinkles = hasSprinkles;
    }

    //Behavior
    public String getSize(){
        return size;
    }

    public boolean getSprinkles() {
        return hasSprinkles;
    }
    public void setSize(String size){
        this.size = size;
    }
    public void setSprinkles(boolean hasSprinkles){
        this.hasSprinkles = hasSprinkles;
    }

}
