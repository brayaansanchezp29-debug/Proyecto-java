package interfaces;

/**
 * Interface: Deliverable
 * Define el contrato para productos que pueden ser entregados a domicilio
 */
public interface Deliverable {

    /**
     * Calcula el costo adicional de domicilio
     */
    double calculateDeliveryCost(double distance);

    /**
     * Verifica si el producto puede ser entregado
     */
    boolean canBeDelivered();

    /**
     * Empaca el producto para entrega
     */
    void packageForDelivery();

    /**
     * Obtiene instrucciones especiales de entrega
     */
    String getDeliveryInstructions();
}