/**
 * Programa Principal - Semana 03
 * Demuestra encapsulación, sobrecarga de constructores y validaciones
 */
public class Main3 {
    public static void main(String[] args) {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   SISTEMA DE GESTIÓN - SABORES DEL VALLE  ║");
        System.out.println("║   Semana 03 - Encapsulación Completa      ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        // ========================================
        // DEMOSTRACIÓN DE CONSTRUCTORES SOBRECARGADOS
        // ========================================

        System.out.println("=== DEMOSTRANDO SOBRECARGA DE CONSTRUCTORES ===\n");

        // 1. RESTAURANTE - 3 constructores diferentes
        Restaurant2 restaurant1 = new Restaurant2("Sabores del Valle", "Fontibón, Bogotá", 100);
        Restaurant2 restaurant2 = new Restaurant2("Sabores del Valle", "Fontibón, Bogotá");
        Restaurant2 restaurant3 = new Restaurant2("Sabores del Valle");

        System.out.println("Restaurant creado con 3 constructores diferentes:");
        System.out.println("1. Completo: " + restaurant1);
        System.out.println("2. Sin capacidad: " + restaurant2);
        System.out.println("3. Mínimo: " + restaurant3);

        // Usaremos restaurant1 para el resto del programa
        Restaurant2 restaurant = restaurant1;

        // 2. PLATOS - 4 constructores diferentes
        System.out.println("\n=== PLATOS CON DIFERENTES CONSTRUCTORES ===");
        Dish3 dish1 = new Dish3("Bandeja Paisa", "Plato Fuerte", 28000, true, 30);
        Dish3 dish2 = new Dish3("Ajiaco Santafereño", "Sopa", 22000, true);
        Dish3 dish3 = new Dish3("Lechona Tolimense", "Plato Fuerte", 25000);
        Dish3 dish4 = new Dish3("Sancocho", "Sopa");

        System.out.println("✅ 4 platos creados con diferentes constructores");

        // 3. MESEROS - 4 constructores diferentes
        System.out.println("\n=== MESEROS CON DIFERENTES CONSTRUCTORES ===");
        Waiter2 waiter1 = new Waiter2("Carlos Rodríguez", "M001", 5, "Mañana", 1950000, true);
        Waiter2 waiter2 = new Waiter2("María González", "M002", 2, "Tarde", true);
        Waiter2 waiter3 = new Waiter2("Juan Pérez", "M003", 1, "Noche");
        Waiter2 waiter4 = new Waiter2("Ana López", "M004", 3);

        System.out.println("✅ 4 meseros creados con diferentes constructores");

        // Agregar al restaurante
        restaurant.addWaiter(waiter1);
        restaurant.addWaiter(waiter2);
        restaurant.addWaiter(waiter3);
        restaurant.addWaiter(waiter4);

        restaurant.addDishToMenu(dish1);
        restaurant.addDishToMenu(dish2);
        restaurant.addDishToMenu(dish3);
        restaurant.addDishToMenu(dish4);

        // 4. PEDIDOS - 3 constructores diferentes
        System.out.println("\n=== PEDIDOS CON DIFERENTES CONSTRUCTORES ===");
        Order2 order1 = new Order2(waiter1, dish1, 5, 2, "Sin cebolla");
        Order2 order2 = new Order2(waiter2, dish2, 8, 1);
        Order2 order3 = new Order2(waiter3, dish3, 12);

        restaurant.addOrder(order1);
        restaurant.addOrder(order2);
        restaurant.addOrder(order3);

        // ========================================
        // DEMOSTRACIÓN DE ENCAPSULACIÓN Y VALIDACIONES
        // ========================================

        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   DEMOSTRANDO VALIDACIONES                 ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        // Validaciones exitosas
        System.out.println("--- Modificaciones Válidas ---");
        try {
            dish1.setPrice(30000);
            System.out.println("✅ Precio de Bandeja Paisa actualizado a $30,000");

            waiter1.setShift("Tarde");
            System.out.println("✅ Turno de Carlos actualizado a 'Tarde'");

            order1.setQuantity(3);
            System.out.println("✅ Cantidad del pedido #1 actualizada a 3");

        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }

        // Validaciones que fallan
        System.out.println("\n--- Validaciones que Previenen Errores ---");

        try {
            Dish3 invalidDish = new Dish3("X", "Plato Fuerte", 10000);
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Validación correcta: " + e.getMessage());
        }

        try {
            dish1.setPrice(-5000);
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Validación correcta: " + e.getMessage());
        }

        try {
            order1.setQuantity(25);
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Validación correcta: " + e.getMessage());
        }

        try {
            Waiter2 invalidWaiter = new Waiter2("Juan", "X123", 2, "Mañana");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Validación correcta: " + e.getMessage());
        }

        // ========================================
        // MÉTODOS DE NEGOCIO
        // ========================================

        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   MÉTODOS DE NEGOCIO                       ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        // Plato
        System.out.println("--- Métodos de Dish ---");
        System.out.println("Precio con 15% descuento: $" +
                String.format("%.0f", dish1.calculateDiscountPrice(15)));
        System.out.println("¿Es económico? " + (dish1.isEconomical() ? "Sí" : "No"));
        System.out.println("¿Preparación rápida? " + (dish1.isQuickPreparation() ? "Sí" : "No"));

        // Mesero
        System.out.println("\n--- Métodos de Waiter ---");
        System.out.println("Nivel de experiencia: " + waiter1.getExperienceLevel());
        System.out.println("Salario total con propinas: $" +
                String.format("%.0f", waiter1.calculateTotalSalary(150000)));
        System.out.println("¿Elegible para bono? " + (waiter1.isEligibleForBonus() ? "Sí" : "No"));

        // Pedido
        System.out.println("\n--- Métodos de Order ---");
        System.out.println("Total del pedido: $" + String.format("%.0f", order1.calculateTotal()));
        System.out.println("Con 10% descuento: $" +
                String.format("%.0f", order1.calculateTotalWithDiscount(10)));
        System.out.println("Propina sugerida: $" +
                String.format("%.0f", order1.calculateSuggestedTip()));
        System.out.println("¿Es pedido grande? " + (order1.isLargeOrder() ? "Sí" : "No"));

        // ========================================
        // INFORMACIÓN COMPLETA DEL SISTEMA
        // ========================================

        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   INFORMACIÓN DEL SISTEMA                  ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        restaurant.showAllWaiters();
        restaurant.showMenu();
        restaurant.showAllOrders();

        System.out.println("\n--- DETALLE DE UN PEDIDO ---");
        order1.showInfo();

        restaurant.showStatistics();

        // ========================================
        // DEMOSTRACIÓN DE ENCAPSULACIÓN
        // ========================================

        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   VENTAJAS DE LA ENCAPSULACIÓN             ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        System.out.println("✅ Todos los atributos son privados");
        System.out.println("✅ Acceso controlado mediante getters/setters");
        System.out.println("✅ Validaciones previenen datos inválidos");
        System.out.println("✅ Métodos auxiliares privados ocultan lógica interna");
        System.out.println("✅ Sobrecarga de constructores facilita creación de objetos");
        System.out.println("✅ Código más mantenible y seguro");

        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   ¡Sistema completamente encapsulado!      ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
    }
}