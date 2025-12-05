import java.util.ArrayList;

/**
 * Clase Restaurante - Semana 03 con Encapsulación Completa
 * @author Brayan Alejandro Sanchez Pedroza
 * @version 3.0 - Encapsulación y Constructores Sobrecargados
 */
public class Restaurant2 {
    // ====== ATRIBUTOS PRIVADOS ======
    private String name;
    private String location;
    private int capacity;
    private ArrayList<Order2> orders;
    private ArrayList<Waiter2> waiters;
    private ArrayList<Dish3> menu;

    // ====== CONSTRUCTORES SOBRECARGADOS ======

    /**
     * Constructor completo con capacidad
     */
    public Restaurant2(String name, String location, int capacity) {
        setName(name);
        setLocation(location);
        setCapacity(capacity);
        this.orders = new ArrayList<>();
        this.waiters = new ArrayList<>();
        this.menu = new ArrayList<>();
    }

    /**
     * Constructor sin capacidad (80 personas por defecto)
     */
    public Restaurant2(String name, String location) {
        this(name, location, 80);
    }

    /**
     * Constructor mínimo (ubicación genérica)
     */
    public Restaurant2(String name) {
        this(name, "Bogotá, Colombia", 80);
    }

    // ====== GETTERS ======

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getCapacity() {
        return capacity;
    }

    public ArrayList<Order2> getOrders() {
        return new ArrayList<>(orders); // Retorna copia para proteger encapsulación
    }

    public ArrayList<Waiter2> getWaiters() {
        return new ArrayList<>(waiters);
    }

    public ArrayList<Dish3> getMenu() {
        return new ArrayList<>(menu);
    }

    // ====== SETTERS CON VALIDACIONES ======

    public void setName(String name) {
        if (!isValidString(name)) {
            throw new IllegalArgumentException("Nombre del restaurante no puede estar vacío");
        }
        if (name.length() < 3) {
            throw new IllegalArgumentException("Nombre debe tener al menos 3 caracteres");
        }
        this.name = name;
    }

    public void setLocation(String location) {
        if (!isValidString(location)) {
            throw new IllegalArgumentException("Ubicación no puede estar vacía");
        }
        this.location = location;
    }

    public void setCapacity(int capacity) {
        if (capacity < 10) {
            throw new IllegalArgumentException("Capacidad mínima es de 10 personas");
        }
        if (capacity > 500) {
            throw new IllegalArgumentException("Capacidad máxima es de 500 personas");
        }
        this.capacity = capacity;
    }

    // ====== MÉTODOS PRIVADOS AUXILIARES ======

    private boolean isValidString(String str) {
        return str != null && !str.trim().isEmpty();
    }

    private String formatMoney(double amount) {
        return String.format("$%,.0f", amount);
    }

    /**
     * Busca mesero por ID
     */
    private Waiter2 findWaiterById(String id) {
        for (Waiter2 waiter : waiters) {
            if (waiter.getId().equals(id)) {
                return waiter;
            }
        }
        return null;
    }

    /**
     * Busca plato por nombre
     */
    private Dish3 findDishByName(String name) {
        for (Dish3 dish : menu) {
            if (dish.getName().equalsIgnoreCase(name)) {
                return dish;
            }
        }
        return null;
    }

    // ====== MÉTODOS PÚBLICOS - MESEROS ======

    public void addWaiter(Waiter2 waiter) {
        if (waiter == null) {
            throw new IllegalArgumentException("Mesero no puede ser nulo");
        }
        // Validar que no exista ID duplicado
        if (findWaiterById(waiter.getId()) != null) {
            throw new IllegalArgumentException("Ya existe un mesero con ID: " + waiter.getId());
        }
        waiters.add(waiter);
        System.out.println("✅ Mesero agregado: " + waiter.getName());
    }

    public void removeWaiter(String waiterId) {
        Waiter2 waiter = findWaiterById(waiterId);
        if (waiter == null) {
            throw new IllegalArgumentException("Mesero no encontrado: " + waiterId);
        }
        waiters.remove(waiter);
        System.out.println("❌ Mesero removido: " + waiter.getName());
    }

    public void showAllWaiters() {
        if (waiters.isEmpty()) {
            System.out.println("No hay meseros registrados");
            return;
        }
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║        PERSONAL DEL RESTAURANTE            ║");
        System.out.println("╚════════════════════════════════════════════╝");
        for (Waiter2 waiter : waiters) {
            waiter.showInfo();
            System.out.println();
        }
    }

    // ====== MÉTODOS PÚBLICOS - MENÚ ======

    public void addDishToMenu(Dish3 dish) {
        if (dish == null) {
            throw new IllegalArgumentException("Plato no puede ser nulo");
        }
        // Validar que no exista plato duplicado
        if (findDishByName(dish.getName()) != null) {
            throw new IllegalArgumentException("Ya existe un plato con nombre: " + dish.getName());
        }
        menu.add(dish);
        System.out.println("✅ Plato agregado al menú: " + dish.getName());
    }

    public void removeDishFromMenu(String dishName) {
        Dish3 dish = findDishByName(dishName);
        if (dish == null) {
            throw new IllegalArgumentException("Plato no encontrado: " + dishName);
        }
        menu.remove(dish);
        System.out.println("❌ Plato removido del menú: " + dishName);
    }

    public void showMenu() {
        if (menu.isEmpty()) {
            System.out.println("Menú vacío");
            return;
        }
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║          MENÚ - " + name.toUpperCase());
        System.out.println("╚════════════════════════════════════════════╝");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println("\n" + (i + 1) + ". ");
            menu.get(i).showInfo();
        }
    }

    // ====== MÉTODOS PÚBLICOS - PEDIDOS ======

    public void addOrder(Order2 order) {
        if (order == null) {
            throw new IllegalArgumentException("Pedido no puede ser nulo");
        }
        orders.add(order);
        System.out.println("✅ Pedido registrado: #" + order.getOrderNumber());
    }

    public void showAllOrders() {
        if (orders.isEmpty()) {
            System.out.println("No hay pedidos registrados");
            return;
        }
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║           PEDIDOS DEL DÍA                  ║");
        System.out.println("╚════════════════════════════════════════════╝");
        for (Order2 order : orders) {
            System.out.println(order.getOrderSummary());
        }
    }

    public int countOrders() {
        return orders.size();
    }

    public int countPendingOrders() {
        int count = 0;
        for (Order2 order : orders) {
            if (order.getStatus().equalsIgnoreCase("Pendiente")) {
                count++;
            }
        }
        return count;
    }

    // ====== MÉTODOS DE NEGOCIO ======

    public double calculateTotalSales() {
        double total = 0;
        for (Order2 order : orders) {
            if (order.isCompleted()) {
                total += order.calculateTotal();
            }
        }
        return total;
    }

    public double calculateAverageOrderValue() {
        if (orders.isEmpty()) {
            return 0;
        }
        return calculateTotalSales() / orders.size();
    }

    public Dish3 getMostExpensiveDish() {
        if (menu.isEmpty()) {
            return null;
        }
        Dish3 mostExpensive = menu.get(0);
        for (Dish3 dish : menu) {
            if (dish.getPrice() > mostExpensive.getPrice()) {
                mostExpensive = dish;
            }
        }
        return mostExpensive;
    }

    public void showStatistics() {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║           ESTADÍSTICAS DEL DÍA             ║");
        System.out.println("╚════════════════════════════════════════════╝");
        System.out.println("Restaurante: " + name);
        System.out.println("Ubicación: " + location);
        System.out.println("Capacidad: " + capacity + " personas");
        System.out.println("\n--- Personal ---");
        System.out.println("Total de meseros: " + waiters.size());
        System.out.println("\n--- Menú ---");
        System.out.println("Platos en menú: " + menu.size());
        if (!menu.isEmpty()) {
            Dish3 mostExpensive = getMostExpensiveDish();
            System.out.println("Plato más caro: " + mostExpensive.getName() +
                    " - " + formatMoney(mostExpensive.getPrice()));
        }
        System.out.println("\n--- Pedidos ---");
        System.out.println("Total de pedidos: " + countOrders());
        System.out.println("Pedidos pendientes: " + countPendingOrders());
        System.out.println("Ventas totales: " + formatMoney(calculateTotalSales()));
        if (countOrders() > 0) {
            System.out.println("Valor promedio por pedido: " + formatMoney(calculateAverageOrderValue()));
        }
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
