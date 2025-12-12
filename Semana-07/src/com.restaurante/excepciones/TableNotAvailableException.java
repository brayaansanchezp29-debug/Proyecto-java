package com.restaurante.excepciones;

/**
 * Excepción lanzada cuando una mesa no está disponible
 * Puede ser por estar ocupada, reservada, o número inválido
 */
public class TableNotAvailableException extends Exception {

    /**
     * Constructor con mensaje
     * @param mensaje Descripción del error
     */
    public TableNotAvailableException(String mensaje) {
        super(mensaje);
    }

    /**
     * Constructor con mensaje y causa
     * @param mensaje Descripción del error
     * @param causa Excepción que causó este error
     */
    public TableNotAvailableException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}