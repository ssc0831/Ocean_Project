package com.example.oceanapp;

import android.graphics.Bitmap;

public class Whale {
    private long whaleId;
    //private String whaleName;
    private double length;
    private double weight;
    private String content;
    private Bitmap whaleImg;

    public long getWhaleId() {
        return whaleId;
    }

    public void setWhaleId(long whaleId) {
        this.whaleId = whaleId;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Bitmap getWhaleImg() {
        return whaleImg;
    }

    public void setWhaleImg(Bitmap whaleImg) {
        this.whaleImg = whaleImg;
    }

    public Whale(long whaleId, double length, double weight, String content, Bitmap whaleImg) {
        this.whaleId = whaleId;
        this.length = length;
        this.weight = weight;
        this.content = content;
        this.whaleImg = whaleImg;
    }
}
