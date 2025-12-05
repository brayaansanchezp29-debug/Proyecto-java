
/**
 * Clase Plato - Representa un plato del menú
 * @author Brayan Alejandro Sanchez Pedroza
 */
public class Dish2 {
    private String name;
    private String category;
    private double price;
    private boolean available;

    public Dish2(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.available = true; // Por defecto disponible
    }

    public void showInfo() {
        System.out.println("=== PLATO ===");
        System.out.println("Nombre: " + name);
        System.out.println("Categoría: " + category);
        System.out.println("Precio: $" + String.format("%.0f", price));
        System.out.println("Disponible: " + (available ? "Sí" : "No"));
    }

    // Método de negocio
    public double calculateDiscountPrice(double percentage) {
        return price - (price * percentage / 100);
    }

    // Getters y Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}