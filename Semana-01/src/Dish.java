
/**
 * Clase Plato del Restaurante Sabores del Valle
 * @author Brayan Alejandro Sanchez Pedroza
 * @ficha 3228973B
 */
public class Dish {
    private String name;
    private String category;
    private double price;
    
    public Dish(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }
    
    public void showInfo() {
        System.out.println("================================");
        System.out.println("Plato: " + name);
        System.out.println("Categoría: " + category);
        System.out.println("Precio: $" + String.format("%.0f", price));
        System.out.println("================================");
    }
    
    // Getters y Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}