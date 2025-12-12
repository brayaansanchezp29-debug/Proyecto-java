/**
 * Subclase: Waiter3 (Mesero)
 * Hereda de Employee y representa a un mesero del restaurante
 */
public class Waiter3 extends Employee {
    // ====== ATRIBUTOS PROPIOS ======
    private String shift;           // Turno: Mañana, Tarde, Noche
    private int tablesServed;       // Mesas atendidas
    private double averageTips;     // Promedio de propinas mensuales

    // ====== CONSTRUCTORES ======

    /**
     * Constructor completo
     */
    public Waiter3(String name, String id, double baseSalary, int yearsOfService,
                   String shift, int tablesServed, double averageTips) {
        super(name, id, baseSalary, yearsOfService);  // Llama al constructor padre
        this.shift = shift;
        this.tablesServed = tablesServed;
        this.averageTips = averageTips;
    }

    /**
     * Constructor sin propinas (nuevo mesero)
     */
    public Waiter3(String name, String id, double baseSalary, int yearsOfService, String shift) {
        this(name, id, baseSalary, yearsOfService, shift, 0, 0.0);
    }

    /**
     * Constructor básico (turno Mañana por defecto)
     */
    public Waiter3(String name, String id, double baseSalary, String shift) {
        this(name, id, baseSalary, 0, shift, 0, 0.0);
    }

    // ====== GETTERS Y SETTERS ======

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public int getTablesServed() {
        return tablesServed;
    }

    public void setTablesServed(int tablesServed) {
        if (tablesServed >= 0) {
            this.tablesServed = tablesServed;
        }
    }

    public double getAverageTips() {
        return averageTips;
    }

    public void setAverageTips(double averageTips) {
        if (averageTips >= 0) {
            this.averageTips = averageTips;
        }
    }

    // ====== MÉTODOS SOBRESCRITOS ======

    /**
     * Sobrescribe el cálculo de salario para incluir propinas
     */
    @Override
    public double calculateSalary() {
        double baseSalary = super.calculateSalary(); // Llama al método padre

        // Agregar propinas promedio
        double totalWithTips = baseSalary + averageTips;

        // Bono por turno nocturno (20% adicional)
        if (shift.equalsIgnoreCase("Noche")) {
            totalWithTips += this.baseSalary * 0.20;
        }

        // Bono por productividad (si atiende más de 200 mesas al mes)
        if (tablesServed > 200) {
            totalWithTips += 100000;
        }

        return totalWithTips;
    }

    /**
     * Sobrescribe showInfo para mostrar información específica del mesero
     */
    @Override
    public void showInfo() {
        System.out.println("=== MESERO ===");
        System.out.println("Nombre: " + name);
        System.out.println("ID: " + id);
        System.out.println("Turno: " + shift);
        System.out.println("Años de servicio: " + yearsOfService);
        System.out.println("Mesas atendidas (mes): " + tablesServed);
        System.out.println("Promedio propinas: $" + String.format("%,.0f", averageTips));
        System.out.println("Salario Base: $" + String.format("%,.0f", baseSalary));
        System.out.println("Salario Total (+ propinas): $" + String.format("%,.0f", calculateSalary()));
        System.out.println("Días de vacaciones: " + calculateVacationDays());
        System.out.println("Nivel: " + getServiceLevel());
        System.out.println("Estado: " + (active ? "Activo" : "Inactivo"));
    }

    /**
     * Sobrescribe el tipo de empleado
     */
    @Override
    public String getEmployeeType() {
        return "Mesero - Turno " + shift;
    }

    // ====== MÉTODOS PROPIOS ======

    /**
     * Registra una mesa atendida
     */
    public void registerTableServed() {
        tablesServed++;
    }

    /**
     * Actualiza el promedio de propinas
     */
    public void updateTipsAverage(double newTips) {
        // Promedio simple para el mes
        this.averageTips = (this.averageTips + newTips) / 2;
    }

    /**
     * Nivel de servicio basado en experiencia y desempeño
     */
    public String getServiceLevel() {
        if (yearsOfService < 1 || tablesServed < 100) {
            return "Principiante";
        } else if (yearsOfService < 3 || tablesServed < 200) {
            return "Intermedio";
        } else if (yearsOfService < 5 || tablesServed < 300) {
            return "Avanzado";
        } else {
            return "Experto";
        }
    }

    /**
     * Calcula porcentaje de propinas sobre salario base
     */
    public double getTipsPercentage() {
        if (baseSalary == 0) return 0;
        return (averageTips / baseSalary) * 100;
    }

    /**
     * Verifica si es elegible para bono de productividad
     */
    public boolean isEligibleForProductivityBonus() {
        return tablesServed > 200;
    }

    @Override
    public String toString() {
        return "Waiter3{" +
                "name='" + name + '\'' +
                ", shift='" + shift + '\'' +
                ", level='" + getServiceLevel() + '\'' +
                ", tablesServed=" + tablesServed +
                '}';
    }
}
