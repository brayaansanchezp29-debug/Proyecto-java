# Análisis de Diseño - Semana 06

**Dominio:** Restaurante Sabores del Valle  
**Estudiante:** Brayan Alejandro Sanchez Pedroza

---

## 1. Clase Abstracta: Product

### ¿Por qué es abstracta?

**Product** representa cualquier producto del restaurante (platos, bebidas, postres). Es abstracta porque:

- Define comportamiento común (precio, disponibilidad, mostrar info básica)
- Cada tipo de producto calcula su costo de forma diferente
- No tiene sentido instanciar un "Product" genérico
- Cada subclase debe implementar sus métodos específicos

### Métodos Abstractos

1. `calculateTotalCost()` - Cada producto calcula costos de forma diferente
2. `getDetailedDescription()` - Cada producto tiene información específica
3. `isReadyToServe()` - La lógica varía por tipo de producto

### Métodos Concretos

1. `showBasicInfo()` - Todos muestran nombre, precio, disponibilidad igual
2. `calculatePriceWithTax()` - IVA es igual para todos
3. `toggleAvailability()` - Lógica común
4. `isEconomical()` - Criterio común (<$20000)

---

## 2. Interfaces

### Preparable
**Capacidad:** Productos que requieren preparación en cocina

**Implementan:**
- `Dish5`: Requiere preparación en cocina
- `Dessert`: Requiere preparación en repostería

**No implementa:**
- `Beverage`: No requiere preparación significativa

---

### Deliverable
**Capacidad:** Productos que pueden ser entregados a domicilio

**Implementan:**
- `Dish5`: Se puede entregar con cuidado
- `Beverage`: Se puede entregar
- `Dessert`: Se puede entregar refrigerado

---

### Discountable
**Capacidad:** Productos elegibles para descuentos

**Implementan:**
- `Dish5`: Platos costosos pueden tener descuento
- `Beverage`: Bebidas pueden tener descuento limitado

**No implementa:**
- `Dessert`: Postres no entran en promociones (decisión de negocio)

---

### Ratable
**Capacidad:** Productos que clientes pueden calificar

**Implementan:**
- `Dish5`: Platos reciben calificaciones
- `Dessert`: Postres reciben calificaciones

**No implementa:**
- `Beverage`: Bebidas no se califican (son estándar)

---

## 3. Clase Abstracta vs Interface

### Elegí Clase Abstracta (Product) porque:
- ✅ Relación "es-un" clara (Dish5 ES UN Product)
- ✅ Comparten estado (name, price, available)
- ✅ Hay comportamiento común implementable (showBasicInfo)
- ✅ Jerarquía clara y única

### Elegí Interfaces porque:
- ✅ Capacidades independientes de jerarquía
- ✅ Una clase puede tener múltiples capacidades
- ✅ No todas las clases tienen todas las capacidades
- ✅ Definen contratos, no implementación

---

## 4. Principios SOLID

### Single Responsibility (SRP) ✅
- `Product`: Solo gestiona datos básicos de productos
- `Preparable`: Solo define comportamiento de preparación
- `Deliverable`: Solo define comportamiento de entrega
- Cada clase/interface tiene una responsabilidad única

### Open/Closed (OCP) ✅
- Abierto a extensión: Puedo agregar `Appetizer`, `Sauce`, etc.
- Cerrado a modificación: No necesito cambiar `Product` para agregar nuevos productos

### Liskov Substitution (LSP) ✅
- Cualquier `Product` puede sustituirse por `Dish5`, `Beverage`, o `Dessert`
- El polimorfismo funciona correctamente

### Interface Segregation (ISP) ✅
- Interfaces pequeñas y específicas
- `Beverage` no está obligada a implementar `Preparable`
- Cada clase implementa solo lo que necesita

### Dependency Inversion (DIP) ✅
- Código depende de abstracciones (`Product`, interfaces)
- No depende de implementaciones concretas

---

## 5. Mejoras Logradas

### Antes (Semana 05)
- Clases concretas independientes
- Código duplicado en métodos similares
- Sin contratos claros

### Después (Semana 06)
- ✅ Jerarquía clara con `Product`
- ✅ Comportamiento común reutilizado
- ✅ Interfaces definen contratos claros
- ✅ Múltiple implementación permite flexibilidad
- ✅ Fácil agregar nuevos productos

---

## 6. Desafíos y Soluciones

**Desafío 1:** Decidir qué métodos deben ser abstractos vs concretos

**Solución:** Abstracto = comportamiento variable por subclase. Concreto = comportamiento común a todas.

**Desafío 2:** Decidir cuándo usar interface vs agregar a clase abstracta

**Solución:** Si la capacidad es opcional o cruzada entre tipos, usar interface.

---

## ✅ **Estructura Final Semana 06**
```
semana-06/
├── abstractas/
│   └── Product.java           ✅ Clase abstracta
├── interfaces/
│   ├── Preparable.java        ✅ Interface
│   ├── Deliverable.java       ✅ Interface
│   ├── Discountable.java      ✅ Interface
│   └── Ratable.java           ✅ Interface
├── implementaciones/
│   ├── Dish5.java             ✅ 4 interfaces
│   ├── Beverage.java          ✅ 2 interfaces
│   └── Dessert.java           ✅ 3 interfaces
├── Main6.java                 ✅ Demostración completa
├── README.md                  ✅ Guía
└── ANALISIS.md                ✅ Documentación de diseño