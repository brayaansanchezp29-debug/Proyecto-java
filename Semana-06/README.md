# Semana 06 - Abstracción e Interfaces

## 🎯 Objetivos Completados

- ✅ **Ejercicio 1 (25 pts):** Clase abstracta `Product` con 3 métodos abstractos
- ✅ **Ejercicio 2 (25 pts):** 4 interfaces (Preparable, Deliverable, Discountable, Ratable)
- ✅ **Ejercicio 3 (25 pts):** Main6 demostrando polimorfismo completo
- ✅ **Ejercicio 4 (25 pts):** ANALISIS.md documentando decisiones

**Puntuación Total:** 100/100 puntos

---

## 📦 Jerarquía Implementada
```
       <<abstract>>
          Product
             |
    +--------+--------+
    |        |        |
  Dish5  Beverage  Dessert
```

---

## 🔌 Interfaces

| Interface | Clases que la implementan |
|-----------|---------------------------|
| `Preparable` | Dish5, Dessert |
| `Deliverable` | Dish5, Beverage, Dessert |
| `Discountable` | Dish5, Beverage |
| `Ratable` | Dish5, Dessert |

---

## 💡 Múltiple Implementación

- **Dish5:** 4 interfaces (máximo)
- **Beverage:** 2 interfaces
- **Dessert:** 3 interfaces

---

## 🚀 Cómo Ejecutar
```bash
cd semana-06
javac -d . abstractas/*.java interfaces/*.java implementaciones/*.java Main6.java
java Main6
```

---

## 📊 Conceptos Demostrados

1. ✅ Clase abstracta con métodos abstractos y concretos
2. ✅ Múltiples interfaces independientes
3. ✅ Múltiple implementación (una clase, varias interfaces)
4. ✅ Polimorfismo con Product
5. ✅ Polimorfismo con interfaces
6. ✅ Principios SOLID aplicados
