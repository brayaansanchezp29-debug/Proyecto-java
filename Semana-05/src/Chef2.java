/**
 * Subclase: Chef2
 * Versión mejorada con sobrescritura de métodos
 */
public class Chef2 extends Employee2 {
    // ====== ATRIBUTOS PROPIOS ======
    private String specialty;
    private int dishesCreated;
    private boolean headChef;

    // ====== CONSTRUCTORES ======

    public Chef2(String name, String id, double baseSalary, int yearsOfService,
                 String specialty, int dishesCreated, boolean headChef) {
        super(name, id, baseSalary, yearsOfService);
        this.specialty = specialty;
        this.dishesCreated = dishesCreated;
        this.headChef = headChef;
    }

    public Chef2(String name, String id, double baseSalary, int yearsOfService,
                 String specialty, boolean headChef) {
        this(name, id, baseSalary, yearsOfService, specialty, 0, headChef);
    }

    public Chef2(String name, String id, double baseSalary, String specialty) {
        this(name, id, baseSalary, 0, specialty, 0, false);
    }

    // ====== GETTERS Y SETTERS ======

    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }

    public int getDishesCreated() { return dishesCreated; }
    public void setDishesCreated(int dishesCreated) {
        if (dishesCreated >= 0) {
            this.dishesCreated = dishesCreated;
        }
    }

    public boolean isHeadChef() { return headChef; }
    public void setHeadChef(boolean headChef) { this.headChef = headChef; }

    // ====== SOBRESCRITURA DE MÉTODOS (@Override) ======

    /**
     * Sobrescribe cálculo de salario para incluir bonos de chef
     */
    @Override
    public double calculateSalary() {
        double baseSalary = super.calculateSalary();
        double specialtyBonus = this.baseSalary * 0.15;
        double headChefBonus = headChef ? this.baseSalary * 0.25 : 0;
        double productivityBonus = (dishesCreated / 100) * 50000;
        return baseSalary + specialtyBonus + headChefBonus + productivityBonus;
    }

    /**
     * Sobrescribe showInfo
     */
    @Override
    public void showInfo() {
        System.out.println("=== CHEF ===");
        System.out.println("Nombre: " + name);
        System.out.println("ID: " + id);
        System.out.println("Especialidad: " + specialty);
        System.out.println("Posición: " + (headChef ? "Chef Principal" : "Chef"));
        System.out.println("Años de servicio: " + yearsOfService);
        System.out.println("Platos preparados: " + dishesCreated);
        System.out.println("Nivel: " + getExperienceLevel());
        System.out.println("Salario Base: $" + formatMoney(baseSalary));
        System.out.println("Salario Total: $" + formatMoney(calculateSalary()));
        System.out.println("Días de vacaciones: " + calculateVacationDays());
        System.out.println("Estado: " + (active ? "Activo" : "Inactivo"));
    }

    /**
     * Sobrescribe getDescription
     */
    @Override
    public String getDescription() {
        return (headChef ? "Chef Principal: " : "Chef: ") + name +
                " - Especialidad: " + specialty +
                " (" + yearsOfService + " años)";
    }

    /**
     * Sobrescribe getEmployeeType
     */
    @Override
    public String getEmployeeType() {
        return headChef ? "Chef Principal" : "Chef";
    }

    /**
     * Sobrescribe calculateBonus - Chefs tienen bonos diferentes
     */
    @Override
    public double calculateBonus() {
        // Chefs obtienen 20% de bono base
        return baseSalary * 0.20;
    }

    /**
     * Sobrescribe calculateBonus con porcentaje
     */
    @Override
    public double calculateBonus(double percentage) {
        double bonus = super.calculateBonus(percentage);
        // Chefs principales obtienen 10% adicional
        if (headChef) {
            bonus += baseSalary * 0.10;
        }
        return bonus;
    }

    // ====== SOBRECARGA DE MÉTODOS PROPIOS ======

    /**
     * SOBRECARGA: Registrar plato preparado
     */
    public void registerDish() {
        dishesCreated++;
        if (dishesCreated % 100 == 0) {
            System.out.println("¡" + name + " alcanzó " + dishesCreated + " platos!");
        }
    }

    /**
     * SOBRECARGA: Registrar múltiples platos
     */
    public void registerDish(int quantity) {
        if (quantity > 0) {
            dishesCreated += quantity;
            System.out.println(name + " registró " + quantity + " platos. Total: " + dishesCreated);
        }
    }

    /**
     * SOBRECARGA: Registrar plato con detalles
     */
    public void registerDish(String dishName, int quantity) {
        dishesCreated += quantity;
        System.out.println(name + " preparó " + quantity + "x " + dishName +
                ". Total platos: " + dishesCreated);
    }

    // ====== MÉTODOS PROPIOS ======

    public String getExperienceLevel() {
        if (yearsOfService < 2) return "Junior";
        else if (yearsOfService < 5) return "Semi-Senior";
        else if (yearsOfService < 10) return "Senior";
        else return "Master Chef";
    }

    public double calculateMonthlyBonus() {
        return calculateSalary() - baseSalary;
    }

    @Override
    public String toString() {
        return "Chef2{" +
                "name='" + name + '\'' +
                ", specialty='" + specialty + '\'' +
                ", headChef=" + headChef +
                ", level='" + getExperienceLevel() + '\'' +
                '}';
    }
}