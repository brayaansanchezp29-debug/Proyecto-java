import abstractas.Product;
import implementaciones.*;
import interfaces.*;

import java.util.ArrayList;

/**
 * Programa Prin cipal - Semana 06
 * Demostración de abstracción e interfaces
 */
public class Main6 {
    public static void main(String[] args) {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   SISTEMA DE GESTIÓN - SABORES DEL VALLE  ║");
        System.out.println("║   Semana 06 - ABSTRACCIÓN E INTERFACES     ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        // ========================================
        // 1. POLIMORFISMO CON CLASE ABSTRACTA
        // ========================================

        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║   PRODUCTOS DEL RESTAURANTE (Product)     ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        // ArrayList polimórfico: Product puede contener cualquier subclase
        ArrayList<Product> products = new ArrayList<>();

        Dish5 dish1 = new Dish5("Bandeja Paisa", 28000, "Plato Fuerte", 30);
        Dish5 dish2 = new Dish5("Ajiaco", 22000, "Sopa", 25);
        Beverage bev1 = new Beverage("Limonada Natural", 6000, "Mediano", true);
        Beverage bev2 = new Beverage("Chocolate Caliente", 5000, "Grande", false);
        Dessert dessert1 = new Dessert("Tres Leches", 12000, 15, true);
        Dessert dessert2 = new Dessert("Flan de Caramelo", 10000, 10, true);

        products.add(dish1);
        products.add(dish2);
        products.add(bev1);
        products.add(bev2);
        products.add(dessert1);
        products.add(dessert2);

        // Polimorfismo: mismo método, diferente comportamiento
        for (Product product : products) {
            System.out.println(product.getDetailedDescription());
            System.out.println("Costo total: $" + String.format("%,.0f", product.calculateTotalCost()));
            System.out.println("Listo para servir: " + (product.isReadyToServe() ? "✅" : "❌"));
            System.out.println();
        }

        // ========================================
        // 2. INTERFACE PREPARABLE
        // ========================================

        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║   INTERFACE: Preparable                    ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        // Referencia de tipo interface
        Preparable preparable1 = dish1;
        Preparable preparable2 = dessert1;

        System.out.println("--- Preparando Plato ---");
        preparable1.startPreparation();
        System.out.println("Tiempo estimado: " + preparable1.getPreparationTime() + " min");
        System.out.println("Estado: " + preparable1.getPreparationStatus());
        preparable1.finishPreparation();

        System.out.println("\n--- Preparando Postre ---");
        preparable2.startPreparation();
        System.out.println("En preparación: " + preparable2.isInPreparation());
        preparable2.finishPreparation();

        // ========================================
        // 3. INTERFACE DELIVERABLE
        // ========================================

        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   INTERFACE: Deliverable                   ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        double distance = 5.0; // 5 km

        System.out.println("--- Cálculo de Domicilio (5 km) ---");

        Deliverable deliverable1 = dish1;
        System.out.println("\n" + dish1.getName() + ":");
        System.out.println("Puede ser entregado: " + deliverable1.canBeDelivered());
        System.out.println("Costo domicilio: $" +
                String.format("%,.0f", deliverable1.calculateDeliveryCost(distance)));
        deliverable1.packageForDelivery();
        System.out.println("Instrucciones: " + deliverable1.getDeliveryInstructions());

        Deliverable deliverable2 = bev1;
        System.out.println("\n" + bev1.getName() + ":");
        System.out.println("Puede ser entregado: " + deliverable2.canBeDelivered());
        System.out.println("Costo domicilio: $" +
                String.format("%,.0f", deliverable2.calculateDeliveryCost(distance)));
        deliverable2.packageForDelivery();

        // ========================================
        // 4. INTERFACE DISCOUNTABLE
        // ========================================

        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   INTERFACE: Discountable                  ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        System.out.println("--- Aplicando Descuentos ---\n");

        Discountable discountable1 = dish1;
        System.out.println(dish1.getName() + ":");
        System.out.println("Elegible: " + discountable1.isEligibleForDiscount());
        System.out.println("Descuento máximo: " + discountable1.getMaximumDiscount() + "%");
        double discounted1 = discountable1.applyDiscount(15);
        System.out.println("Ahorro: $" + String.format("%,.0f", discountable1.calculateSavings(15)));

        System.out.println();

        Discountable discountable2 = bev1;
        System.out.println(bev1.getName() + ":");
        System.out.println("Elegible: " + discountable2.isEligibleForDiscount());
        double discounted2 = discountable2.applyDiscount(10);

        // ========================================
        // 5. INTERFACE RATABLE
        // ========================================

        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   INTERFACE: Ratable                       ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        System.out.println("--- Calificaciones de Clientes ---\n");

        Ratable ratable1 = dish1;
        ratable1.addRating(5, "¡Delicioso! Porción abundante");
        ratable1.addRating(4, "Muy bueno, recomendado");
        ratable1.addRating(5, "Excelente sabor tradicional");

        System.out.println("\n" + dish1.getName() + ":");
        System.out.println("Total calificaciones: " + ratable1.getTotalRatings());
        System.out.println("Promedio: " + String.format("%.1f", ratable1.getAverageRating()) + "⭐");
        System.out.println("Buenas calificaciones: " + (ratable1.hasGoodRatings() ? "✅" : "❌"));

        dish1.showRatings();

        System.out.println();

        Ratable ratable2 = dessert1;
        ratable2.addRating(5, "El mejor postre!");
        ratable2.addRating(5, "Perfecto");
        ratable2.addRating(4, "Muy rico");

        System.out.println("\n" + dessert1.getName() + ":");
        System.out.println("Promedio: " + String.format("%.1f", ratable2.getAverageRating()) + "⭐");

        // ========================================
        // 6. MÚLTIPLE IMPLEMENTACIÓN
        // ========================================

        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   MÚLTIPLE IMPLEMENTACIÓN                  ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        System.out.println("Dish5 implementa 4 interfaces:");
        System.out.println("- Preparable ✅");
        System.out.println("- Deliverable ✅");
        System.out.println("- Discountable ✅");
        System.out.println("- Ratable ✅");

        System.out.println("\nBeverage implementa 2 interfaces:");
        System.out.println("- Deliverable ✅");
        System.out.println("- Discountable ✅");

        System.out.println("\nDessert implementa 3 interfaces:");
        System.out.println("- Preparable ✅");
        System.out.println("- Deliverable ✅");
        System.out.println("- Ratable ✅");

        // ========================================
        // 7. DEMOSTRACIÓN DE POLIMORFISMO TOTAL
        // ========================================

        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   POLIMORFISMO TOTAL                       ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        System.out.println("Todos son Product, pero...\n");

        for (Product p : products) {
            System.out.println("✓ " + p.getName() + " (" + p.getClass().getSimpleName() + ")");

            // Verificar capacidades usando instanceof
            if (p instanceof Preparable) {
                System.out.println("  → Requiere preparación");
            }
            if (p instanceof Deliverable) {
                System.out.println("  → Puede ser entregado");
            }
            if (p instanceof Discountable) {
                System.out.println("  → Puede tener descuento");
            }
            if (p instanceof Ratable) {
                System.out.println("  → Puede ser calificado");
            }
            System.out.println();
        }

        // ========================================
        // RESUMEN
        // ========================================

        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║   RESUMEN                                  ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        System.out.println("✅ Clase Abstracta: Product");
        System.out.println("   - 3 métodos abstractos implementados");
        System.out.println("   - 3 subclases concretas (Dish5, Beverage, Dessert)");

        System.out.println("\n✅ Interfaces: 4 implementadas");
        System.out.println("   - Preparable (2 clases)");
        System.out.println("   - Deliverable (3 clases)");
        System.out.println("   - Discountable (2 clases)");
        System.out.println("   - Ratable (2 clases)");

        System.out.println("\n✅ Múltiple implementación demostrada");
        System.out.println("✅ Polimorfismo con clase abstracta");
        System.out.println("✅ Polimorfismo con interfaces");
        System.out.println("✅ Dynamic binding demostrado");

        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   ¡Abstracción e Interfaces completas!    ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
    }
}
