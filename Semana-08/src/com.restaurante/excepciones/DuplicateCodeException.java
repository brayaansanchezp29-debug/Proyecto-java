package com.restaurante.excepciones;

/**
 * Excepción cuando se intenta agregar un código duplicado
 */
public class DuplicateCodeException extends Exception {
    public DuplicateCodeException(String mensaje) {
        super(mensaje);
    }
}
