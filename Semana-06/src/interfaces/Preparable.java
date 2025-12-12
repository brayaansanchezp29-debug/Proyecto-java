package interfaces;

/**
 * Interface: Preparable
 * Define el contrato para productos que requieren preparación
 */
public interface Preparable {

    /**
     * Inicia la preparación del producto
     */
    void startPreparation();

    /**
     * Completa la preparación del producto
     */
    void finishPreparation();

    /**
     * Obtiene el tiempo estimado de preparación en minutos
     */
    int getPreparationTime();

    /**
     * Verifica si el producto está en preparación
     */
    boolean isInPreparation();

    /**
     * Obtiene el estado actual de preparación
     */
    String getPreparationStatus();
}