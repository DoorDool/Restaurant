package com.example.dorin.restaurant;

import java.io.Serializable;

public class MenuItem implements Serializable {

    String name, description, imageUrl, category;
    Integer price;

    public MenuItem(String name, String description, String imageUrl, Integer price, String category) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
        this.category = category;
    }

    // getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {this.name = name;}
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {this.description = description;}
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) {this.imageUrl = imageUrl;}
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {this.price = price;}
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {this.category = category;}
}
