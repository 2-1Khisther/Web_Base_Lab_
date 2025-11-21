package com.balat.lab_7;

public class Product {

    private Long id;
    private String name;
    private Double price;

    // Default constructor
    public Product() {}

    // Parameterized constructor
    public Product(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters
    public Long getId() {
        return id; }

    public String getName() {
        return name; }

    public Double getPrice() {
        return price; }

    // Setters
    public void setId(Long id) {
        this.id = id; }

    public void setName(String name) {
        this.name = name; }

    public void setPrice(Double price) {
        this.price = price; }

    // toString()
    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "', price=" + price + "}";
    }
}
