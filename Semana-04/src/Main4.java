/**
 * Programa Principal - Semana 04
 * Demuestra herencia, polimorfismo y sobrescritura de métodos
 * @author Brayan Alejandro Sanchez Pedroza
 */
public class Main4 {
    public static void main(String[] args) {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   SISTEMA DE GESTIÓN - SABORES DEL VALLE  ║");
        System.out.println("║        Semana 04 - HERENCIA                ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        // ========================================
        // CREACIÓN DE EMPLEADOS (SUBCLASES)
        // ========================================

        System.out.println("=== CREANDO EMPLEADOS DEL RESTAURANTE ===\n");

        // 1. CHEFS
        Chef chef1 = new Chef("Carlos Ramírez", "CH001", 2500000, 8,
                "Cocina Colombiana", 450, true);

        Chef chef2 = new Chef("Andrea Gómez", "CH002", 2000000, 3,
                "Repostería", 200, false);

        Chef chef3 = new Chef("Miguel Torres", "CH003", 1800000,
                "Carnes");

        // 2. MESEROS
        Waiter3 waiter1 = new Waiter3("Laura Martínez", "W001", 1500000, 5,
                "Mañana", 250, 400000);

        Waiter3 waiter2 = new Waiter3("Juan Pérez", "W002", 1500000, 2,
                "Noche", 180, 350000);

        Waiter3 waiter3 = new Waiter3("María López", "W003", 1400000,
                "Tarde");

        // 3. GERENTES
        Manager manager1 = new Manager("Roberto Silva", "MG001", 4000000, 10,
                "Operaciones", 15, 800000, true);

        Manager manager2 = new Manager("Ana García", "MG002", 3000000, 4,
                "Recursos Humanos", 8, 500000, false);

        Manager manager3 = new Manager("Diego Herrera", "MG003", 2800000,
                "Finanzas", 5);

        // ========================================
        // ARRAY POLIMÓRFICO (TODOS SON EMPLOYEES)
        // ========================================

        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║   DEMOSTRACIÓN DE POLIMORFISMO             ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        // Array de Employee puede contener cualquier subclase
        Employee[] employees = new Employee[9];

        employees[0] = chef1;
        employees[1] = chef2;
        employees[2] = chef3;
        employees[3] = waiter1;
        employees[4] = waiter2;
        employees[5] = waiter3;
        employees[6] = manager1;
        employees[7] = manager2;
        employees[8] = manager3;

        System.out.println("Total de empleados registrados: " + employees.length);
        System.out.println();

        // ========================================
        // POLIMORFISMO EN ACCIÓN
        // ========================================

        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║   INFORMACIÓN DE TODOS LOS EMPLEADOS       ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        // Polimorfismo: mismo método, diferente comportamiento
        for (Employee emp : employees) {
            emp.showInfo();  // Llama al método sobrescrito en cada subclase
            System.out.println();
        }

        // ========================================
        // CÁLCULO DE NÓMINA TOTAL
        // ========================================

        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║   NÓMINA TOTAL DEL RESTAURANTE             ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        double totalPayroll = 0;
        double chefsSalary = 0;
        double waitersSalary = 0;
        double managersSalary = 0;

        for (Employee emp : employees) {
            double salary = emp.calculateSalary();
            totalPayroll += salary;

            // Identificar tipo usando instanceof
            if (emp instanceof Chef) {
                chefsSalary += salary;
            } else if (emp instanceof Waiter3) {
                waitersSalary += salary;
            } else if (emp instanceof Manager) {
                managersSalary += salary;
            }
        }

        System.out.println("Nómina Chefs: $" + String.format("%,.0f", chefsSalary));
        System.out.println("Nómina Meseros: $" + String.format("%,.0f", waitersSalary));
        System.out.println("Nómina Gerentes: $" + String.format("%,.0f", managersSalary));
        System.out.println("----------------------------------------");
        System.out.println("TOTAL NÓMINA MENSUAL: $" + String.format("%,.0f", totalPayroll));
        System.out.println();

        // ========================================
        // DEMOSTRACIÓN DE MÉTODOS ESPECÍFICOS
        // ========================================

        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║   MÉTODOS ESPECÍFICOS DE CADA SUBCLASE     ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        // Métodos específicos de Chef
        System.out.println("--- CHEF ---");
        System.out.println(chef1.getName() + " - Nivel: " + chef1.getExperienceLevel());
        System.out.println("Bono mensual: $" + String.format("%,.0f", chef1.calculateMonthlyBonus()));
        chef1.registerDishPrepared();
        System.out.println();

        // Métodos específicos de Waiter3
        System.out.println("--- MESERO ---");
        System.out.println(waiter1.getName() + " - Nivel: " + waiter1.getServiceLevel());
        System.out.println("Propinas representan " +
                String.format("%.1f", waiter1.getTipsPercentage()) + "% del salario base");
        System.out.println("¿Bono de productividad? " +
                (waiter1.isEligibleForProductivityBonus() ? "Sí" : "No"));
        waiter1.registerTableServed();
        System.out.println();

        // Métodos específicos de Manager
        System.out.println("--- GERENTE ---");
        System.out.println(manager1.getName() + " - Nivel: " + manager1.getLeadershipLevel());
        System.out.println("Bono de liderazgo: $" +
                String.format("%,.0f", manager1.calculateLeadershipBonus()));
        System.out.println("Total de bonos: $" +
                String.format("%,.0f", manager1.calculateTotalBonuses()));
        manager1.addTeamMember();
        System.out.println();

        // ========================================
        // ESTADÍSTICAS POR TIPO
        // ========================================

        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║   ESTADÍSTICAS POR TIPO DE EMPLEADO        ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        int chefCount = 0;
        int waiterCount = 0;
        int managerCount = 0;

        for (Employee emp : employees) {
            if (emp instanceof Chef) chefCount++;
            else if (emp instanceof Waiter3) waiterCount++;
            else if (emp instanceof Manager) managerCount++;
        }

        System.out.println("Chefs: " + chefCount);
        System.out.println("Meseros: " + waiterCount);
        System.out.println("Gerentes: " + managerCount);
        System.out.println("Total: " + employees.length + " empleados");
        System.out.println();

        System.out.println("Salario promedio Chefs: $" +
                String.format("%,.0f", chefsSalary / chefCount));
        System.out.println("Salario promedio Meseros: $" +
                String.format("%,.0f", waitersSalary / waiterCount));
        System.out.println("Salario promedio Gerentes: $" +
                String.format("%,.0f", managersSalary / managerCount));
        System.out.println();

        // ========================================
        // DEMOSTRACIÓN DE SUPER
        // ========================================

        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║   USO DE SUPER() Y HERENCIA                ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        System.out.println("Todos los empleados heredan de Employee:");
        System.out.println("- Atributos: name, id, baseSalary, yearsOfService, active");
        System.out.println("- Métodos: calculateSalary(), showInfo(), calculateVacationDays()");
        System.out.println();
        System.out.println("Cada subclase:");
        System.out.println("✓ Llama a super() en sus constructores");
        System.out.println("✓ Sobrescribe calculateSalary() con su propia lógica");
        System.out.println("✓ Sobrescribe showInfo() para mostrar info específica");
        System.out.println("✓ Agrega sus propios atributos y métodos");
        System.out.println();

        // ========================================
        // EJEMPLO DE TIPOS DE EMPLEADOS
        // ========================================

        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║   TIPOS DE EMPLEADOS                       ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        for (Employee emp : employees) {
            System.out.println(emp.getName() + " → " + emp.getEmployeeType());
        }

        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   ¡Herencia implementada exitosamente!     ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
    }
}