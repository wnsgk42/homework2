package com.example.homeworkapp2;

import android.media.Image;

public class FriendData {
    private String name;
    private String info;
    private Image image;

    public FriendData(){
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Image getImage(){
        return image;
    }

    public void setImage(Image image){
        this.image=image;
    }

    public FriendData (String name, String info, Image image){
        this.name=name;
        this.info=info;
        this.image =image;
    }
}
