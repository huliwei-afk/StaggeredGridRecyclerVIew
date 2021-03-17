package com.example.staggeredgridrecyclerview;

public class Picture {
    private String name;
    private int imageId;

    public Picture(String name, int imageId){
        this.imageId = imageId;
        this.name = name;
    }

    public int getImageId(){
        return imageId;
    }

    public String getName(){
        return name;
    }



}