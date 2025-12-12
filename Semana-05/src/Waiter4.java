/**
 * Subclase: Waiter4
 */
public class Waiter4 extends Employee2 {
    // ====== ATRIBUTOS PROPIOS ======
    private String shift;
    private int tablesServed;
    private double averageTips;

    // ====== CONSTRUCTORES ======

    public Waiter4(String name, String id, double baseSalary, int yearsOfService,
                   String shift, int tablesServed, double averageTips) {
        super(name, id, baseSalary, yearsOfService);
        this.shift = shift;
        this.tablesServed = tablesServed;
        this.averageTips = averageTips;
    }

    public Waiter4(String name, String id, double baseSalary, int yearsOfService, String shift) {
        this(name, id, baseSalary, yearsOfService, shift, 0, 0.0);
    }

    public Waiter4(String name, String id, double baseSalary, String shift) {
        this(name, id, baseSalary, 0, shift, 0, 0.0);
    }

    // ====== GETTERS Y SETTERS ======

    public String getShift() { return shift; }
    public void setShift(String shift) { this.shift = shift; }

    public int getTablesServed() { return tablesServed; }
    public void setTablesServed(int tablesServed) {
        if (tablesServed >= 0) this.tablesServed = tablesServed;
    }

    public double getAverageTips() { return averageTips; }
    public void setAverageTips(double averageTips) {
        if (averageTips >= 0) this.averageTips = averageTips;
    }

    // ====== SOBRESCRITURA (@Override) ======

    @Override
    public double calculateSalary() {
        double baseSalary = super.calculateSalary();
        double totalWithTips = baseSalary + averageTips;
        if (shift.equalsIgnoreCase("Noche")) {
            totalWithTips += this.baseSalary * 0.20;
        }
        if (tablesServed > 200) {
            totalWithTips += 100000;
        }
        return totalWithTips;
    }

    @Override
    public void showInfo() {
        System.out.println("=== MESERO ===");
        System.out.println("Nombre: " + name);
        System.out.println("ID: " + id);
        System.out.println("Turno: " + shift);
        System.out.println("Años de servicio: " + yearsOfService);
        System.out.println("Mesas atendidas: " + tablesServed);
        System.out.println("Propinas promedio: $" + formatMoney(averageTips));
        System.out.println("Nivel: " + getServiceLevel());
        System.out.println("Salario Base: $" + formatMoney(baseSalary));
        System.out.println("Salario Total: $" + formatMoney(calculateSalary()));
        System.out.println("Días de vacaciones: " + calculateVacationDays());
        System.out.println("Estado: " + (active ? "Activo" : "Inactivo"));
    }

    @Override
    public String getDescription() {
        return "Mesero: " + name + " - Turno " + shift +
                " (" + yearsOfService + " años) - " + getServiceLevel();
    }

    @Override
    public String getEmployeeType() {
        return "Mesero - Turno " + shift;
    }

    @Override
    public double calculateBonus() {
        // Meseros obtienen bono basado en propinas
        return averageTips * 0.10;
    }

    // ====== SOBRECARGA ======

    /**
     * SOBRECARGA: Registrar mesa atendida
     */
    public void registerTable() {
        tablesServed++;
    }

    /**
     * SOBRECARGA: Registrar múltiples mesas
     */
    public void registerTable(int quantity) {
        if (quantity > 0) {
            tablesServed += quantity;
            System.out.println(name + " atendió " + quantity + " mesas. Total: " + tablesServed);
        }
    }

    /**
     * SOBRECARGA: Registrar mesa con propina
     */
    public void registerTable(double tips) {
        tablesServed++;
        updateTipsAverage(tips);
        System.out.println(name + " atendió mesa con propina de $" + formatMoney(tips));
    }

    // ====== MÉTODOS PROPIOS ======

    public void updateTipsAverage(double newTips) {
        this.averageTips = (this.averageTips + newTips) / 2;
    }

    public String getServiceLevel() {
        if (yearsOfService < 1 || tablesServed < 100) return "Principiante";
        else if (yearsOfService < 3 || tablesServed < 200) return "Intermedio";
        else if (yearsOfService < 5 || tablesServed < 300) return "Avanzado";
        else return "Experto";
    }

    public double getTipsPercentage() {
        if (baseSalary == 0) return 0;
        return (averageTips / baseSalary) * 100;
    }

    @Override
    public String toString() {
        return "Waiter4{" +
                "name='" + name + '\'' +
                ", shift='" + shift + '\'' +
                ", level='" + getServiceLevel() + '\'' +
                '}';
    }
}