package com.restaurante.modelo;

import com.restaurante.excepciones.InvalidOrderException;
import com.restaurante.excepciones.TableNotAvailableException;

/**
 * Clase modelo: Pedido del restaurante
 */
public class Order3 {
    private static int orderCounter = 1;

    private String orderCode;
    private int tableNumber;
    private Dish6 dish;
    private int quantity;
    private String customerName;
    private String status;

    // ====== CONSTRUCTOR ======

    /**
     * Constructor con validaciones
     * @throws InvalidOrderException Si los datos son inválidos
     * @throws TableNotAvailableException Si la mesa es inválida
     */
    public Order3(int tableNumber, Dish6 dish, int quantity, String customerName)
            throws InvalidOrderException, TableNotAvailableException {
        this.orderCode = "ORD" + String.format("%03d", orderCounter++);
        setTableNumber(tableNumber);
        setDish(dish);
        setQuantity(quantity);
        setCustomerName(customerName);
        this.status = "Pendiente";
    }

    // ====== VALIDACIONES ======

    /**
     * Valida número de mesa
     * @throws TableNotAvailableException Si el número es inválido
     */
    public void setTableNumber(int tableNumber) throws TableNotAvailableException {
        if (tableNumber < 1 || tableNumber > 50) {
            throw new TableNotAvailableException(
                    "Número de mesa inválido: " + tableNumber +
                            ". Debe estar entre 1 y 50"
            );
        }
        this.tableNumber = tableNumber;
    }

    /**
     * Valida plato
     * @throws InvalidOrderException Si el plato es nulo
     */
    public void setDish(Dish6 dish) throws InvalidOrderException {
        if (dish == null) {
            throw new InvalidOrderException("El pedido debe tener un plato asociado");
        }
        this.dish = dish;
    }

    /**
     * Valida cantidad
     * @throws InvalidOrderException Si la cantidad es inválida
     */
    public void setQuantity(int quantity) throws InvalidOrderException {
        if (quantity <= 0) {
            throw new InvalidOrderException(
                    "Cantidad debe ser mayor a 0. Recibido: " + quantity
            );
        }
        if (quantity > 20) {
            throw new InvalidOrderException(
                    "Cantidad no puede exceder 20 unidades por pedido. Recibido: " + quantity
            );
        }
        this.quantity = quantity;
    }

    /**
     * Valida nombre del cliente
     * @throws InvalidOrderException Si el nombre es inválido
     */
    public void setCustomerName(String customerName) throws InvalidOrderException {
        if (customerName == null || customerName.trim().isEmpty()) {
            throw new InvalidOrderException("Nombre del cliente no puede estar vacío");
        }
        if (customerName.length() < 3) {
            throw new InvalidOrderException(
                    "Nombre del cliente debe tener al menos 3 caracteres"
            );
        }
        this.customerName = customerName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // ====== MÉTODOS DE NEGOCIO ======

    /**
     * Calcula el total del pedido
     */
    public double calculateTotal() {
        return dish.getPrice() * quantity;
    }

    /**
     * Muestra información del pedido
     */
    public void showInfo() {
        System.out.println("\n=== PEDIDO " + orderCode + " ===");
        System.out.println("Mesa: " + tableNumber);
        System.out.println("Cliente: " + customerName);
        System.out.println("Plato: " + dish.getName());
        System.out.println("Cantidad: " + quantity);
        System.out.println("Total: $" + String.format("%,.0f", calculateTotal()));
        System.out.println("Estado: " + status);
    }

    // ====== GETTERS ======

    public String getOrderCode() { return orderCode; }
    public int getTableNumber() { return tableNumber; }
    public Dish6 getDish() { return dish; }
    public int getQuantity() { return quantity; }
    public String getCustomerName() { return customerName; }
    public String getStatus() { return status; }

    @Override
    public String toString() {
        return "Order3{" +
                "orderCode='" + orderCode + '\'' +
                ", tableNumber=" + tableNumber +
                ", dish=" + dish.getName() +
                ", quantity=" + quantity +
                '}';
    }
}
