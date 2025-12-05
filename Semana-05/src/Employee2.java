/**
 * Clase Padre: Employee2
 * Versión mejorada con sobrecarga de métodos
 * @author Brayan Alejandro Sanchez Pedroza
 * @version 5.0 - Polimorfismo
 */
public class Employee2 {
    // ====== ATRIBUTOS PROTECTED ======
    protected String name;
    protected String id;
    protected double baseSalary;
    protected int yearsOfService;
    protected boolean active;

    // ====== CONSTRUCTORES ======

    public Employee2(String name, String id, double baseSalary, int yearsOfService) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
        this.yearsOfService = yearsOfService;
        this.active = true;
    }

    public Employee2(String name, String id, double baseSalary) {
        this(name, id, baseSalary, 0);
    }

    // ====== GETTERS Y SETTERS ======

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) {
        if (baseSalary >= 1300000) {
            this.baseSalary = baseSalary;
        }
    }

    public int getYearsOfService() { return yearsOfService; }
    public void setYearsOfService(int yearsOfService) {
        if (yearsOfService >= 0) {
            this.yearsOfService = yearsOfService;
        }
    }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    // ====== MÉTODOS QUE SERÁN SOBRESCRITOS ======

    /**
     * Calcula el salario total
     * Este método será sobrescrito en las subclases
     */
    public double calculateSalary() {
        double seniorityBonus = baseSalary * 0.02 * yearsOfService;
        return baseSalary + seniorityBonus;
    }

    /**
     * Muestra información del empleado
     * Será sobrescrito para mostrar info específica
     */
    public void showInfo() {
        System.out.println("=== EMPLEADO ===");
        System.out.println("Nombre: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salario Base: $" + formatMoney(baseSalary));
        System.out.println("Años de servicio: " + yearsOfService);
        System.out.println("Estado: " + (active ? "Activo" : "Inactivo"));
        System.out.println("Salario Total: $" + formatMoney(calculateSalary()));
    }

    /**
     * Retorna descripción del empleado
     * Será sobrescrito en subclases
     */
    public String getDescription() {
        return "Empleado: " + name + " (ID: " + id + ")";
    }

    /**
     * Retorna el tipo de empleado
     */
    public String getEmployeeType() {
        return "Empleado General";
    }

    /**
     * Calcula días de vacaciones
     */
    public int calculateVacationDays() {
        int baseDays = 15;
        int bonusDays = yearsOfService / 5;
        return baseDays + bonusDays;
    }

    // ====== SOBRECARGA DE MÉTODOS (OVERLOADING) ======

    /**
     * SOBRECARGA 1: Aumenta salario con porcentaje
     */
    public void increaseSalary(double percentage) {
        if (percentage > 0 && percentage <= 50) {
            double increase = baseSalary * (percentage / 100);
            baseSalary += increase;
            System.out.println("Salario de " + name + " aumentado en " +
                    percentage + "% → $" + formatMoney(baseSalary));
        }
    }

    /**
     * SOBRECARGA 2: Aumenta salario con monto fijo
     */
    public void increaseSalary(double fixedAmount, boolean isFixed) {
        if (isFixed && fixedAmount > 0) {
            baseSalary += fixedAmount;
            System.out.println("Salario de " + name + " aumentado en $" +
                    formatMoney(fixedAmount) + " → $" + formatMoney(baseSalary));
        }
    }

    /**
     * SOBRECARGA 3: Aumenta salario basado en evaluación
     */
    public void increaseSalary(String evaluation) {
        double percentage = 0;
        switch (evaluation.toLowerCase()) {
            case "excelente":
                percentage = 15;
                break;
            case "bueno":
                percentage = 10;
                break;
            case "satisfactorio":
                percentage = 5;
                break;
            default:
                System.out.println("Evaluación no válida");
                return;
        }
        increaseSalary(percentage);
    }

    /**
     * SOBRECARGA 4: Calcula bono
     */
    public double calculateBonus() {
        return baseSalary * 0.10; // 10% por defecto
    }

    /**
     * SOBRECARGA 5: Calcula bono con porcentaje específico
     */
    public double calculateBonus(double percentage) {
        if (percentage > 0 && percentage <= 100) {
            return baseSalary * (percentage / 100);
        }
        return 0;
    }

    /**
     * SOBRECARGA 6: Calcula bono con monto fijo
     */
    public double calculateBonus(int fixedAmount) {
        return fixedAmount;
    }

    // ====== MÉTODOS AUXILIARES ======

    protected String formatMoney(double amount) {
        return String.format("%,.0f", amount);
    }

    public void incrementYearsOfService() {
        this.yearsOfService++;
        System.out.println(name + " ahora tiene " + yearsOfService + " años de servicio");
    }

    @Override
    public String toString() {
        return "Employee2{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", type='" + getEmployeeType() + '\'' +
                '}';
    }
}