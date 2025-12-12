import java.util.ArrayList;

/**
 * Programa Principal - Semana 05
 * Demostración completa de polimorfismo
 */
public class Main5 {
    public static void main(String[] args) {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   SISTEMA DE GESTIÓN - SABORES DEL VALLE  ║");
        System.out.println("║       Semana 05 - POLIMORFISMO             ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        // ========================================
        // 1. CREAR SISTEMA DE RH
        // ========================================

        RestaurantHR hrSystem = new RestaurantHR("Sabores del Valle");

        // ========================================
        // 2. CREAR EMPLEADOS DE DIFERENTES TIPOS
        // ========================================

        System.out.println("=== CREANDO EMPLEADOS ===\n");

        // Chefs
        Chef2 chef1 = new Chef2("Carlos Ramírez", "CH001", 2500000, 8,
                "Cocina Colombiana", 450, true);
        Chef2 chef2 = new Chef2("Andrea Gómez", "CH002", 2000000, 3,
                "Repostería", 200, false);
        Chef2 chef3 = new Chef2("Miguel Torres", "CH003", 1800000,
                "Carnes");

        // Meseros
        Waiter4 waiter1 = new Waiter4("Laura Martínez", "W001", 1500000, 5,
                "Mañana", 250, 400000);
        Waiter4 waiter2 = new Waiter4("Juan Pérez", "W002", 1500000, 2,
                "Noche", 180, 350000);
        Waiter4 waiter3 = new Waiter4("María López", "W003", 1400000,
                "Tarde");

        // Gerentes
        Manager2 manager1 = new Manager2("Roberto Silva", "MG001", 4000000, 10,
                "Operaciones", 15, 800000, true);
        Manager2 manager2 = new Manager2("Ana García", "MG002", 3000000, 4,
                "Recursos Humanos", 8, 500000, false);
        Manager2 manager3 = new Manager2("Diego Herrera", "MG003", 2800000,
                "Finanzas", 5);

        // ========================================
        // 3. AGREGAR EMPLEADOS (MÉTODO POLIMÓRFICO)
        // ========================================

        System.out.println("=== AGREGANDO EMPLEADOS AL SISTEMA ===\n");

        // Todos son Employee2, pero de diferentes tipos
        hrSystem.addEmployee(chef1);     // POLIMORFISMO
        hrSystem.addEmployee(chef2);     // POLIMORFISMO
        hrSystem.addEmployee(chef3);     // POLIMORFISMO
        hrSystem.addEmployee(waiter1);   // POLIMORFISMO
        hrSystem.addEmployee(waiter2);   // POLIMORFISMO
        hrSystem.addEmployee(waiter3);   // POLIMORFISMO
        hrSystem.addEmployee(manager1);  // POLIMORFISMO
        hrSystem.addEmployee(manager2);  // POLIMORFISMO
        hrSystem.addEmployee(manager3);  // POLIMORFISMO

        // ========================================
        // 4. ARRAYLIST POLIMÓRFICO
        // ========================================

        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║    ARRAYLIST POLIMÓRFICO                   ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        // ArrayList de Employee2 puede contener cualquier subclase
        ArrayList<Employee2> allEmployees = new ArrayList<>();
        allEmployees.add(chef1);
        allEmployees.add(waiter1);
        allEmployees.add(manager1);

        System.out.println("ArrayList de Employee2 contiene diferentes tipos:");
        for (Employee2 emp : allEmployees) {
            System.out.println("- " + emp.getName() + " → " + emp.getClass().getSimpleName());
        }

        // ========================================
        // 5. DYNAMIC BINDING (ENLACE DINÁMICO)
        // ========================================

        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║    DYNAMIC BINDING (ENLACE DINÁMICO)       ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        System.out.println("Mismo método, diferente comportamiento:\n");

        for (Employee2 emp : allEmployees) {
            System.out.println("Tipo: " + emp.getClass().getSimpleName());
            System.out.println(emp.getDescription());  // POLIMORFISMO: cada uno sobrescribe
            System.out.println("Salario: $" + String.format("%,.0f", emp.calculateSalary()));
            System.out.println("Tipo empleado: " + emp.getEmployeeType());
            System.out.println("---");
        }

        // ========================================
        // 6. PROCESAMIENTO DE NÓMINA POLIMÓRFICO
        // ========================================

        hrSystem.processCompletePayroll();  // POLIMORFISMO

        // ========================================
        // 7. REPORTE DE EMPLEADOS
        // ========================================

        hrSystem.generateReport();  // POLIMORFISMO

        // ========================================
        // 8. INFORMACIÓN DETALLADA (showInfo sobrescrito)
        // ========================================

        hrSystem.showAllEmployeesDetails();  // POLIMORFISMO

        // ========================================
        // 9. DEMOSTRACIÓN DE SOBRECARGA
        // ========================================

        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║    DEMOSTRACIÓN DE SOBRECARGA              ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        // Sobrecarga en Employee2: increaseSalary()
        System.out.println("--- SOBRECARGA: increaseSalary() ---\n");

        Employee2 testEmp = new Employee2("Test Employee", "T001", 2000000, 3);

        // 3 formas diferentes de aumentar salario
        testEmp.increaseSalary(10);              // Sobrecarga 1: porcentaje
        testEmp.increaseSalary(200000, true);    // Sobrecarga 2: monto fijo
        testEmp.increaseSalary("excelente");     // Sobrecarga 3: evaluación

        System.out.println("\n--- SOBRECARGA: calculateBonus() ---\n");
        System.out.println("Bono por defecto: $" + String.format("%,.0f", chef1.calculateBonus()));
        System.out.println("Bono con 25%: $" + String.format("%,.0f", chef1.calculateBonus(25)));
        System.out.println("Bono fijo: $" + String.format("%,.0f", chef1.calculateBonus(500000)));

        // Sobrecarga en Chef2: registerDish()
        System.out.println("\n--- SOBRECARGA: registerDish() (Chef) ---\n");
        chef2.registerDish();                      // Sobrecarga 1: sin parámetros
        chef2.registerDish(5);                     // Sobrecarga 2: cantidad
        chef2.registerDish("Torta de Chocolate", 3); // Sobrecarga 3: nombre y cantidad

        // Sobrecarga en Waiter4: registerTable()
        System.out.println("\n--- SOBRECARGA: registerTable() (Mesero) ---\n");
        waiter2.registerTable();                   // Sobrecarga 1: sin parámetros
        waiter2.registerTable(10);                 // Sobrecarga 2: cantidad
        waiter2.registerTable(50000);              // Sobrecarga 3: con propina

        // Sobrecarga en Manager2: assignBonus()
        System.out.println("\n--- SOBRECARGA: assignBonus() (Gerente) ---\n");
        manager3.assignBonus(500000);              // Sobrecarga 1: monto
        manager3.assignBonus(15, true);            // Sobrecarga 2: porcentaje
        manager3.assignBonus("excepcional");       // Sobrecarga 3: evaluación

        // ========================================
        // 10. SOBRECARGA EN BÚSQUEDAS
        // ========================================

        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║    SOBRECARGA: Búsqueda de Empleados      ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        // Buscar por ID
        Employee2 found1 = hrSystem.findEmployee("CH001");
        if (found1 != null) {
            System.out.println("Búsqueda por ID 'CH001': " + found1.getName());
        }

        // Buscar por nombre
        ArrayList<Employee2> found2 = hrSystem.findEmployee("María", true);
        System.out.println("\nBúsqueda por nombre 'María': " + found2.size() + " resultado(s)");
        for (Employee2 emp : found2) {
            System.out.println("  - " + emp.getName());
        }

        // Buscar por tipo
        ArrayList<Employee2> found3 = hrSystem.findEmployee(Chef2.class);
        System.out.println("\nBúsqueda por tipo Chef2: " + found3.size() + " resultado(s)");
        for (Employee2 emp : found3) {
            System.out.println("  - " + emp.getName());
        }

        // ========================================
        // 11. AUMENTOS GENERALES
        // ========================================

        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║    AUMENTOS GENERALES                      ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        // Aumento polimórfico a todos los empleados
        hrSystem.giveRaiseToAll(5);  // 5% a todos

        // Aumento por evaluación
        hrSystem.giveRaiseByEvaluation(chef1, "excelente");

        // ========================================
        // 12. ESTADÍSTICAS FINALES
        // ========================================

        hrSystem.showStatistics();

        // ========================================
        // 13. DEMOSTRACIÓN DE instanceof
        // ========================================

        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║    USO DE instanceof                       ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        for (Employee2 emp : allEmployees) {
            System.out.print(emp.getName() + " es: ");
            if (emp instanceof Chef2) {
                System.out.println("Chef");
                Chef2 c = (Chef2) emp;
                System.out.println("  Especialidad: " + c.getSpecialty());
            } else if (emp instanceof Waiter4) {
                System.out.println("Mesero");
                Waiter4 w = (Waiter4) emp;
                System.out.println("  Turno: " + w.getShift());
            } else if (emp instanceof Manager2) {
                System.out.println("Gerente");
                Manager2 m = (Manager2) emp;
                System.out.println("  Departamento: " + m.getDepartment());
            }
            System.out.println();
        }

        // ========================================
        // RESUMEN FINAL
        // ========================================

        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║    RESUMEN DE POLIMORFISMO                 ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        System.out.println("✅ Sobrecarga de métodos (Overloading):");
        System.out.println("   - increaseSalary() - 3 versiones");
        System.out.println("   - calculateBonus() - 3 versiones");
        System.out.println("   - registerDish() - 3 versiones");
        System.out.println("   - registerTable() - 3 versiones");
        System.out.println("   - assignBonus() - 3 versiones");
        System.out.println("   - findEmployee() - 3 versiones");

        System.out.println("\n✅ Sobrescritura de métodos (Overriding):");
        System.out.println("   - calculateSalary() - 3 subclases");
        System.out.println("   - showInfo() - 3 subclases");
        System.out.println("   - getDescription() - 3 subclases");
        System.out.println("   - getEmployeeType() - 3 subclases");
        System.out.println("   - calculateBonus() - 3 subclases");

        System.out.println("\n✅ Polimorfismo dinámico:");
        System.out.println("   - ArrayList<Employee2> con diferentes tipos");
        System.out.println("   - Métodos que aceptan Employee2");
        System.out.println("   - Dynamic binding en tiempo de ejecución");

        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   ¡Polimorfismo implementado exitosamente! ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
    }
}