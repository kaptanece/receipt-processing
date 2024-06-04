package com.example.travelguide;

public class Hotel {
  private String name;
  private String description;
  private int imageResourceId; // Image resource ID
  private double price; // Price of the hotel

  // Constructor with new fields
  public Hotel(String name, String description, int imageResourceId, double price) {
    this.name = name;
    this.description = description;
    this.imageResourceId = imageResourceId;
    this.price = price;
  }

  // Getters
  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public int getImageResourceId() {
    return imageResourceId;
  }

  public double getPrice() {
    return price;
  }
}
