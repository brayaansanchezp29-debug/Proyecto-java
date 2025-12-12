package implementaciones;

import abstractas.Product;
import interfaces.Preparable;
import interfaces.Deliverable;
import interfaces.Discountable;
import interfaces.Ratable;

import java.util.ArrayList;

/**
 * Clase Concreta: Dish5 (Plato)
 * Extiende Product e implementa múltiples interfaces
 */
public class Dish5 extends Product implements Preparable, Deliverable, Discountable, Ratable {

    // ====== ATRIBUTOS PROPIOS ======
    private int preparationTime;
    private boolean inPreparation;
    private String preparationStatus;
    private ArrayList<Integer> ratings;
    private ArrayList<String> comments;

    // ====== CONSTRUCTOR ======

    public Dish5(String name, double price, String category, int preparationTime) {
        super(name, price, category);
        this.preparationTime = preparationTime;
        this.inPreparation = false;
        this.preparationStatus = "No iniciado";
        this.ratings = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    // ====== IMPLEMENTACIÓN DE MÉTODOS ABSTRACTOS ======

    @Override
    public double calculateTotalCost() {
        // Costo incluye precio base + costos de preparación
        double preparationCost = preparationTime * 500; // $500 por minuto
        return price + preparationCost;
    }

    @Override
    public String getDetailedDescription() {
        return String.format("Plato: %s | Categoría: %s | Precio: $%s | " +
                        "Tiempo preparación: %d min | Calificación: %.1f⭐",
                name, category, formatMoney(price),
                preparationTime, getAverageRating());
    }

    @Override
    public boolean isReadyToServe() {
        return !inPreparation && available && preparationStatus.equals("Completado");
    }

    // ====== IMPLEMENTACIÓN DE PREPARABLE ======

    @Override
    public void startPreparation() {
        this.inPreparation = true;
        this.preparationStatus = "En preparación";
        System.out.println("🍳 Iniciando preparación de: " + name);
    }

    @Override
    public void finishPreparation() {
        this.inPreparation = false;
        this.preparationStatus = "Completado";
        System.out.println("✅ " + name + " está listo para servir");
    }

    @Override
    public int getPreparationTime() {
        return preparationTime;
    }

    @Override
    public boolean isInPreparation() {
        return inPreparation;
    }

    @Override
    public String getPreparationStatus() {
        return preparationStatus;
    }

    // ====== IMPLEMENTACIÓN DE DELIVERABLE ======

    @Override
    public double calculateDeliveryCost(double distance) {
        // $2000 base + $1000 por km
        double baseCost = 2000;
        double perKmCost = 1000 * distance;
        return baseCost + perKmCost;
    }

    @Override
    public boolean canBeDelivered() {
        // Los platos calientes pueden ser entregados si están listos
        return isReadyToServe() && !category.equals("Sopa"); // Sopas no se entregan
    }

    @Override
    public void packageForDelivery() {
        if (canBeDelivered()) {
            System.out.println("📦 Empacando " + name + " para entrega");
            System.out.println("   - Contenedor térmico");
            System.out.println("   - Cubiertos desechables");
            System.out.println("   - Servilletas");
        } else {
            System.out.println("❌ " + name + " no puede ser empacado para entrega");
        }
    }

    @Override
    public String getDeliveryInstructions() {
        return "Mantener " + name + " en posición horizontal. " +
                "No apilar. Entregar en menos de 30 minutos.";
    }

    // ====== IMPLEMENTACIÓN DE DISCOUNTABLE ======

    @Override
    public double applyDiscount(double percentage) {
        if (!isEligibleForDiscount()) {
            System.out.println("❌ " + name + " no es elegible para descuento");
            return price;
        }

        if (percentage > getMaximumDiscount()) {
            percentage = getMaximumDiscount();
            System.out.println("⚠️  Descuento ajustado al máximo permitido: " + percentage + "%");
        }

        double discountedPrice = price - (price * percentage / 100);
        System.out.println("💰 Descuento aplicado: " + percentage + "% en " + name);
        System.out.println("   Precio original: $" + formatMoney(price));
        System.out.println("   Precio con descuento: $" + formatMoney(discountedPrice));
        return discountedPrice;
    }

    @Override
    public boolean isEligibleForDiscount() {
        // Platos mayores a $15000 son elegibles
        return price >= 15000;
    }

    @Override
    public double getMaximumDiscount() {
        // Descuento máximo del 30%
        return 30.0;
    }

    @Override
    public double calculateSavings(double percentage) {
        if (percentage > getMaximumDiscount()) {
            percentage = getMaximumDiscount();
        }
        return price * (percentage / 100);
    }

    // ====== IMPLEMENTACIÓN DE RATABLE ======

    @Override
    public void addRating(int rating, String comment) {
        if (rating < 1 || rating > 5) {
            System.out.println("❌ Calificación debe estar entre 1 y 5");
            return;
        }

        ratings.add(rating);
        comments.add(comment != null ? comment : "Sin comentario");
        System.out.println("⭐ Calificación agregada: " + rating + " estrellas");
        if (comment != null && !comment.isEmpty()) {
            System.out.println("   Comentario: " + comment);
        }
    }

    @Override
    public double getAverageRating() {
        if (ratings.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (int rating : ratings) {
            sum += rating;
        }
        return (double) sum / ratings.size();
    }

    @Override
    public int getTotalRatings() {
        return ratings.size();
    }

    @Override
    public boolean hasGoodRatings() {
        return getAverageRating() >= 4.0;
    }

    // ====== MÉTODOS PROPIOS ======

    public void showFullInfo() {
        showBasicInfo();
        System.out.println("Tiempo de preparación: " + preparationTime + " min");
        System.out.println("Estado preparación: " + preparationStatus);
        System.out.println("Puede ser entregado: " + (canBeDelivered() ? "Sí" : "No"));
        System.out.println("Elegible descuento: " + (isEligibleForDiscount() ? "Sí" : "No"));
        System.out.println("Calificación promedio: " + String.format("%.1f", getAverageRating()) +
                "⭐ (" + getTotalRatings() + " reseñas)");
    }

    public void showRatings() {
        if (ratings.isEmpty()) {
            System.out.println("Sin calificaciones aún");
            return;
        }

        System.out.println("\n=== CALIFICACIONES DE " + name.toUpperCase() + " ===");
        for (int i = 0; i < ratings.size(); i++) {
            System.out.println((i + 1) + ". " + ratings.get(i) + "⭐ - " + comments.get(i));
        }
        System.out.println("Promedio: " + String.format("%.1f", getAverageRating()) + "⭐");
    }

    @Override
    public String toString() {
        return "Dish5{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", preparationTime=" + preparationTime +
                ", rating=" + String.format("%.1f", getAverageRating()) +
                '}';
    }
}
