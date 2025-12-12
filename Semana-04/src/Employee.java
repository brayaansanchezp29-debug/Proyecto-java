/**
 * Clase Padre: Empleado
 * Representa a cualquier empleado del restaurante Sabores del Valle
 */
public class Employee {
    // ====== ATRIBUTOS PROTECTED (Compartidos con subclases) ======
    protected String name;
    protected String id;
    protected double baseSalary;
    protected int yearsOfService;
    protected boolean active;

    // ====== CONSTRUCTOR ======

    /**
     * Constructor completo
     * @param name Nombre del empleado
     * @param id Identificación única
     * @param baseSalary Salario base mensual
     * @param yearsOfService Años de servicio en el restaurante
     */
    public Employee(String name, String id, double baseSalary, int yearsOfService) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
        this.yearsOfService = yearsOfService;
        this.active = true;
    }

    /**
     * Constructor básico (años de servicio = 0)
     */
    public Employee(String name, String id, double baseSalary) {
        this(name, id, baseSalary, 0);
    }

    // ====== GETTERS Y SETTERS ======

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary >= 1300000) {
            this.baseSalary = baseSalary;
        }
    }

    public int getYearsOfService() {
        return yearsOfService;
    }

    public void setYearsOfService(int yearsOfService) {
        if (yearsOfService >= 0) {
            this.yearsOfService = yearsOfService;
        }
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    // ====== MÉTODOS HEREDABLES ======

    /**
     * Calcula el salario total del empleado
     * Este método puede ser sobrescrito por las subclases
     * @return Salario calculado
     */
    public double calculateSalary() {
        // Bono por antigüedad: 2% por año
        double seniorityBonus = baseSalary * 0.02 * yearsOfService;
        return baseSalary + seniorityBonus;
    }

    /**
     * Muestra información básica del empleado
     * Este método puede ser sobrescrito para mostrar info adicional
     */
    public void showInfo() {
        System.out.println("=== EMPLEADO ===");
        System.out.println("Nombre: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salario Base: $" + String.format("%,.0f", baseSalary));
        System.out.println("Años de servicio: " + yearsOfService);
        System.out.println("Estado: " + (active ? "Activo" : "Inactivo"));
        System.out.println("Salario Total: $" + String.format("%,.0f", calculateSalary()));
    }

    /**
     * Retorna el tipo de empleado
     * Las subclases deben sobrescribir este método
     */
    public String getEmployeeType() {
        return "Empleado General";
    }

    /**
     * Calcula vacaciones anuales en días
     * @return Días de vacaciones
     */
    public int calculateVacationDays() {
        int baseDays = 15; // Vacaciones base por ley
        int bonusDays = yearsOfService / 5; // 1 día extra cada 5 años
        return baseDays + bonusDays;
    }

    /**
     * Aumenta años de servicio en 1
     */
    public void incrementYearsOfService() {
        this.yearsOfService++;
        System.out.println(name + " ahora tiene " + yearsOfService + " años de servicio");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", type='" + getEmployeeType() + '\'' +
                '}';
    }
}
