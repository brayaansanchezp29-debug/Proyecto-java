package com.restaurante;

import com.restaurante.modelo.Dish7;
import com.restaurante.servicio.RestaurantManager2;
import com.restaurante.excepciones.*;
import java.util.*;

/**
 * Programa Principal - Semana 08
 */
public class Main8 {
    private static Scanner scanner = new Scanner(System.in);
    private static RestaurantManager2 manager = new RestaurantManager2();

    public static void main(String[] args) {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   SISTEMA - SABORES DEL VALLE              ║");
        System.out.println("║   Semana 08 - Colecciones y Generics       ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        // Cargar datos de prueba
        loadSampleData();

        int option;
        do {
            showMenu();
            option = getIntInput("Seleccione una opción: ");

            switch (option) {
                case 1: addDish(); break;
                case 2: searchByCode(); break;
                case 3: searchByName(); break;
                case 4: showByCategory(); break;
                case 5: filterByPrice(); break;
                case 6: showAvailable(); break;
                case 7: manager.showAllDishes(); break;
                case 8: manager.showStatistics(); break;
                case 9: removeDish(); break;
                case 0: System.out.println("\n¡Hasta luego!"); break;
                default: System.out.println("❌ Opción inválida");
            }
        } while (option != 0);

        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\n═══════════ MENÚ PRINCIPAL ═══════════");
        System.out.println("1. Agregar plato");
        System.out.println("2. Buscar por código");
        System.out.println("3. Buscar por nombre");
        System.out.println("4. Ver por categoría");
        System.out.println("5. Filtrar por precio");
        System.out.println("6. Ver disponibles");
        System.out.println("7. Listar todos");
        System.out.println("8. Ver estadísticas");
        System.out.println("9. Eliminar plato");
        System.out.println("0. Salir");
        System.out.println("══════════════════════════════════════");
    }

    private static void addDish() {
        System.out.println("\n--- AGREGAR PLATO ---");
        try {
            System.out.print("Código (D###): ");
            String code = scanner.nextLine();

            System.out.print("Nombre: ");
            String name = scanner.nextLine();

            System.out.print("Categoría: ");
            String category = scanner.nextLine();

            double price = getDoubleInput("Precio: ");
            int stock = getIntInput("Stock: ");

            Dish7 dish = new Dish7(code, name, category, price, stock);
            manager.addDish(dish);

        } catch (DuplicateCodeException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    private static void searchByCode() {
        System.out.println("\n--- BUSCAR POR CÓDIGO ---");
        System.out.print("Código: ");
        String code = scanner.nextLine();

        try {
            Dish7 dish = manager.findByCode(code);
            System.out.println("\n✅ Encontrado:");
            System.out.println(dish);
        } catch (DishNotFoundException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    private static void searchByName() {
        System.out.println("\n--- BUSCAR POR NOMBRE ---");
        System.out.print("Texto a buscar: ");
        String search = scanner.nextLine();

        List<Dish7> results = manager.searchByName(search);

        if (results.isEmpty()) {
            System.out.println("❌ No se encontraron platos");
        } else {
            System.out.println("\n✅ Encontrados " + results.size() + " platos:");
            for (Dish7 dish : results) {
                System.out.println("  " + dish);
            }
        }
    }

    private static void showByCategory() {
        System.out.println("\n--- PLATOS POR CATEGORÍA ---");
        Set<String> categories = manager.getCategories();

        if (categories.isEmpty()) {
            System.out.println("No hay categorías");
            return;
        }

        System.out.println("Categorías disponibles:");
        int i = 1;
        List<String> catList = new ArrayList<>(categories);
        for (String cat : catList) {
            System.out.println(i++ + ". " + cat);
        }

        System.out.print("Seleccione categoría: ");
        String category = scanner.nextLine();

        List<Dish7> dishes = manager.getDishesByCategory(category);

        if (dishes.isEmpty()) {
            System.out.println("No hay platos en esa categoría");
        } else {
            System.out.println("\n✅ Platos en '" + category + "':");
            for (Dish7 dish : dishes) {
                System.out.println("  " + dish);
            }
        }
    }

    private static void filterByPrice() {
        System.out.println("\n--- FILTRAR POR PRECIO ---");
        double min = getDoubleInput("Precio mínimo: ");
        double max = getDoubleInput("Precio máximo: ");

        List<Dish7> results = manager.filterByPriceRange(min, max);

        if (results.isEmpty()) {
            System.out.println("❌ No hay platos en ese rango");
        } else {
            System.out.println("\n✅ Encontrados " + results.size() + " platos:");
            for (Dish7 dish : results) {
                System.out.println("  " + dish);
            }
        }
    }

    private static void showAvailable() {
        System.out.println("\n--- PLATOS DISPONIBLES ---");
        List<Dish7> available = manager.getAvailableDishes();

        if (available.isEmpty()) {
            System.out.println("No hay platos disponibles");
        } else {
            System.out.println("✅ " + available.size() + " platos disponibles:");
            for (Dish7 dish : available) {
                System.out.println("  " + dish);
            }
        }
    }

    private static void removeDish() {
        System.out.println("\n--- ELIMINAR PLATO ---");
        System.out.print("Código del plato: ");
        String code = scanner.nextLine();

        Dish7 removed = manager.removeDish(code);

        if (removed == null) {
            System.out.println("❌ No existe plato con código: " + code);
        }
    }

    private static void loadSampleData() {
        try {
            manager.addDish(new Dish7("D001", "Bandeja Paisa", "Plato Fuerte", 28000, 10));
            manager.addDish(new Dish7("D002", "Ajiaco", "Sopa", 22000, 8));
            manager.addDish(new Dish7("D003", "Lechona", "Plato Fuerte", 25000, 5));
            manager.addDish(new Dish7("D004", "Sancocho", "Sopa", 20000, 12));
            manager.addDish(new Dish7("D005", "Arroz con Pollo", "Plato Fuerte", 18000, 15));
            manager.addDish(new Dish7("D006", "Tamal", "Entrada", 8000, 20));
            manager.addDish(new Dish7("D007", "Empanadas", "Entrada", 5000, 25));
            manager.addDish(new Dish7("D008", "Tres Leches", "Postre", 12000, 0));

            System.out.println("✅ Datos de prueba cargados");
        } catch (DuplicateCodeException e) {
            System.out.println("Error cargando datos: " + e.getMessage());
        }
    }

    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Debe ser un número: ");
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer
        return value;
    }

    private static double getDoubleInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            scanner.next();
            System.out.print("Debe ser un número: ");
        }
        double value = scanner.nextDouble();
        scanner.nextLine(); // limpiar buffer
        return value;
    }
}
