package com.example.app31;

public class Toy {
    private int price;
    private String title;
    private String subTitle;

    @Override
    public String toString() {
        return "Toy{" +
                "price=" + price +
                ", title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                '}';
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Toy(int price, String title, String subTitle) {
        this.price = price;
        this.title = title;
        this.subTitle = subTitle;
    }
}
