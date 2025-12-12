package com.restaurante.excepciones;

/**
 * Excepción lanzada cuando un plato no está disponible
 * Puede ser por estar agotado, fuera de menú o en preparación
 */
public class DishNotAvailableException extends Exception {

    /**
     * Constructor con mensaje
     * @param mensaje Descripción del error
     */
    public DishNotAvailableException(String mensaje) {
        super(mensaje);
    }

    /**
     * Constructor con mensaje y causa
     * @param mensaje Descripción del error
     * @param causa Excepción que causó este error
     */
    public DishNotAvailableException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
