package com.restaurante.excepciones;

/**
 * Excepción cuando no se encuentra un plato
 */
public class DishNotFoundException extends Exception {
    public DishNotFoundException(String mensaje) {
        super(mensaje);
    }
}
