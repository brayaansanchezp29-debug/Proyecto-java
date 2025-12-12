/**
 * Subclase: Chef (Cocinero)
 * Hereda de Employee y representa a un cocinero del restaurante
 */
public class Chef extends Employee {
    // ====== ATRIBUTOS PROPIOS ======
    private String specialty;        // Especialidad culinaria
    private int dishesCreated;       // Platos creados/preparados
    private boolean headChef;        // ¿Es chef principal?

    // ====== CONSTRUCTORES ======

    /**
     * Constructor completo
     */
    public Chef(String name, String id, double baseSalary, int yearsOfService,
                String specialty, int dishesCreated, boolean headChef) {
        super(name, id, baseSalary, yearsOfService);  // Llama al constructor padre
        this.specialty = specialty;
        this.dishesCreated = dishesCreated;
        this.headChef = headChef;
    }

    /**
     * Constructor sin platos creados (nuevo chef)
     */
    public Chef(String name, String id, double baseSalary, int yearsOfService,
                String specialty, boolean headChef) {
        this(name, id, baseSalary, yearsOfService, specialty, 0, headChef);
    }

    /**
     * Constructor básico (no es chef principal)
     */
    public Chef(String name, String id, double baseSalary, String specialty) {
        this(name, id, baseSalary, 0, specialty, 0, false);
    }

    // ====== GETTERS Y SETTERS ======

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getDishesCreated() {
        return dishesCreated;
    }

    public void setDishesCreated(int dishesCreated) {
        if (dishesCreated >= 0) {
            this.dishesCreated = dishesCreated;
        }
    }

    public boolean isHeadChef() {
        return headChef;
    }

    public void setHeadChef(boolean headChef) {
        this.headChef = headChef;
    }

    // ====== MÉTODOS SOBRESCRITOS ======

    /**
     * Sobrescribe el cálculo de salario para incluir bonos de chef
     */
    @Override
    public double calculateSalary() {
        double baseSalary = super.calculateSalary(); // Llama al método padre

        // Bono por especialidad
        double specialtyBonus = this.baseSalary * 0.15;

        // Bono adicional si es chef principal
        double headChefBonus = headChef ? this.baseSalary * 0.25 : 0;

        // Bono por productividad (por cada 100 platos)
        double productivityBonus = (dishesCreated / 100) * 50000;

        return baseSalary + specialtyBonus + headChefBonus + productivityBonus;
    }

    /**
     * Sobrescribe showInfo para mostrar información específica del chef
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
        System.out.println("Salario Base: $" + String.format("%,.0f", baseSalary));
        System.out.println("Salario Total: $" + String.format("%,.0f", calculateSalary()));
        System.out.println("Días de vacaciones: " + calculateVacationDays());
        System.out.println("Estado: " + (active ? "Activo" : "Inactivo"));
    }

    /**
     * Sobrescribe el tipo de empleado
     */
    @Override
    public String getEmployeeType() {
        return headChef ? "Chef Principal" : "Chef";
    }

    // ====== MÉTODOS PROPIOS ======

    /**
     * Registra un plato preparado
     */
    public void registerDishPrepared() {
        dishesCreated++;
        if (dishesCreated % 100 == 0) {
            System.out.println("¡" + name + " ha alcanzado " + dishesCreated + " platos preparados!");
        }
    }

    /**
     * Muestra el nivel de experiencia del chef
     */
    public String getExperienceLevel() {
        if (yearsOfService < 2) {
            return "Junior";
        } else if (yearsOfService < 5) {
            return "Semi-Senior";
        } else if (yearsOfService < 10) {
            return "Senior";
        } else {
            return "Master Chef";
        }
    }

    /**
     * Calcula el bono mensual del chef
     */
    public double calculateMonthlyBonus() {
        return calculateSalary() - baseSalary;
    }

    @Override
    public String toString() {
        return "Chef{" +
                "name='" + name + '\'' +
                ", specialty='" + specialty + '\'' +
                ", headChef=" + headChef +
                ", level='" + getExperienceLevel() + '\'' +
                '}';
    }
}
