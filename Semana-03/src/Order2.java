/**
 * Clase Pedido - Semana 03 con Encapsulación Completa
 * @author Brayan Alejandro Sanchez Pedroza
 * @version 3.0 - Encapsulación y Constructores Sobrecargados
 */
public class Order2 {
    // ====== ATRIBUTO ESTÁTICO ======
    private static int orderCounter = 1;

    // ====== ATRIBUTOS PRIVADOS ======
    private int orderNumber;
    private Waiter2 waiter;
    private Dish3 dish;
    private int tableNumber;
    private int quantity;
    private String status;
    private String specialInstructions;

    // ====== CONSTRUCTORES SOBRECARGADOS ======

    /**
     * Constructor completo con instrucciones especiales
     */
    public Order2(Waiter2 waiter, Dish3 dish, int tableNumber, int quantity, String specialInstructions) {
        this.orderNumber = orderCounter++;
        setWaiter(waiter);
        setDish(dish);
        setTableNumber(tableNumber);
        setQuantity(quantity);
        this.status = "Pendiente";
        setSpecialInstructions(specialInstructions);
    }

    /**
     * Constructor sin instrucciones especiales
     */
    public Order2(Waiter2 waiter, Dish3 dish, int tableNumber, int quantity) {
        this(waiter, dish, tableNumber, quantity, "Sin instrucciones");
    }

    /**
     * Constructor con cantidad por defecto (1 unidad)
     */
    public Order2(Waiter2 waiter, Dish3 dish, int tableNumber) {
        this(waiter, dish, tableNumber, 1, "Sin instrucciones");
    }

    // ====== GETTERS ======

    public int getOrderNumber() {
        return orderNumber;
    }

    public Waiter2 getWaiter() {
        return waiter;
    }

    public Dish3 getDish() {
        return dish;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    // ====== SETTERS CON VALIDACIONES ======

    public void setWaiter(Waiter2 waiter) {
        if (waiter == null) {
            throw new IllegalArgumentException("Mesero no puede ser nulo");
        }
        if (!waiter.isActive()) {
            throw new IllegalArgumentException("Mesero no está activo");
        }
        this.waiter = waiter;
    }

    public void setDish(Dish3 dish) {
        if (dish == null) {
            throw new IllegalArgumentException("Plato no puede ser nulo");
        }
        if (!dish.isAvailable()) {
            throw new IllegalArgumentException("Plato no disponible: " + dish.getName());
        }
        this.dish = dish;
    }

    public void setTableNumber(int tableNumber) {
        if (!isValidTableNumber(tableNumber)) {
            throw new IllegalArgumentException("Número de mesa inválido. Debe estar entre 1 y 50");
        }
        this.tableNumber = tableNumber;
    }

    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Cantidad debe ser mayor a 0");
        }
        if (quantity > 20) {
            throw new IllegalArgumentException("Cantidad no puede exceder 20 unidades por pedido");
        }
        this.quantity = quantity;
    }

    public void setStatus(String status) {
        if (!isValidString(status)) {
            throw new IllegalArgumentException("Estado no puede estar vacío");
        }
        if (!isValidStatus(status)) {
            throw new IllegalArgumentException("Estado inválido. Use: Pendiente, En preparación, Listo, Entregado, Cancelado");
        }
        this.status = status;
    }

    public void setSpecialInstructions(String specialInstructions) {
        if (specialInstructions == null) {
            this.specialInstructions = "Sin instrucciones";
        } else {
            this.specialInstructions = specialInstructions;
        }
    }

    // ====== MÉTODOS PRIVADOS AUXILIARES ======

    private boolean isValidString(String str) {
        return str != null && !str.trim().isEmpty();
    }

    /**
     * Valida número de mesa (1-50 en el restaurante)
     */
    private boolean isValidTableNumber(int table) {
        return table >= 1 && table <= 50;
    }

    /**
     * Valida estado del pedido
     */
    private boolean isValidStatus(String status) {
        String[] validStatuses = {"Pendiente", "En preparación", "Listo", "Entregado", "Cancelado"};
        for (String valid : validStatuses) {
            if (valid.equalsIgnoreCase(status)) {
                return true;
            }
        }
        return false;
    }

    private String formatPrice(double price) {
        return String.format("$%,.0f", price);
    }

    // ====== MÉTODOS DE NEGOCIO ======

    /**
     * Calcula total del pedido
     */
    public double calculateTotal() {
        return dish.getPrice() * quantity;
    }

    /**
     * Calcula total con descuento
     */
    public double calculateTotalWithDiscount(double discountPercentage) {
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Descuento debe estar entre 0 y 100");
        }
        double total = calculateTotal();
        return total - (total * discountPercentage / 100);
    }

    /**
     * Calcula propina sugerida (10%)
     */
    public double calculateSuggestedTip() {
        return calculateTotal() * 0.10;
    }

    /**
     * Verifica si es un pedido grande
     */
    public boolean isLargeOrder() {
        return quantity >= 5;
    }

    /**
     * Verifica si el pedido está completado
     */
    public boolean isCompleted() {
        return status.equalsIgnoreCase("Entregado");
    }

    /**
     * Avanza el estado del pedido
     */
    public void advanceStatus() {
        switch (status) {
            case "Pendiente":
                setStatus("En preparación");
                break;
            case "En preparación":
                setStatus("Listo");
                break;
            case "Listo":
                setStatus("Entregado");
                break;
            default:
                System.out.println("Pedido ya completado o cancelado");
        }
    }

    /**
     * Retorna resumen del pedido
     */
    public String getOrderSummary() {
        return "Pedido #" + orderNumber +
                " - Mesa " + tableNumber +
                " - " + dish.getName() +
                " x" + quantity +
                " - Total: " + formatPrice(calculateTotal()) +
                " - Mesero: " + waiter.getName() +
                " - Estado: " + status;
    }

    /**
     * Muestra información detallada
     */
    public void showInfo() {
        System.out.println("\n=== PEDIDO #" + orderNumber + " ===");
        System.out.println("Mesa: " + tableNumber);
        System.out.println("Plato: " + dish.getName());
        System.out.println("Cantidad: " + quantity);
        System.out.println("Precio unitario: " + formatPrice(dish.getPrice()));
        System.out.println("Subtotal: " + formatPrice(calculateTotal()));
        System.out.println("Propina sugerida (10%): " + formatPrice(calculateSuggestedTip()));
        System.out.println("Mesero: " + waiter.getName());
        System.out.println("Estado: " + status);
        if (!specialInstructions.equals("Sin instrucciones")) {
            System.out.println("Instrucciones: " + specialInstructions);
        }
        System.out.println("Tipo: " + (isLargeOrder() ? "Pedido Grande" : "Pedido Normal"));
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", dish=" + dish.getName() +
                ", quantity=" + quantity +
                ", status='" + status + '\'' +
                '}';
    }
}
