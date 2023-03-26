package com.example.accuceries;

public class GroceryItem {
    private String name, image;
    private Double price;
    private int quantity;
    private boolean isChecked;

    public GroceryItem(String name, String image, Double price, int quantity, boolean isChecked) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.isChecked = isChecked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked() {
        isChecked = !isChecked;
    }
}
