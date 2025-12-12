import java.util.ArrayList;

/**
 * Clase Gestora: RestaurantHR (Human Resources)
 * Sistema de Recursos Humanos del Restaurante
 * Demuestra métodos polimórficos que trabajan con Employee2
 */
public class RestaurantHR {
    private String restaurantName;
    private ArrayList<Employee2> employees;

    // ====== CONSTRUCTOR ======

    public RestaurantHR(String restaurantName) {
        this.restaurantName = restaurantName;
        this.employees = new ArrayList<>();
    }

    // ====== MÉTODOS POLIMÓRFICOS ======

    /**
     * POLIMORFISMO: Agrega cualquier tipo de empleado
     * @param employee Puede ser Chef2, Waiter4, Manager2, etc.
     */
    public void addEmployee(Employee2 employee) {
        if (employee != null) {
            employees.add(employee);
            System.out.println("✅ Empleado agregado: " + employee.getDescription());
        }
    }

    /**
     * POLIMORFISMO: Procesa nómina de un empleado
     * Funciona con cualquier subclase de Employee2
     */
    public void processPayroll(Employee2 employee) {
        System.out.println("\n--- PROCESANDO PAGO ---");
        System.out.println("Empleado: " + employee.getName());
        System.out.println("Tipo: " + employee.getEmployeeType());
        double salary = employee.calculateSalary();  // POLIMORFISMO: llama método sobrescrito
        System.out.println("Salario Total: $" + formatMoney(salary));
        System.out.println("Bono del mes: $" + formatMoney(employee.calculateBonus()));
    }

    /**
     * POLIMORFISMO: Procesa nómina completa
     * Itera sobre ArrayList polimórfico
     */
    public void processCompletePayroll() {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║         NÓMINA MENSUAL - " + restaurantName.toUpperCase());
        System.out.println("╚════════════════════════════════════════════╝");

        double totalPayroll = 0;

        for (Employee2 emp : employees) {
            processPayroll(emp);  // POLIMORFISMO
            totalPayroll += emp.calculateSalary();
            System.out.println("---");
        }

        System.out.println("\n💰 TOTAL NÓMINA: $" + formatMoney(totalPayroll));
    }

    /**
     * POLIMORFISMO: Genera reporte de todos los empleados
     */
    public void generateReport() {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║      REPORTE DE EMPLEADOS                  ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        for (Employee2 emp : employees) {
            System.out.println(emp.getDescription());  // POLIMORFISMO
            System.out.println("Salario: $" + formatMoney(emp.calculateSalary()));
            System.out.println("Vacaciones: " + emp.calculateVacationDays() + " días");
            System.out.println();
        }
    }

    /**
     * POLIMORFISMO: Aumenta salario a todos
     */
    public void giveRaiseToAll(double percentage) {
        System.out.println("\n🎉 AUMENTO GENERAL DEL " + percentage + "%");
        for (Employee2 emp : employees) {
            emp.increaseSalary(percentage);  // POLIMORFISMO: sobrecargado
        }
    }

    /**
     * POLIMORFISMO: Aumenta salario por evaluación
     */
    public void giveRaiseByEvaluation(Employee2 employee, String evaluation) {
        System.out.println("\n📊 AUMENTO POR EVALUACIÓN");
        employee.increaseSalary(evaluation);  // POLIMORFISMO: sobrecargado
    }

    /**
     * POLIMORFISMO: Muestra info detallada de un empleado
     */
    public void showEmployeeDetails(Employee2 employee) {
        employee.showInfo();  // POLIMORFISMO: cada subclase muestra diferente
    }

    /**
     * POLIMORFISMO: Muestra info de todos
     */
    public void showAllEmployeesDetails() {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   INFORMACIÓN DETALLADA DE EMPLEADOS       ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        for (Employee2 emp : employees) {
            showEmployeeDetails(emp);  // POLIMORFISMO
            System.out.println();
        }
    }

    // ====== SOBRECARGA: Buscar empleados ======

    /**
     * SOBRECARGA 1: Buscar por ID
     */
    public Employee2 findEmployee(String id) {
        for (Employee2 emp : employees) {
            if (emp.getId().equals(id)) {
                return emp;
            }
        }
        return null;
    }

    /**
     * SOBRECARGA 2: Buscar por nombre
     */
    public ArrayList<Employee2> findEmployee(String name, boolean byName) {
        ArrayList<Employee2> found = new ArrayList<>();
        for (Employee2 emp : employees) {
            if (emp.getName().toLowerCase().contains(name.toLowerCase())) {
                found.add(emp);
            }
        }
        return found;
    }

    /**
     * SOBRECARGA 3: Buscar por tipo (usando Class)
     */
    public ArrayList<Employee2> findEmployee(Class<?> type) {
        ArrayList<Employee2> found = new ArrayList<>();
        for (Employee2 emp : employees) {
            if (type.isInstance(emp)) {
                found.add(emp);
            }
        }
        return found;
    }

    // ====== MÉTODOS DE ESTADÍSTICAS ======

    public void showStatistics() {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║           ESTADÍSTICAS DE RH               ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        int chefs = 0, waiters = 0, managers = 0;
        double chefsPayroll = 0, waitersPayroll = 0, managersPayroll = 0;

        for (Employee2 emp : employees) {
            double salary = emp.calculateSalary();

            if (emp instanceof Chef2) {
                chefs++;
                chefsPayroll += salary;
            } else if (emp instanceof Waiter4) {
                waiters++;
                waitersPayroll += salary;
            } else if (emp instanceof Manager2) {
                managers++;
                managersPayroll += salary;
            }
        }

        System.out.println("📊 Total empleados: " + employees.size());
        System.out.println("   - Chefs: " + chefs);
        System.out.println("   - Meseros: " + waiters);
        System.out.println("   - Gerentes: " + managers);
        System.out.println();
        System.out.println("💵 Nómina por tipo:");
        if (chefs > 0) {
            System.out.println("   - Chefs: $" + formatMoney(chefsPayroll) +
                    " (Promedio: $" + formatMoney(chefsPayroll/chefs) + ")");
        }
        if (waiters > 0) {
            System.out.println("   - Meseros: $" + formatMoney(waitersPayroll) +
                    " (Promedio: $" + formatMoney(waitersPayroll/waiters) + ")");
        }
        if (managers > 0) {
            System.out.println("   - Gerentes: $" + formatMoney(managersPayroll) +
                    " (Promedio: $" + formatMoney(managersPayroll/managers) + ")");
        }

        double totalPayroll = chefsPayroll + waitersPayroll + managersPayroll;
        System.out.println();
        System.out.println("💰 NÓMINA TOTAL: $" + formatMoney(totalPayroll));
    }

    /**
     * Cuenta empleados por tipo
     */
    public int countByType(Class<?> type) {
        int count = 0;
        for (Employee2 emp : employees) {
            if (type.isInstance(emp)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Calcula nómina total
     */
    public double calculateTotalPayroll() {
        double total = 0;
        for (Employee2 emp : employees) {
            total += emp.calculateSalary();  // POLIMORFISMO
        }
        return total;
    }

    // ====== GETTERS ======

    public ArrayList<Employee2> getEmployees() {
        return new ArrayList<>(employees);
    }

    public int getEmployeeCount() {
        return employees.size();
    }

    // ====== AUXILIAR ======

    private String formatMoney(double amount) {
        return String.format("%,.0f", amount);
    }
}
