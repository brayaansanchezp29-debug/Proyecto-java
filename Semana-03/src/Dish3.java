/**
 * Clase Plato - Semana 03 con Encapsulación Completa
 */
public class Dish3 {
    // ====== ATRIBUTOS PRIVADOS (Encapsulación) ======
    private String name;
    private String category;
    private double price;
    private boolean available;
    private int preparationTime; // Tiempo de preparación en minutos

    // ====== CONSTRUCTORES SOBRECARGADOS ======

    /**
     * Constructor completo
     * @param name Nombre del plato
     * @param category Categoría del plato
     * @param price Precio del plato
     * @param available Disponibilidad
     * @param preparationTime Tiempo de preparación
     */
    public Dish3(String name, String category, double price, boolean available, int preparationTime) {
        setName(name);           // Usa setter con validación
        setCategory(category);
        setPrice(price);
        this.available = available;
        setPreparationTime(preparationTime);
    }

    /**
     * Constructor sin tiempo de preparación (por defecto 15 minutos)
     */
    public Dish3(String name, String category, double price, boolean available) {
        this(name, category, price, available, 15);
    }

    /**
     * Constructor básico (disponible por defecto)
     */
    public Dish3(String name, String category, double price) {
        this(name, category, price, true, 15);
    }

    /**
     * Constructor mínimo (precio por defecto $15000)
     */
    public Dish3(String name, String category) {
        this(name, category, 15000, true, 15);
    }

    // ====== GETTERS ======

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    // ====== SETTERS CON VALIDACIONES ======

    public void setName(String name) {
        if (!isValidString(name)) {
            throw new IllegalArgumentException("Nombre del plato no puede estar vacío");
        }
        if (name.length() < 3) {
            throw new IllegalArgumentException("Nombre del plato debe tener al menos 3 caracteres");
        }
        this.name = name;
    }

    public void setCategory(String category) {
        if (!isValidString(category)) {
            throw new IllegalArgumentException("Categoría no puede estar vacía");
        }
        // Validar que sea una categoría válida
        if (!isValidCategory(category)) {
            throw new IllegalArgumentException("Categoría inválida. Use: Plato Fuerte, Sopa, Entrada, Postre, Bebida");
        }
        this.category = category;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Precio debe ser mayor a 0");
        }
        if (price > 500000) {
            throw new IllegalArgumentException("Precio no puede exceder $500,000");
        }
        this.price = price;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setPreparationTime(int preparationTime) {
        if (preparationTime < 0) {
            throw new IllegalArgumentException("Tiempo de preparación no puede ser negativo");
        }
        if (preparationTime > 120) {
            throw new IllegalArgumentException("Tiempo de preparación no puede exceder 120 minutos");
        }
        this.preparationTime = preparationTime;
    }

    // ====== MÉTODOS PRIVADOS AUXILIARES ======

    /**
     * Valida que un string no sea nulo ni vacío
     */
    private boolean isValidString(String str) {
        return str != null && !str.trim().isEmpty();
    }

    /**
     * Valida que la categoría sea una opción válida
     */
    private boolean isValidCategory(String category) {
        String[] validCategories = {"Plato Fuerte", "Sopa", "Entrada", "Postre", "Bebida", "Acompañamiento"};
        for (String valid : validCategories) {
            if (valid.equalsIgnoreCase(category)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Formatea el precio con separador de miles
     */
    private String formatPrice() {
        return String.format("$%,.0f", price);
    }

    // ====== MÉTODOS DE NEGOCIO ======

    /**
     * Calcula precio con descuento
     */
    public double calculateDiscountPrice(double percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Porcentaje debe estar entre 0 y 100");
        }
        return price - (price * percentage / 100);
    }

    /**
     * Verifica si es un plato económico
     */
    public boolean isEconomical() {
        return price < 20000;
    }

    /**
     * Verifica si es preparación rápida
     */
    public boolean isQuickPreparation() {
        return preparationTime <= 20;
    }

    /**
     * Muestra información completa del plato
     */
    public void showInfo() {
        System.out.println("=== PLATO ===");
        System.out.println("Nombre: " + name);
        System.out.println("Categoría: " + category);
        System.out.println("Precio: " + formatPrice());
        System.out.println("Disponible: " + (available ? "Sí" : "No"));
        System.out.println("Tiempo de preparación: " + preparationTime + " min");
        System.out.println("Clasificación: " + (isEconomical() ? "Económico" : "Premium"));
    }

    /**
     * Retorna resumen corto del plato
     */
    public String getShortDescription() {
        return name + " (" + category + ") - " + formatPrice();
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", available=" + available +
                '}';
    }
}
