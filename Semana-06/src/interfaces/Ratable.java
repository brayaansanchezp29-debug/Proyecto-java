package interfaces;

/**
 * Interface: Ratable
 * Define el contrato para productos que pueden ser calificados
 */
public interface Ratable {

    /**
     * Agrega una calificación al producto
     * @param rating Calificación (1-5 estrellas)
     * @param comment Comentario opcional
     */
    void addRating(int rating, String comment);

    /**
     * Obtiene el promedio de calificaciones
     */
    double getAverageRating();

    /**
     * Obtiene el número total de calificaciones
     */
    int getTotalRatings();

    /**
     * Verifica si el producto tiene buenas calificaciones
     */
    boolean hasGoodRatings();
}
