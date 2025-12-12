package implementaciones;

import abstractas.Product;
import interfaces.Deliverable;
import interfaces.Discountable;

/**
 * Clase Concreta: Beverage (Bebida)
 * Extiende Product e implementa menos interfaces que Dish5
 */
public class Beverage extends Product implements Deliverable, Discountable {

    // ====== ATRIBUTOS PROPIOS ======
    private String size; // Pequeño, Mediano, Grande
    private boolean isCold;

    // ====== CONSTRUCTOR ======

    public Beverage(String name, double price, String size, boolean isCold) {
        super(name, price, "Bebida");
        this.size = size;
        this.isCold = isCold;
    }

    // ====== IMPLEMENTACIÓN DE MÉTODOS ABSTRACTOS ======

    @Override
    public double calculateTotalCost() {
        // Bebidas frías cuestan menos de preparar
        double preparationCost = isCold ? 500 : 1000;
        return price + preparationCost;
    }

    @Override
    public String getDetailedDescription() {
        return String.format("Bebida: %s | Tamaño: %s | %s | Precio: $%s",
                name, size, (isCold ? "Fría" : "Caliente"),
                formatMoney(price));
    }

    @Override
    public boolean isReadyToServe() {
        // Las bebidas siempre están listas
        return available;
    }

    // ====== IMPLEMENTACIÓN DE DELIVERABLE ======

    @Override
    public double calculateDeliveryCost(double distance) {
        // Bebidas tienen costo de delivery más bajo
        return 1500 + (500 * distance);
    }

    @Override
    public boolean canBeDelivered() {
        // Todas las bebidas pueden ser entregadas
        return available;
    }

    @Override
    public void packageForDelivery() {
        System.out.println("📦 Empacando " + name + " (" + size + ")");
        if (isCold) {
            System.out.println("   - Vaso con tapa");
            System.out.println("   - Pajilla");
            System.out.println("   - Hielo extra");
        } else {
            System.out.println("   - Vaso térmico con tapa");
            System.out.println("   - Servilletas");
        }
    }

    @Override
    public String getDeliveryInstructions() {
        if (isCold) {
            return "Mantener " + name + " refrigerada. No exponer al sol.";
        } else {
            return "Mantener " + name + " caliente. Entregar en menos de 15 minutos.";
        }
    }

    // ====== IMPLEMENTACIÓN DE DISCOUNTABLE ======

    @Override
    public double applyDiscount(double percentage) {
        if (!isEligibleForDiscount()) {
            System.out.println("❌ " + name + " no es elegible para descuento");
            return price;
        }

        double discountedPrice = price - (price * percentage / 100);
        System.out.println("💰 Descuento en bebida: " + percentage + "%");
        return discountedPrice;
    }

    @Override
    public boolean isEligibleForDiscount() {
        // Bebidas mayores a $5000 son elegibles
        return price >= 5000;
    }

    @Override
    public double getMaximumDiscount() {
        // Bebidas tienen descuento máximo del 20%
        return 20.0;
    }

    @Override
    public double calculateSavings(double percentage) {
        if (percentage > getMaximumDiscount()) {
            percentage = getMaximumDiscount();
        }
        return price * (percentage / 100);
    }

    // ====== GETTERS Y SETTERS ======

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public boolean isCold() { return isCold; }
    public void setCold(boolean cold) { isCold = cold; }

    // ====== MÉTODO PROPIO ======

    public void showFullInfo() {
        showBasicInfo();
        System.out.println("Tamaño: " + size);
        System.out.println("Temperatura: " + (isCold ? "Fría" : "Caliente"));
        System.out.println("Puede ser entregada: Sí");
        System.out.println("Elegible descuento: " + (isEligibleForDiscount() ? "Sí" : "No"));
    }

    @Override
    public String toString() {
        return "Beverage{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", isCold=" + isCold +
                ", price=" + price +
                '}';
    }
}