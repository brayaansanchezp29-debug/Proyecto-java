/**
 * Subclase: Manager (Gerente)
 * Hereda de Employee y representa al gerente del restaurante
 */
public class Manager extends Employee {
    // ====== ATRIBUTOS PROPIOS ======
    private String department;          // Departamento que maneja
    private int teamSize;               // Tamaño del equipo a cargo
    private double performanceBonus;    // Bono por desempeño
    private boolean seniorManager;      // ¿Es gerente senior?

    // ====== CONSTRUCTORES ======

    /**
     * Constructor completo
     */
    public Manager(String name, String id, double baseSalary, int yearsOfService,
                   String department, int teamSize, double performanceBonus, boolean seniorManager) {
        super(name, id, baseSalary, yearsOfService);  // Llama al constructor padre
        this.department = department;
        this.teamSize = teamSize;
        this.performanceBonus = performanceBonus;
        this.seniorManager = seniorManager;
    }

    /**
     * Constructor sin bono de desempeño (nuevo gerente)
     */
    public Manager(String name, String id, double baseSalary, int yearsOfService,
                   String department, int teamSize, boolean seniorManager) {
        this(name, id, baseSalary, yearsOfService, department, teamSize, 0.0, seniorManager);
    }

    /**
     * Constructor básico (gerente junior)
     */
    public Manager(String name, String id, double baseSalary, String department, int teamSize) {
        this(name, id, baseSalary, 0, department, teamSize, 0.0, false);
    }

    // ====== GETTERS Y SETTERS ======

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        if (teamSize >= 0) {
            this.teamSize = teamSize;
        }
    }

    public double getPerformanceBonus() {
        return performanceBonus;
    }

    public void setPerformanceBonus(double performanceBonus) {
        if (performanceBonus >= 0) {
            this.performanceBonus = performanceBonus;
        }
    }

    public boolean isSeniorManager() {
        return seniorManager;
    }

    public void setSeniorManager(boolean seniorManager) {
        this.seniorManager = seniorManager;
    }

    // ====== MÉTODOS SOBRESCRITOS ======

    /**
     * Sobrescribe el cálculo de salario para incluir bonos gerenciales
     */
    @Override
    public double calculateSalary() {
        double baseSalary = super.calculateSalary(); // Llama al método padre

        // Bono por liderazgo (5% por cada miembro del equipo)
        double leadershipBonus = this.baseSalary * 0.05 * teamSize;

        // Bono adicional si es gerente senior (30%)
        double seniorBonus = seniorManager ? this.baseSalary * 0.30 : 0;

        // Agregar bono de desempeño
        double totalSalary = baseSalary + leadershipBonus + seniorBonus + performanceBonus;

        return totalSalary;
    }

    /**
     * Sobrescribe showInfo para mostrar información específica del gerente
     */
    @Override
    public void showInfo() {
        System.out.println("=== GERENTE ===");
        System.out.println("Nombre: " + name);
        System.out.println("ID: " + id);
        System.out.println("Departamento: " + department);
        System.out.println("Posición: " + (seniorManager ? "Gerente Senior" : "Gerente"));
        System.out.println("Años de servicio: " + yearsOfService);
        System.out.println("Tamaño del equipo: " + teamSize + " personas");
        System.out.println("Bono por desempeño: $" + String.format("%,.0f", performanceBonus));
        System.out.println("Salario Base: $" + String.format("%,.0f", baseSalary));
        System.out.println("Salario Total: $" + String.format("%,.0f", calculateSalary()));
        System.out.println("Días de vacaciones: " + calculateVacationDays());
        System.out.println("Nivel de liderazgo: " + getLeadershipLevel());
        System.out.println("Estado: " + (active ? "Activo" : "Inactivo"));
    }

    /**
     * Sobrescribe el tipo de empleado
     */
    @Override
    public String getEmployeeType() {
        return seniorManager ? "Gerente Senior - " + department : "Gerente - " + department;
    }

    /**
     * Los gerentes tienen más días de vacaciones
     */
    @Override
    public int calculateVacationDays() {
        int baseDays = super.calculateVacationDays();
        int managerBonus = seniorManager ? 5 : 3; // Días extras por ser gerente
        return baseDays + managerBonus;
    }

    // ====== MÉTODOS PROPIOS ======

    /**
     * Determina el nivel de liderazgo
     */
    public String getLeadershipLevel() {
        if (teamSize < 5) {
            return "Supervisor";
        } else if (teamSize < 10) {
            return "Gerente de Equipo";
        } else if (teamSize < 20) {
            return "Gerente de Área";
        } else {
            return "Gerente General";
        }
    }

    /**
     * Calcula el bono de liderazgo
     */
    public double calculateLeadershipBonus() {
        return baseSalary * 0.05 * teamSize;
    }

    /**
     * Agrega miembro al equipo
     */
    public void addTeamMember() {
        teamSize++;
        System.out.println(name + " ahora lidera un equipo de " + teamSize + " personas");
    }

    /**
     * Remueve miembro del equipo
     */
    public void removeTeamMember() {
        if (teamSize > 0) {
            teamSize--;
            System.out.println(name + " ahora lidera un equipo de " + teamSize + " personas");
        }
    }

    /**
     * Asigna bono por desempeño
     */
    public void assignPerformanceBonus(double amount) {
        if (amount > 0) {
            this.performanceBonus = amount;
            System.out.println("Bono de $" + String.format("%,.0f", amount) +
                    " asignado a " + name);
        }
    }

    /**
     * Calcula el total de bonos del gerente
     */
    public double calculateTotalBonuses() {
        return calculateSalary() - baseSalary - (baseSalary * 0.02 * yearsOfService);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", senior=" + seniorManager +
                ", teamSize=" + teamSize +
                ", level='" + getLeadershipLevel() + '\'' +
                '}';
    }
}
