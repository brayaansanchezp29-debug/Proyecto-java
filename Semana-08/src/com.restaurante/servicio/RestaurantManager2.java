package com.restaurante.servicio;

import com.restaurante.modelo.Dish7;
import com.restaurante.excepciones.*;
import java.util.*;

/**
 * Gestor del Restaurante con HashMap y ArrayList
 */
public class RestaurantManager2 {

    // HashMap para búsqueda O(1) por código
    private Map<String, Dish7> dishesByCode;

    // HashMap para agrupar por categoría
    private Map<String, List<Dish7>> dishesByCategory;

    // Lista para mantener orden de inserción
    private List<Dish7> dishHistory;

    public RestaurantManager2() {
        dishesByCode = new HashMap<>();
        dishesByCategory = new HashMap<>();
        dishHistory = new ArrayList<>();
    }

    // ====== OPERACIONES CRUD ======

    /**
     * Agrega un plato (validando duplicados)
     * @throws DuplicateCodeException si ya existe el código
     */
    public void addDish(Dish7 dish) throws DuplicateCodeException {
        if (dishesByCode.containsKey(dish.getCode())) {
            throw new DuplicateCodeException(
                    "Ya existe un plato con código: " + dish.getCode()
            );
        }

        // Agregar a HashMap principal
        dishesByCode.put(dish.getCode(), dish);

        // Agregar a historial
        dishHistory.add(dish);

        // Agrupar por categoría
        String category = dish.getCategory();
        if (!dishesByCategory.containsKey(category)) {
            dishesByCategory.put(category, new ArrayList<>());
        }
        dishesByCategory.get(category).add(dish);

        System.out.println("✅ Plato agregado: " + dish.getName());
    }

    /**
     * Busca un plato por código (O(1))
     * @throws DishNotFoundException si no existe
     */
    public Dish7 findByCode(String code) throws DishNotFoundException {
        Dish7 dish = dishesByCode.get(code);
        if (dish == null) {
            throw new DishNotFoundException("No existe plato con código: " + code);
        }
        return dish;
    }

    /**
     * Verifica si existe un código
     */
    public boolean exists(String code) {
        return dishesByCode.containsKey(code);
    }

    /**
     * Elimina un plato por código
     * @return El plato eliminado o null
     */
    public Dish7 removeDish(String code) {
        Dish7 dish = dishesByCode.remove(code);

        if (dish != null) {
            dishHistory.remove(dish);

            String category = dish.getCategory();
            if (dishesByCategory.containsKey(category)) {
                dishesByCategory.get(category).remove(dish);
            }

            System.out.println("❌ Plato eliminado: " + dish.getName());
        }

        return dish;
    }

    /**
     * Obtiene todos los platos
     */
    public List<Dish7> getAllDishes() {
        return new ArrayList<>(dishHistory);
    }

    /**
     * Cantidad total de platos
     */
    public int getTotalDishes() {
        return dishHistory.size();
    }

    // ====== BÚSQUEDAS Y FILTROS ======

    /**
     * Obtiene platos por categoría
     */
    public List<Dish7> getDishesByCategory(String category) {
        return dishesByCategory.getOrDefault(category, new ArrayList<>());
    }

    /**
     * Filtra platos por rango de precio
     */
    public List<Dish7> filterByPriceRange(double min, double max) {
        List<Dish7> result = new ArrayList<>();
        for (Dish7 dish : dishHistory) {
            if (dish.getPrice() >= min && dish.getPrice() <= max) {
                result.add(dish);
            }
        }
        return result;
    }

    /**
     * Filtra platos disponibles (stock > 0)
     */
    public List<Dish7> getAvailableDishes() {
        List<Dish7> result = new ArrayList<>();
        for (Dish7 dish : dishHistory) {
            if (dish.getStock() > 0) {
                result.add(dish);
            }
        }
        return result;
    }

    /**
     * Busca platos por nombre (contiene texto)
     */
    public List<Dish7> searchByName(String searchText) {
        List<Dish7> result = new ArrayList<>();
        String search = searchText.toLowerCase();
        for (Dish7 dish : dishHistory) {
            if (dish.getName().toLowerCase().contains(search)) {
                result.add(dish);
            }
        }
        return result;
    }

    // ====== ESTADÍSTICAS ======

    /**
     * Calcula el valor total del inventario
     */
    public double calculateTotalInventoryValue() {
        double total = 0;
        for (Dish7 dish : dishHistory) {
            total += dish.getPrice() * dish.getStock();
        }
        return total;
    }

    /**
     * Calcula el precio promedio
     */
    public double calculateAveragePrice() {
        if (dishHistory.isEmpty()) return 0;

        double total = 0;
        for (Dish7 dish : dishHistory) {
            total += dish.getPrice();
        }
        return total / dishHistory.size();
    }

    /**
     * Encuentra el plato más caro
     */
    public Dish7 getMostExpensiveDish() {
        if (dishHistory.isEmpty()) return null;

        Dish7 mostExpensive = dishHistory.get(0);
        for (Dish7 dish : dishHistory) {
            if (dish.getPrice() > mostExpensive.getPrice()) {
                mostExpensive = dish;
            }
        }
        return mostExpensive;
    }

    /**
     * Encuentra el plato más barato
     */
    public Dish7 getCheapestDish() {
        if (dishHistory.isEmpty()) return null;

        Dish7 cheapest = dishHistory.get(0);
        for (Dish7 dish : dishHistory) {
            if (dish.getPrice() < cheapest.getPrice()) {
                cheapest = dish;
            }
        }
        return cheapest;
    }

    /**
     * Cuenta platos por categoría
     */
    public Map<String, Integer> countByCategory() {
        Map<String, Integer> count = new HashMap<>();
        for (Dish7 dish : dishHistory) {
            String category = dish.getCategory();
            count.put(category, count.getOrDefault(category, 0) + 1);
        }
        return count;
    }

    /**
     * Obtiene las categorías disponibles
     */
    public Set<String> getCategories() {
        return dishesByCategory.keySet();
    }

    // ====== REPORTES ======

    /**
     * Muestra todos los platos
     */
    public void showAllDishes() {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║         MENÚ DEL RESTAURANTE               ║");
        System.out.println("╚════════════════════════════════════════════╝");

        if (dishHistory.isEmpty()) {
            System.out.println("No hay platos registrados");
            return;
        }

        for (Dish7 dish : dishHistory) {
            System.out.println(dish);
        }
    }

    /**
     * Muestra estadísticas completas
     */
    public void showStatistics() {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║           ESTADÍSTICAS                     ║");
        System.out.println("╚════════════════════════════════════════════╝");

        System.out.println("Total de platos: " + getTotalDishes());
        System.out.println("Valor total inventario: $" +
                String.format("%,.0f", calculateTotalInventoryValue()));
        System.out.println("Precio promedio: $" +
                String.format("%,.0f", calculateAveragePrice()));

        Dish7 expensive = getMostExpensiveDish();
        if (expensive != null) {
            System.out.println("Plato más caro: " + expensive.getName() +
                    " ($" + String.format("%,.0f", expensive.getPrice()) + ")");
        }

        Dish7 cheap = getCheapestDish();
        if (cheap != null) {
            System.out.println("Plato más barato: " + cheap.getName() +
                    " ($" + String.format("%,.0f", cheap.getPrice()) + ")");
        }

        System.out.println("\nPlatos por categoría:");
        Map<String, Integer> count = countByCategory();
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
