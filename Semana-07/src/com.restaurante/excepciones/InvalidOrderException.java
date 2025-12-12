package com.restaurante.excepciones;

/**
 * Excepción lanzada cuando un pedido es inválido
 * Puede ser por cantidad negativa, total inválido, o datos faltantes
 */
public class InvalidOrderException extends Exception {

    /**
     * Constructor con mensaje
     * @param mensaje Descripción del error
     */
    public InvalidOrderException(String mensaje) {
        super(mensaje);
    }

    /**
     * Constructor con mensaje y causa
     * @param mensaje Descripción del error
     * @param causa Excepción que causó este error
     */
    public InvalidOrderException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}