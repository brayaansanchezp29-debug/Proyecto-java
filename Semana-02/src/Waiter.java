
/**
 * Clase Mesero - Empleado que atiende a los clientes
 * @author Brayan Alejandro Sanchez Pedroza
 */
public class Waiter {
    private String name;
    private String id;
    private int yearsExperience;
    private String shift; // Mañana, Tarde, Noche

    public Waiter(String name, String id, int yearsExperience, String shift) {
        this.name = name;
        this.id = id;
        this.yearsExperience = yearsExperience;
        this.shift = shift;
    }

    // Método de negocio
    public String getExperienceLevel() {
        if (yearsExperience < 1) {
            return "Principiante";
        } else if (yearsExperience < 3) {
            return "Intermedio";
        } else {
            return "Experimentado";
        }
    }

    public void showInfo() {
        System.out.println("=== MESERO ===");
        System.out.println("Nombre: " + name);
        System.out.println("ID: " + id);
        System.out.println("Experiencia: " + yearsExperience + " años (" + getExperienceLevel() + ")");
        System.out.println("Turno: " + shift);
    }

    // Getters y Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public int getYearsExperience() { return yearsExperience; }
    public void setYearsExperience(int yearsExperience) { this.yearsExperience = yearsExperience; }

    public String getShift() { return shift; }
    public void setShift(String shift) { this.shift = shift; }
}
