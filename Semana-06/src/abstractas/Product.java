package abstractas;

/**
 * Clase Abstracta: Product
 * Representa cualquier producto que se vende en el restaurante
 */
public abstract class Product {
    // ====== ATRIBUTOS PROTEGIDOS ======
    protected String name;
    protected double price;
    protected String category;
    protected boolean available;

    // ====== CONSTRUCTOR ======

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.available = true;
    }

    // ====== MÉTODOS ABSTRACTOS (deben ser implementados) ======

    /**
     * Calcula el costo total del producto
     * Cada tipo de producto calcula su costo de forma diferente
     */
    public abstract double calculateTotalCost();

    /**
     * Obtiene una descripción detallada del producto
     * Cada tipo tiene información diferente
     */
    public abstract String getDetailedDescription();

    /**
     * Verifica si el producto está listo para servir/vender
     */
    public abstract boolean isReadyToServe();

    // ====== MÉTODOS CONCRETOS (implementación compartida) ======

    /**
     * Muestra información básica del producto
     * Método concreto que todas las subclases heredan
     */
    public void showBasicInfo() {
        System.out.println("=== PRODUCTO ===");
        System.out.println("Nombre: " + name);
        System.out.println("Categoría: " + category);
        System.out.println("Precio: $" + formatMoney(price));
        System.out.println("Disponible: " + (available ? "Sí" : "No"));
    }

    /**
     * Calcula precio con IVA
     * Implementación común para todos los productos
     */
    public double calculatePriceWithTax() {
        return price * 1.19; // IVA del 19%
    }

    /**
     * Activa/desactiva disponibilidad
     */
    public void toggleAvailability() {
        this.available = !this.available;
        System.out.println(name + " ahora está " + (available ? "disponible" : "no disponible"));
    }

    /**
     * Verifica si es un producto económico
     */
    public boolean isEconomical() {
        return price < 20000;
    }

    /**
     * Formatea dinero
     */
    protected String formatMoney(double amount) {
        return String.format("%,.0f", amount);
    }

    // ====== GETTERS Y SETTERS ======

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) {
        if (price > 0) this.price = price;
    }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }
}
