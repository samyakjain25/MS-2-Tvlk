package com.traveloka.ecommerce.model;

import org.springframework.data.annotation.Id;

public class
Product {
    @Id
    private String id;
    private String name;
    private String description;
    private Double price;
    private String image;
    private String url;

    public Product(){

    }
    public Product(String name, String description, Double price, String image, String url) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desription) {
        this.description = desription;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        url = url;
    }

    // all arguments contructor

}
