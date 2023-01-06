package com.example.miniproject;
public class ARMainModel {
    String name, price, available, url;
    ARMainModel(){}
    public ARMainModel(String name, String price, String available, String url) {
        this.name = name;
        this.price = price;
        this.available = available;
        this.url = url;
    }
    //returns the name of the entity
    public String getName() {
        return name;
    }
    //changes the name
    public void setName(String name) {
        this.name = name;
    }
    //returns the price of the entity
    public String getPrice() {
        return price;
    }
    // changes the price
    public void setPrice(String price) {
        this.price = price;
    }
    //returns the available of the entity
    public String getAvailable() {
        return available;
    }
    // changes the available
    public void setAvailable(String available) {
        this.available = available;
    }
    //returns the url of the entity
    public String getUrl() {
        return url;
    }
    // changes the url
    public void setUrl(String url) {
        this.url = url;
    }
}
