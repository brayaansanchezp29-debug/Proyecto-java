package com.restaurante.modelo;

/**
 * Modelo de Plato - Versión simplificada para Semana 08
 */
public class Dish7 {
    private String code;
    private String name;
    private String category;
    private double price;
    private int stock;

    public Dish7(String code, String name, String category, double price, int stock) {
        this.code = code;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    // Getters
    public String getCode() { return code; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    // Setters
    public void setPrice(double price) { this.price = price; }
    public void setStock(int stock) { this.stock = stock; }

    public void reduceStock(int quantity) {
        this.stock -= quantity;
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%s) - $%,.0f - Stock: %d",
                code, name, category, price, stock);
    }
}