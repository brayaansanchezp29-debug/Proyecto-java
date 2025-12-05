/**
 * Programa Principal - Semana 02
 * Demuestra uso de clases, relaciones y ArrayList
 * Brayan Alejandro Sanchez Pedroza
 */
public class Main2 {
    public static void main(String[] args) {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   SISTEMA DE GESTIÓN - SABORES DEL VALLE  ║");
        System.out.println("║        Semana 02 - POO Avanzado            ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        // 1. CREAR RESTAURANTE (Clase gestora con ArrayList)
        Restaurant restaurant = new Restaurant("Sabores del Valle", "Fontibón, Bogotá");

        // 2. CREAR MESEROS (Ejercicio 1: Nuevas clases)
        Waiter waiter1 = new Waiter("Carlos Rodríguez", "M001", 5, "Mañana");
        Waiter waiter2 = new Waiter("María González", "M002", 2, "Tarde");
        Waiter waiter3 = new Waiter("Juan Pérez", "M003", 1, "Noche");

        // Agregar meseros al restaurante
        restaurant.addWaiter(waiter1);
        restaurant.addWaiter(waiter2);
        restaurant.addWaiter(waiter3);

        // 3. CREAR PLATOS DEL MENÚ
        Dish2 dish1 = new Dish2("Bandeja Paisa", "Plato Fuerte", 28000);
        Dish2 dish2 = new Dish2("Ajiaco Santafereño", "Sopa", 22000);
        Dish2 dish3 = new Dish2("Lechona Tolimense", "Plato Fuerte", 25000);
        Dish2 dish4 = new Dish2("Sancocho de Gallina", "Sopa", 20000);
        Dish2 dish5 = new Dish2("Arroz con Pollo", "Plato Fuerte", 18000);

        // Agregar platos al menú
        restaurant.addDishToMenu(dish1);
        restaurant.addDishToMenu(dish2);
        restaurant.addDishToMenu(dish3);
        restaurant.addDishToMenu(dish4);
        restaurant.addDishToMenu(dish5);

        // 4. CREAR PEDIDOS (Ejercicio 2: Relaciones entre objetos)
        Order order1 = new Order(waiter1, dish1, 5, 2);  // Mesa 5, 2 Bandejas Paisas
        Order order2 = new Order(waiter1, dish2, 5, 1);  // Mesa 5, 1 Ajiaco
        Order order3 = new Order(waiter2, dish3, 8, 3);  // Mesa 8, 3 Lechonas
        Order order4 = new Order(waiter3, dish4, 12, 2); // Mesa 12, 2 Sancochos
        Order order5 = new Order(waiter2, dish5, 3, 1);  // Mesa 3, 1 Arroz con Pollo

        // Agregar pedidos al restaurante (Ejercicio 3: Usar ArrayList)
        restaurant.addOrder(order1);
        restaurant.addOrder(order2);
        restaurant.addOrder(order3);
        restaurant.addOrder(order4);
        restaurant.addOrder(order5);

        // 5. MOSTRAR INFORMACIÓN (Ejercicio 4: Main completo)

        // Mostrar personal
        restaurant.showAllWaiters();

        // Mostrar menú
        restaurant.showMenu();

        // Mostrar pedidos
        restaurant.showAllOrders();

        // Mostrar un pedido específico con detalle
        System.out.println("\n--- DETALLE DE PEDIDO ESPECÍFICO ---");
        order1.showInfo();

        // Mostrar estadísticas
        restaurant.showStatistics();

        // Ejemplo de método de negocio: Aplicar descuento
        System.out.println("\n--- EJEMPLO: DESCUENTO DEL 15% ---");
        System.out.println("Plato: " + dish1.getName());
        System.out.println("Precio normal: $" + String.format("%.0f", dish1.getPrice()));
        System.out.println("Precio con descuento: $" + String.format("%.0f", dish1.calculateDiscountPrice(15)));

        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   ¡Gracias por usar el sistema!           ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
    }
}
