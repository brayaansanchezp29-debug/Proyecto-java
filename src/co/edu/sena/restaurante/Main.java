package co.edu.sena.restaurante;

/**
 * Programa principal - Restaurante Sabores del Valle
 * @author Brayan Alejandro Sanchez Pedroza
 * @ficha 3228973B
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   RESTAURANTE SABORES DEL VALLE           ║");
        System.out.println("║   Menú de Comida Típica Colombiana        ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        // Crear 5 platos del menú
        Dish plato1 = new Dish("Bandeja Paisa", "Plato Fuerte", 28000);
        Dish plato2 = new Dish("Ajiaco Santafereño", "Sopa", 22000);
        Dish plato3 = new Dish("Lechona Tolimense", "Plato Fuerte", 25000);
        Dish plato4 = new Dish("Sancocho de Gallina", "Sopa", 20000);
        Dish plato5 = new Dish("Arroz con Pollo", "Plato Fuerte", 18000);

        // Mostrar información de todos los platos
        plato1.showInfo();
        plato2.showInfo();
        plato3.showInfo();
        plato4.showInfo();
        plato5.showInfo();

        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   ¡Gracias por visitar!                   ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
    }
}
