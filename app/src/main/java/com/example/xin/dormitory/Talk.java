package com.example.xin.dormitory;

public class Talk {
    private String name;
    private int imageId;
    public Talk(String name,int imageId)
    {
        this.name=name;
        this.imageId=imageId;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }
}
