package interfaces;

/**
 * Interface: Discountable
 * Define el contrato para productos que pueden tener descuentos
 */
public interface Discountable {

    /**
     * Aplica un descuento al producto
     * @param percentage Porcentaje de descuento (0-100)
     * @return Precio con descuento aplicado
     */
    double applyDiscount(double percentage);

    /**
     * Verifica si el producto es elegible para descuento
     */
    boolean isEligibleForDiscount();

    /**
     * Obtiene el descuento máximo permitido
     */
    double getMaximumDiscount();

    /**
     * Calcula el ahorro obtenido con el descuento
     */
    double calculateSavings(double percentage);
}
