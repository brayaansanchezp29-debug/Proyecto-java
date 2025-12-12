/**
 * Subclase: Manager2
 */
public class Manager2 extends Employee2 {
    // ====== ATRIBUTOS PROPIOS ======
    private String department;
    private int teamSize;
    private double performanceBonus;
    private boolean seniorManager;

    // ====== CONSTRUCTORES ======

    public Manager2(String name, String id, double baseSalary, int yearsOfService,
                    String department, int teamSize, double performanceBonus, boolean seniorManager) {
        super(name, id, baseSalary, yearsOfService);
        this.department = department;
        this.teamSize = teamSize;
        this.performanceBonus = performanceBonus;
        this.seniorManager = seniorManager;
    }

    public Manager2(String name, String id, double baseSalary, int yearsOfService,
                    String department, int teamSize, boolean seniorManager) {
        this(name, id, baseSalary, yearsOfService, department, teamSize, 0.0, seniorManager);
    }

    public Manager2(String name, String id, double baseSalary, String department, int teamSize) {
        this(name, id, baseSalary, 0, department, teamSize, 0.0, false);
    }

    // ====== GETTERS Y SETTERS ======

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public int getTeamSize() { return teamSize; }
    public void setTeamSize(int teamSize) {
        if (teamSize >= 0) this.teamSize = teamSize;
    }

    public double getPerformanceBonus() { return performanceBonus; }
    public void setPerformanceBonus(double performanceBonus) {
        if (performanceBonus >= 0) this.performanceBonus = performanceBonus;
    }

    public boolean isSeniorManager() { return seniorManager; }
    public void setSeniorManager(boolean seniorManager) { this.seniorManager = seniorManager; }

    // ====== SOBRESCRITURA (@Override) ======

    @Override
    public double calculateSalary() {
        double baseSalary = super.calculateSalary();
        double leadershipBonus = this.baseSalary * 0.05 * teamSize;
        double seniorBonus = seniorManager ? this.baseSalary * 0.30 : 0;
        return baseSalary + leadershipBonus + seniorBonus + performanceBonus;
    }

    @Override
    public void showInfo() {
        System.out.println("=== GERENTE ===");
        System.out.println("Nombre: " + name);
        System.out.println("ID: " + id);
        System.out.println("Departamento: " + department);
        System.out.println("Posición: " + (seniorManager ? "Gerente Senior" : "Gerente"));
        System.out.println("Años de servicio: " + yearsOfService);
        System.out.println("Tamaño del equipo: " + teamSize);
        System.out.println("Nivel liderazgo: " + getLeadershipLevel());
        System.out.println("Bono desempeño: $" + formatMoney(performanceBonus));
        System.out.println("Salario Base: $" + formatMoney(baseSalary));
        System.out.println("Salario Total: $" + formatMoney(calculateSalary()));
        System.out.println("Días de vacaciones: " + calculateVacationDays());
        System.out.println("Estado: " + (active ? "Activo" : "Inactivo"));
    }

    @Override
    public String getDescription() {
        return (seniorManager ? "Gerente Senior: " : "Gerente: ") + name +
                " - " + department + " (Equipo: " + teamSize + ")";
    }

    @Override
    public String getEmployeeType() {
        return seniorManager ? "Gerente Senior - " + department : "Gerente - " + department;
    }

    @Override
    public int calculateVacationDays() {
        int baseDays = super.calculateVacationDays();
        int managerBonus = seniorManager ? 5 : 3;
        return baseDays + managerBonus;
    }

    @Override
    public double calculateBonus() {
        // Gerentes obtienen 25% de bono base
        return baseSalary * 0.25;
    }

    // ====== SOBRECARGA ======

    /**
     * SOBRECARGA: Asignar bono por monto
     */
    public void assignBonus(double amount) {
        if (amount > 0) {
            this.performanceBonus = amount;
            System.out.println("Bono de $" + formatMoney(amount) + " asignado a " + name);
        }
    }

    /**
     * SOBRECARGA: Asignar bono por porcentaje
     */
    public void assignBonus(double percentage, boolean isPercentage) {
        if (isPercentage && percentage > 0) {
            this.performanceBonus = baseSalary * (percentage / 100);
            System.out.println("Bono del " + percentage + "% ($" +
                    formatMoney(performanceBonus) + ") asignado a " + name);
        }
    }

    /**
     * SOBRECARGA: Asignar bono por evaluación
     */
    public void assignBonus(String evaluation) {
        double percentage = 0;
        switch (evaluation.toLowerCase()) {
            case "excepcional":
                percentage = 30;
                break;
            case "excelente":
                percentage = 20;
                break;
            case "bueno":
                percentage = 10;
                break;
            default:
                System.out.println("Evaluación no válida");
                return;
        }
        assignBonus(percentage, true);
    }

    // ====== MÉTODOS PROPIOS ======

    public String getLeadershipLevel() {
        if (teamSize < 5) return "Supervisor";
        else if (teamSize < 10) return "Gerente de Equipo";
        else if (teamSize < 20) return "Gerente de Área";
        else return "Gerente General";
    }

    public double calculateLeadershipBonus() {
        return baseSalary * 0.05 * teamSize;
    }

    public void addTeamMember() {
        teamSize++;
        System.out.println(name + " ahora lidera " + teamSize + " personas");
    }

    public double calculateTotalBonuses() {
        return calculateSalary() - baseSalary - (baseSalary * 0.02 * yearsOfService);
    }

    @Override
    public String toString() {
        return "Manager2{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", senior=" + seniorManager +
                ", level='" + getLeadershipLevel() + '\'' +
                '}';
    }
}
