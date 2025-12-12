/**
 * Clase Mesero - Semana 03 con Encapsulación Completa
 */
public class Waiter2 {
    // ====== ATRIBUTOS PRIVADOS ======
    private String name;
    private String id;
    private int yearsExperience;
    private String shift; // Mañana, Tarde, Noche
    private double baseSalary;
    private boolean active;

    // ====== CONSTRUCTORES SOBRECARGADOS ======

    /**
     * Constructor completo
     */
    public Waiter2(String name, String id, int yearsExperience, String shift, double baseSalary, boolean active) {
        setName(name);
        setId(id);
        setYearsExperience(yearsExperience);
        setShift(shift);
        setBaseSalary(baseSalary);
        this.active = active;
    }

    /**
     * Constructor sin salario (calcula salario base según experiencia)
     */
    public Waiter2(String name, String id, int yearsExperience, String shift, boolean active) {
        this(name, id, yearsExperience, shift, calculateDefaultSalary(yearsExperience), active);
    }

    /**
     * Constructor básico (activo por defecto)
     */
    public Waiter2(String name, String id, int yearsExperience, String shift) {
        this(name, id, yearsExperience, shift, true);
    }

    /**
     * Constructor mínimo (turno Mañana por defecto)
     */
    public Waiter2(String name, String id, int yearsExperience) {
        this(name, id, yearsExperience, "Mañana", true);
    }

    // ====== MÉTODO ESTÁTICO AUXILIAR ======

    /**
     * Calcula salario base según años de experiencia
     */
    private static double calculateDefaultSalary(int years) {
        double baseSalary = 1300000; // Salario mínimo Colombia 2024
        if (years >= 5) {
            return baseSalary * 1.5;
        } else if (years >= 3) {
            return baseSalary * 1.3;
        } else if (years >= 1) {
            return baseSalary * 1.1;
        }
        return baseSalary;
    }

    // ====== GETTERS ======

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getYearsExperience() {
        return yearsExperience;
    }

    public String getShift() {
        return shift;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public boolean isActive() {
        return active;
    }

    // ====== SETTERS CON VALIDACIONES ======

    public void setName(String name) {
        if (!isValidString(name)) {
            throw new IllegalArgumentException("Nombre no puede estar vacío");
        }
        if (name.length() < 3) {
            throw new IllegalArgumentException("Nombre debe tener al menos 3 caracteres");
        }
        this.name = name;
    }

    public void setId(String id) {
        if (!isValidString(id)) {
            throw new IllegalArgumentException("ID no puede estar vacío");
        }
        if (!isValidId(id)) {
            throw new IllegalArgumentException("ID debe tener formato M### (ej: M001)");
        }
        this.id = id;
    }

    public void setYearsExperience(int yearsExperience) {
        if (yearsExperience < 0) {
            throw new IllegalArgumentException("Años de experiencia no pueden ser negativos");
        }
        if (yearsExperience > 50) {
            throw new IllegalArgumentException("Años de experiencia no pueden exceder 50 años");
        }
        this.yearsExperience = yearsExperience;
    }

    public void setShift(String shift) {
        if (!isValidString(shift)) {
            throw new IllegalArgumentException("Turno no puede estar vacío");
        }
        if (!isValidShift(shift)) {
            throw new IllegalArgumentException("Turno inválido. Use: Mañana, Tarde, o Noche");
        }
        this.shift = shift;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 1300000) {
            throw new IllegalArgumentException("Salario no puede ser menor al mínimo legal ($1,300,000)");
        }
        if (baseSalary > 10000000) {
            throw new IllegalArgumentException("Salario base no puede exceder $10,000,000");
        }
        this.baseSalary = baseSalary;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    // ====== MÉTODOS PRIVADOS AUXILIARES ======

    private boolean isValidString(String str) {
        return str != null && !str.trim().isEmpty();
    }

    /**
     * Valida formato de ID (debe ser M### donde # es dígito)
     */
    private boolean isValidId(String id) {
        return id.matches("M\\d{3}"); // M seguido de 3 dígitos
    }

    /**
     * Valida que el turno sea válido
     */
    private boolean isValidShift(String shift) {
        String[] validShifts = {"Mañana", "Tarde", "Noche"};
        for (String valid : validShifts) {
            if (valid.equalsIgnoreCase(shift)) {
                return true;
            }
        }
        return false;
    }

    private String formatSalary() {
        return String.format("$%,.0f", baseSalary);
    }

    // ====== MÉTODOS DE NEGOCIO ======

    /**
     * Retorna nivel de experiencia
     */
    public String getExperienceLevel() {
        if (yearsExperience < 1) {
            return "Principiante";
        } else if (yearsExperience < 3) {
            return "Intermedio";
        } else if (yearsExperience < 5) {
            return "Avanzado";
        } else {
            return "Experto";
        }
    }

    /**
     * Calcula salario con bonificación por propinas (estimado)
     */
    public double calculateTotalSalary(double tips) {
        if (tips < 0) {
            throw new IllegalArgumentException("Propinas no pueden ser negativas");
        }
        return baseSalary + tips;
    }

    /**
     * Verifica si es elegible para bono
     */
    public boolean isEligibleForBonus() {
        return yearsExperience >= 3 && active;
    }

    public void showInfo() {
        System.out.println("=== MESERO ===");
        System.out.println("Nombre: " + name);
        System.out.println("ID: " + id);
        System.out.println("Experiencia: " + yearsExperience + " años (" + getExperienceLevel() + ")");
        System.out.println("Turno: " + shift);
        System.out.println("Salario base: " + formatSalary());
        System.out.println("Estado: " + (active ? "Activo" : "Inactivo"));
        System.out.println("Elegible para bono: " + (isEligibleForBonus() ? "Sí" : "No"));
    }

    @Override
    public String toString() {
        return "Waiter{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", yearsExperience=" + yearsExperience +
                ", shift='" + shift + '\'' +
                '}';
    }
}
