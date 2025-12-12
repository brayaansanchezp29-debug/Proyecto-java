package com.restaurante.modelo;

import com.restaurante.excepciones.DishNotAvailableException;

/**
 * Clase modelo: Plato del restaurante
 * Con validaciones y excepciones
 */
public class Dish6 {
    private String code;
    private String name;
    private String category;
    private double price;
    private boolean available;
    private int stock;

    // ====== CONSTRUCTOR ======

    /**
     * Constructor completo con validaciones
     * @param code Código del plato (formato D###)
     * @param name Nombre del plato
     * @param category Categoría
     * @param price Precio
     * @param stock Stock disponible
     * @throws IllegalArgumentException Si los datos son inválidos
     */
    public Dish6(String code, String name, String category, double price, int stock) {
        setCode(code);
        setName(name);
        setCategory(category);
        setPrice(price);
        setStock(stock);
        this.available = true;
    }

    // ====== VALIDACIONES CON EXCEPCIONES ======

    /**
     * Valida y establece el código
     * @param code Código del plato
     * @throws IllegalArgumentException Si el formato es inválido
     */
    public void setCode(String code) {
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("Código no puede estar vacío");
        }
        if (!code.matches("D\\d{3}")) {
            throw new IllegalArgumentException(
                    "Código debe tener formato D### (ejemplo: D001). Recibido: " + code
            );
        }
        this.code = code;
    }

    /**
     * Valida y establece el nombre
     * @param name Nombre del plato
     * @throws IllegalArgumentException Si el nombre es inválido
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre no puede estar vacío");
        }
        if (name.length() < 3) {
            throw new IllegalArgumentException(
                    "Nombre debe tener al menos 3 caracteres"
            );
        }
        this.name = name;
    }

    /**
     * Valida y establece la categoría
     * @param category Categoría del plato
     * @throws IllegalArgumentException Si la categoría es inválida
     */
    public void setCategory(String category) {
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Categoría no puede estar vacía");
        }

        String[] validCategories = {"Plato Fuerte", "Sopa", "Entrada", "Postre", "Bebida"};
        boolean isValid = false;
        for (String valid : validCategories) {
            if (valid.equalsIgnoreCase(category)) {
                isValid = true;
                break;
            }
        }

        if (!isValid) {
            throw new IllegalArgumentException(
                    "Categoría inválida: " + category +
                            ". Debe ser: Plato Fuerte, Sopa, Entrada, Postre o Bebida"
            );
        }
        this.category = category;
    }

    /**
     * Valida y establece el precio
     * @param price Precio del plato
     * @throws IllegalArgumentException Si el precio es inválido
     */
    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(
                    "Precio debe ser mayor a 0. Recibido: " + price
            );
        }
        if (price > 500000) {
            throw new IllegalArgumentException(
                    "Precio no puede exceder $500,000. Recibido: " + price
            );
        }
        this.price = price;
    }

    /**
     * Valida y establece el stock
     * @param stock Cantidad disponible
     * @throws IllegalArgumentException Si el stock es negativo
     */
    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException(
                    "Stock no puede ser negativo. Recibido: " + stock
            );
        }
        this.stock = stock;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    // ====== MÉTODOS DE NEGOCIO CON EXCEPCIONES ======

    /**
     * Verifica disponibilidad y lanza excepción si no está disponible
     * @throws DishNotAvailableException Si el plato no está disponible
     */
    public void checkAvailability() throws DishNotAvailableException {
        if (!available) {
            throw new DishNotAvailableException(
                    "El plato '" + name + "' no está disponible en el menú actualmente"
            );
        }
        if (stock <= 0) {
            throw new DishNotAvailableException(
                    "El plato '" + name + "' está agotado (stock: " + stock + ")"
            );
        }
    }

    /**
     * Reduce el stock en la cantidad especificada
     * @param quantity Cantidad a reducir
     * @throws DishNotAvailableException Si no hay suficiente stock
     * @throws IllegalArgumentException Si la cantidad es inválida
     */
    public void reduceStock(int quantity) throws DishNotAvailableException {
        if (quantity <= 0) {
            throw new IllegalArgumentException(
                    "Cantidad debe ser mayor a 0. Recibido: " + quantity
            );
        }

        checkAvailability();

        if (stock < quantity) {
            throw new DishNotAvailableException(
                    "Stock insuficiente para '" + name + "'. " +
                            "Disponible: " + stock + ", Solicitado: " + quantity
            );
        }

        stock -= quantity;
        System.out.println("✅ Stock reducido: " + name + " (Restante: " + stock + ")");
    }

    // ====== GETTERS ======

    public String getCode() { return code; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public boolean isAvailable() { return available; }
    public int getStock() { return stock; }

    // ====== MÉTODOS AUXILIARES ======

    public String getFormattedPrice() {
        return String.format("$%,.0f", price);
    }

    public void showInfo() {
        System.out.println("=== PLATO ===");
        System.out.println("Código: " + code);
        System.out.println("Nombre: " + name);
        System.out.println("Categoría: " + category);
        System.out.println("Precio: " + getFormattedPrice());
        System.out.println("Stock: " + stock);
        System.out.println("Disponible: " + (available ? "Sí" : "No"));
    }

    @Override
    public String toString() {
        return "Dish6{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
