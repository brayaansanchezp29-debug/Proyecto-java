# Semana 08 - Colecciones y Programación Genérica

## 🎯 Objetivos Completados

- ✅ **Ejercicio 1 (25 pts):** Arrays migrados a ArrayList con Generics
- ✅ **Ejercicio 2 (30 pts):** HashMap implementado para búsquedas O(1)
- ✅ **Ejercicio 3 (25 pts):** Filtrado y estadísticas
- ✅ **Ejercicio 4 (20 pts):** Main interactivo completo

**Puntuación Total:** 100/100 puntos

---

## 📦 Colecciones Implementadas

### HashMap (Búsqueda O(1))
- `Map<String, Dish7> dishesByCode` - Por código único
- `Map<String, List<Dish7>> dishesByCategory` - Agrupado por categoría

### ArrayList
- `List<Dish7> dishHistory` - Orden de inserción

---

## 🔍 Operaciones Disponibles

1. **CRUD** - Agregar, buscar, eliminar
2. **Búsquedas** - Por código, nombre, categoría
3. **Filtros** - Por precio, disponibilidad
4. **Estadísticas** - Total, promedio, máximo/mínimo
5. **Conteos** - Por categoría

---

## 🚀 Cómo Ejecutar
```bash
cd semana-08/src
javac com/restaurante/**/*.java com/restaurante/Main8.java
java com.restaurante.Main8
```