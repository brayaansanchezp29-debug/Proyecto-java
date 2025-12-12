import java.util.ArrayList;

/**
 * Clase Gestora - Maneja el restaurante con ArrayList
 */
public class Restaurant {
    private String name;
    private String location;
    private ArrayList<Order> orders;        // ArrayList de pedidos
    private ArrayList<Waiter> waiters;      // ArrayList de meseros
    private ArrayList<Dish2> menu;           // ArrayList de platos

    public Restaurant(String name, String location) {
        this.name = name;
        this.location = location;
        this.orders = new ArrayList<>();
        this.waiters = new ArrayList<>();
        this.menu = new ArrayList<>();
    }

    // Métodos para Meseros
    public void addWaiter(Waiter waiter) {
        waiters.add(waiter);
        System.out.println("✅ Mesero agregado: " + waiter.getName());
    }

    public void showAllWaiters() {
        System.out.println("\n=== PERSONAL DEL RESTAURANTE ===");
        for (Waiter waiter : waiters) {
            waiter.showInfo();
            System.out.println();
        }
    }

    // Métodos para Menú
    public void addDishToMenu(Dish2 dish) {
        menu.add(dish);
        System.out.println("✅ Plato agregado al menú: " + dish.getName());
    }

    public void showMenu() {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║          MENÚ - " + name.toUpperCase() + "         ║");
        System.out.println("╚════════════════════════════════════════════╝");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println("\n" + (i + 1) + ". ");
            menu.get(i).showInfo();
        }
    }

    // Métodos para Pedidos
    public void addOrder(Order order) {
        orders.add(order);
        System.out.println("✅ Pedido registrado: #" + order.getOrderNumber());
    }

    public void showAllOrders() {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║           PEDIDOS DEL DÍA                  ║");
        System.out.println("╚════════════════════════════════════════════╝");
        for (Order order : orders) {
            System.out.println(order.getOrderSummary());
        }
    }

    public int countOrders() {
        return orders.size();
    }

    public double calculateTotalSales() {
        double total = 0;
        for (Order order : orders) {
            total += order.calculateTotal();
        }
        return total;
    }

    public void showStatistics() {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║           ESTADÍSTICAS DEL DÍA             ║");
        System.out.println("╚════════════════════════════════════════════╝");
        System.out.println("Total de pedidos: " + countOrders());
        System.out.println("Total de meseros: " + waiters.size());
        System.out.println("Platos en menú: " + menu.size());
        System.out.println("Ventas totales: $" + String.format("%.0f", calculateTotalSales()));
    }

    // Getters
    public String getName() { return name; }
    public String getLocation() { return location; }
    public ArrayList<Order> getOrders() { return orders; }
    public ArrayList<Waiter> getWaiters() { return waiters; }
    public ArrayList<Dish2> getMenu() { return menu; }
}
