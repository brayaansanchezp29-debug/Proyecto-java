/**
 * Clase Pedido - Relación entre Mesero y Plato
 * @author Brayan Alejandro Sanchez Pedroza
 */
public class Order {
    private static int orderCounter = 1; // Contador estático

    private int orderNumber;
    private Waiter waiter;      // Relación con Mesero
    private Dish2 dish;          // Relación con Plato
    private int tableNumber;
    private int quantity;
    private String status;      // Pendiente, En preparación, Listo, Entregado

    public Order(Waiter waiter, Dish2 dish, int tableNumber, int quantity) {
        this.orderNumber = orderCounter++;
        this.waiter = waiter;
        this.dish = dish;
        this.tableNumber = tableNumber;
        this.quantity = quantity;
        this.status = "Pendiente";
    }

    // Método de negocio
    public double calculateTotal() {
        return dish.getPrice() * quantity;
    }

    public String getOrderSummary() {
        return "Pedido #" + orderNumber +
                " - Mesa " + tableNumber +
                " - " + dish.getName() +
                " x" + quantity +
                " - Total: $" + String.format("%.0f", calculateTotal()) +
                " - Mesero: " + waiter.getName() +
                " - Estado: " + status;
    }

    public void showInfo() {
        System.out.println("\n=== PEDIDO #" + orderNumber + " ===");
        System.out.println("Mesa: " + tableNumber);
        System.out.println("Plato: " + dish.getName());
        System.out.println("Cantidad: " + quantity);
        System.out.println("Precio unitario: $" + String.format("%.0f", dish.getPrice()));
        System.out.println("Total: $" + String.format("%.0f", calculateTotal()));
        System.out.println("Mesero: " + waiter.getName());
        System.out.println("Estado: " + status);
    }

    // Getters y Setters
    public int getOrderNumber() { return orderNumber; }

    public Waiter getWaiter() { return waiter; }
    public void setWaiter(Waiter waiter) { this.waiter = waiter; }

    public Dish2 getDish() { return dish; }
    public void setDish(Dish2 dish) { this.dish = dish; }

    public int getTableNumber() { return tableNumber; }
    public void setTableNumber(int tableNumber) { this.tableNumber = tableNumber; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}