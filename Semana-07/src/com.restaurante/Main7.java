package com.restaurante;

import com.restaurante.modelo.*;
import com.restaurante.Servicio.*;
import com.restaurante.excepciones.*;

public class Main7 {
    public static void main(String[] args) {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   SISTEMA - SABORES DEL VALLE              ║");
        System.out.println("║   Semana 07 - Paquetes y Excepciones       ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        OrderManager manager = new OrderManager();

        // ========================================
        // CASO 1: Pedido válido ✅
        // ========================================
        System.out.println("--- CASO 1: Pedido Válido ---");
        try {
            Dish6 dish1 = new Dish6("D001", "Bandeja Paisa", "Plato Fuerte", 28000, 10);
            manager.createOrder(5, dish1, 2, "Juan Pérez");
        } catch (InvalidOrderException | TableNotAvailableException | DishNotAvailableException e) {
            System.err.println("❌ Error: " + e.getMessage());
        }

        // ========================================
        // CASO 2: Código de plato inválido ❌
        // ========================================
        System.out.println("\n--- CASO 2: Código Inválido ---");
        try {
            Dish6 dish2 = new Dish6("ABC", "Ajiaco", "Sopa", 22000, 5);
        } catch (IllegalArgumentException e) {
            System.err.println("❌ Error validación: " + e.getMessage());
        }

        // ========================================
        // CASO 3: Precio negativo ❌
        // ========================================
        System.out.println("\n--- CASO 3: Precio Negativo ---");
        try {
            Dish6 dish3 = new Dish6("D002", "Sancocho", "Sopa", -5000, 3);
        } catch (IllegalArgumentException e) {
            System.err.println("❌ Error validación: " + e.getMessage());
        }

        // ========================================
        // CASO 4: Plato agotado ❌
        // ========================================
        System.out.println("\n--- CASO 4: Plato Agotado ---");
        try {
            Dish6 dish4 = new Dish6("D003", "Lechona", "Plato Fuerte", 25000, 0);
            manager.createOrder(3, dish4, 1, "María López");
        } catch (DishNotAvailableException e) {
            System.err.println("❌ Plato agotado: " + e.getMessage());
        } catch (InvalidOrderException | TableNotAvailableException e) {
            System.err.println("❌ Error: " + e.getMessage());
        }

        // ========================================
        // CASO 5: Mesa inválida ❌
        // ========================================
        System.out.println("\n--- CASO 5: Mesa Inválida ---");
        try {
            Dish6 dish5 = new Dish6("D004", "Arroz con Pollo", "Plato Fuerte", 18000, 8);
            manager.createOrder(100, dish5, 1, "Carlos Gómez");
        } catch (TableNotAvailableException e) {
            System.err.println("❌ Mesa inválida: " + e.getMessage());
        } catch (InvalidOrderException | DishNotAvailableException e) {
            System.err.println("❌ Error: " + e.getMessage());
        }

        // ========================================
        // CASO 6: Cantidad inválida ❌
        // ========================================
        System.out.println("\n--- CASO 6: Cantidad Excesiva ---");
        try {
            Dish6 dish6 = new Dish6("D005", "Tamal", "Entrada", 8000, 50);
            manager.createOrder(8, dish6, 25, "Ana Martínez");
        } catch (InvalidOrderException e) {
            System.err.println("❌ Cantidad inválida: " + e.getMessage());
        } catch (TableNotAvailableException | DishNotAvailableException e) {
            System.err.println("❌ Error: " + e.getMessage());
        }

        // ========================================
        // RESUMEN
        // ========================================
        manager.showAllOrders();

        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   RESUMEN SEMANA 07                        ║");
        System.out.println("╚════════════════════════════════════════════╝");
        System.out.println("✅ Paquetes organizados (modelo, servicio, excepciones)");
        System.out.println("✅ 3 excepciones personalizadas");
        System.out.println("✅ Validaciones con excepciones");
        System.out.println("✅ 6 casos de prueba demostrados");
        System.out.println("✅ Manejo con try-catch\n");
    }
}
