# Semana 02 - Clases y Objetos Avanzados

##  Trabajos Completados

-  **Ejercicio 1:** Creadas 2 nuevas clases (`Waiter`, `Order`)
-  **Ejercicio 2:** Implementadas relaciones entre objetos
-  **Ejercicio 3:** Uso de `ArrayList` en clase gestora
-  **Ejercicio 4:** Main completo demostrando funcionalidad

##  Clases Implementadas

### 1. Waiter (Mesero) - 30 puntos
**Atributos:**
- `name` - Nombre del mesero
- `id` - Identificación
- `yearsExperience` - Años de experiencia
- `shift` - Turno de trabajo

**Métodos de negocio:**
- `getExperienceLevel()` - Clasifica nivel de experiencia

### 2. Order (Pedido) - 25 puntos (Relaciones)
**Atributos:**
- `orderNumber` - Número de pedido
- `waiter` - **Relación con Waiter**
- `dish` - **Relación con Dish**
- `tableNumber` - Número de mesa
- `quantity` - Cantidad
- `status` - Estado del pedido

**Métodos de negocio:**
- `calculateTotal()` - Calcula total del pedido
- `getOrderSummary()` - Resumen del pedido

### 3. Restaurant (Gestora) - 20 puntos (ArrayList)
**Atributos:**
- `name` - Nombre del restaurante
- `location` - Ubicación
- `orders` - **ArrayList<Order>**
- `waiters` - **ArrayList<Waiter>**
- `menu` - **ArrayList<Dish>**

**Métodos:**
- `addOrder()` - Agregar pedido
- `addWaiter()` - Agregar mesero
- `addDishToMenu()` - Agregar plato
- `showAllOrders()` - Mostrar todos los pedidos
- `calculateTotalSales()` - Calcular ventas totales
- `showStatistics()` - Mostrar estadísticas

### 4. Dish (Plato) - Mejorado
Clase original de semana 1 con mejoras.

##  Relaciones Implementadas
```
Restaurant (1) ──┬── (N) Order
                 ├── (N) Waiter  
                 └── (N) Dish

Order (N) ───┬─── (1) Waiter
             └─── (1) Dish
```

##  Cómo Ejecutar
```bash
# Navegar a la carpeta
cd semana-02/src

# Compilar todas las clases
javac *.java

# Ejecutar
java Main
```

##  Funcionalidades Demostradas

1. ✅ Creación de múltiples objetos
2. ✅ Relaciones entre clases (Composición/Agregación)
3. ✅ Uso de ArrayList para gestionar colecciones
4. ✅ Métodos de negocio (cálculos, validaciones)
5. ✅ Getters y Setters completos
6. ✅ Formato profesional de salida

##  Resultados del Sistema

El programa genera:
- Lista de personal (3 meseros)
- Menú completo (5 platos)
- Registro de pedidos (5 pedidos)
- Estadísticas de ventas

**Ejemplo de salida:**
```
Total de pedidos: 5
Total de meseros: 3
Platos en menú: 5
Ventas totales: $139,000
```

##  Checklist de Cumplimiento

- [x] Mínimo 2 nuevas clases con 3+ atributos cada una
- [x] Constructores completos
- [x] Getters y setters
- [x] Al menos 1 método de negocio por clase
- [x] Relaciones entre objetos implementadas
- [x] ArrayList usado correctamente
- [x] Main completo y funcional
- [x] Código compilable sin errores
- [x] Documentación incluida

---


##  **Estructura Final del Proyecto**
```
RestauranteSaboresDelValle/
├── semana-01/
│   ├── Dish.java
│   ├── Main.java
│   └── README.md
│
├── semana-02/
│   ├── src/
│   │   ├── Dish.java
│   │   ├── Waiter.java
│   │   ├── Order.java
│   │   ├── Restaurant.java
│   │   └── Main.java
│   └── README.md
│
├── _docs/
└── .gitignore