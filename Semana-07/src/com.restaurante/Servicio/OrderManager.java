package com.restaurante.Servicio;

import com.restaurante.modelo.*;
import com.restaurante.excepciones.*;
import java.util.ArrayList;

/**
 * Gestor de pedidos del restaurante
 */
public class OrderManager {
    private ArrayList<Order3> orders = new ArrayList<>();

    /**
     * Crea un nuevo pedido con validaciones
     * @throws InvalidOrderException, TableNotAvailableException, DishNotAvailableException
     */
    public void createOrder(int tableNumber, Dish6 dish, int quantity, String customerName)
            throws InvalidOrderException, TableNotAvailableException, DishNotAvailableException {

        // Verificar disponibilidad del plato
        dish.checkAvailability();

        // Crear pedido
        Order3 order = new Order3(tableNumber, dish, quantity, customerName);

        // Reducir stock
        dish.reduceStock(quantity);

        // Agregar a lista
        orders.add(order);
        System.out.println("✅ Pedido creado: " + order.getOrderCode());
    }

    public ArrayList<Order3> getOrders() {
        return orders;
    }

    public void showAllOrders() {
        System.out.println("\n=== PEDIDOS DEL DÍA ===");
        for (Order3 order : orders) {
            order.showInfo();
        }
    }
}
