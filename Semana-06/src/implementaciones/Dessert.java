package implementaciones;

import abstractas.Product;
import interfaces.Preparable;
import interfaces.Deliverable;
import interfaces.Ratable;

import java.util.ArrayList;

/**
 * Clase Concreta: Dessert (Postre)
 * Extiende Product e implementa Preparable, Deliverable y Ratable
 */
public class Dessert extends Product implements Preparable, Deliverable, Ratable {

    // ====== ATRIBUTOS PROPIOS ======
    private int preparationTime;
    private boolean inPreparation;
    private String preparationStatus;
    private boolean requiresRefrigeration;
    private ArrayList<Integer> ratings;
    private ArrayList<String> comments;

    // ====== CONSTRUCTOR ======

    public Dessert(String name, double price, int preparationTime, boolean requiresRefrigeration) {
        super(name, price, "Postre");
        this.preparationTime = preparationTime;
        this.requiresRefrigeration = requiresRefrigeration;
        this.inPreparation = false;
        this.preparationStatus = "No iniciado";
        this.ratings = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    // ====== IMPLEMENTACIÓN DE MÉTODOS ABSTRACTOS ======

    @Override
    public double calculateTotalCost() {
        double preparationCost = preparationTime * 600; // $600 por minuto
        double refrigerationCost = requiresRefrigeration ? 1000 : 0;
        return price + preparationCost + refrigerationCost;
    }

    @Override
    public String getDetailedDescription() {
        return String.format("Postre: %s | Precio: $%s | Preparación: %d min | Calificación: %.1f⭐",
                name, formatMoney(price), preparationTime, getAverageRating());
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
        System.out.println("🍰 Preparando postre: " + name);
    }

    @Override
    public void finishPreparation() {
        this.inPreparation = false;
        this.preparationStatus = "Completado";
        if (requiresRefrigeration) {
            System.out.println("❄️  " + name + " listo y refrigerándose");
        } else {
            System.out.println("✅ " + name + " listo para servir");
        }
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
        double baseCost = 2500; // Más alto por requerir cuidado especial
        double perKmCost = 1200 * distance;
        if (requiresRefrigeration) {
            baseCost += 1000; // Costo adicional por refrigeración
        }
        return baseCost + perKmCost;
    }

    @Override
    public boolean canBeDelivered() {
        return isReadyToServe();
    }

    @Override
    public void packageForDelivery() {
        System.out.println("📦 Empacando postre: " + name);
        if (requiresRefrigeration) {
            System.out.println("   - Contenedor térmico refrigerado");
            System.out.println("   - Gel refrigerante");
        } else {
            System.out.println("   - Caja protectora");
        }
        System.out.println("   - Cubiertos para postre");
        System.out.println("   - Servilletas");
    }

    @Override
    public String getDeliveryInstructions() {
        if (requiresRefrigeration) {
            return "IMPORTANTE: " + name + " debe mantenerse refrigerado. " +
                    "Entregar en menos de 20 minutos. No exponer al sol.";
        } else {
            return "Mantener " + name + " en posición horizontal. " +
                    "Manejar con cuidado.";
        }
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
        System.out.println("⭐ Nueva calificación para " + name + ": " + rating + " estrellas");
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
        System.out.println("Requiere refrigeración: " + (requiresRefrigeration ? "Sí" : "No"));
        System.out.println("Estado: " + preparationStatus);
        System.out.println("Calificación: " + String.format("%.1f", getAverageRating()) +
                "⭐ (" + getTotalRatings() + " reseñas)");
    }

    public boolean requiresRefrigeration() {
        return requiresRefrigeration;
    }

    @Override
    public String toString() {
        return "Dessert{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", preparationTime=" + preparationTime +
                ", rating=" + String.format("%.1f", getAverageRating()) +
                '}';
    }
}
