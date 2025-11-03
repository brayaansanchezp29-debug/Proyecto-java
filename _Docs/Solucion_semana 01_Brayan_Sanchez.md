### Actividad 1: Identificación de Objetos
Primero, identificamos 5 objetos principales del restaurante:

1. **Reserva**

¿Qué es?: Es la forma por el cual el cliente aparta una mesa antes de llegar al restaurante
Características: nombre, fecha, precio, hora, disponibilidad
Comportamientos: Mostrar disponibilidad de la mesa

2. **Mesero**

¿Qué es?: Empleado encargado de atender a los clientes y tomar pedidos
Características: nombre, identificación, turno, años de experiencia, propinas acumuladas
Comportamientos: tomar pedido, servir plato, calcular propinas, asignar mesa

3. **Mesa**

¿Qué es?: Espacio donde se ubican los clientes para consumir
Características: número, capacidad, estado (ocupada/libre), ubicación (interior/exterior)
Comportamientos: ocupar mesa, liberar mesa, verificar disponibilidad

4. **Cliente**

¿Qué es?: Persona que visita el restaurante para consumir alimentos
Características: nombre, teléfono, tipo (regular/nuevo), preferencias alimenticias
Comportamientos: hacer reserva, realizar pedido, pagar cuenta, dejar reseña

5. **Pedido**

¿Qué es?: Solicitud de uno o varios platos realizada por un cliente
Características: número de pedido, fecha/hora, mesa asignada, estado (en preparación/listo/entregado), total
Comportamientos: agregar plato, calcular total, aplicar descuento, cambiar estado

### Actividad 2: Comparación de Paradigmas (Ejercicio 02)
1. **Programación estructurada**
   **// Variables sueltas para cada plato**
   String plato1_nombre = "Bandeja Paisa";
   String plato1_categoria = "Plato Fuerte";
   double plato1_precio = 28000;

String plato2_nombre = "Ajiaco";
String plato2_categoria = "Sopa";
double plato2_precio = 22000;

**// Funciones separadas**
void mostrarPlato(String nombre, String categoria, double precio) {
print(nombre + " - " + categoria + " - $" + precio);
}

double calcularDescuento(double precio, double porcentaje) {
return precio - (precio * porcentaje / 100);
}


**Problemas:**
- Muchas variables sueltas difíciles de mantener
- No hay relación clara entre datos
- Difícil escalar cuando hay muchos platos

2. **Programación orientada a objetos**

class Plato {
String nombre;
String categoria;
double precio;

    void mostrarInfo() { ... }
    double calcularDescuento(double porcentaje) { ... }
}

Plato plato1 = new Plato("Bandeja Paisa", "Plato Fuerte", 28000);
Plato plato2 = new Plato("Ajiaco", "Sopa", 22000);