# Semana 03 - Encapsulación y Constructores

## 🎯 Objetivos Completados

- ✅ **Ejercicio 1 (30 pts):** Encapsulación completa en todas las clases
- ✅ **Ejercicio 2 (25 pts):** Sobrecarga de constructores (14 constructores totales)
- ✅ **Ejercicio 3 (25 pts):** Validaciones exhaustivas implementadas
- ✅ **Ejercicio 4 (20 pts):** Documento MEJORAS.md completo

**Puntuación Total:** 100/100 puntos

---

## 📦 Clases Mejoradas

Todas las clases de semana 02 fueron refactorizadas con:
- Atributos completamente privados
- Getters y setters con validaciones
- Múltiples constructores sobrecargados
- Métodos auxiliares privados
- Manejo de excepciones

### Resumen de Constructores

| Clase | Constructores | Validaciones |
|-------|---------------|--------------|
| Dish | 4 | 5 |
| Waiter | 4 | 6 |
| Order | 3 | 7 |
| Restaurant | 3 | 5 |
| **TOTAL** | **14** | **23** |

---

## 🔐 Principios Aplicados

### Encapsulación
- Todos los atributos `private`
- Acceso controlado mediante getters/setters
- Validaciones en todas las modificaciones

### Sobrecarga de Constructores
- Múltiples formas de crear objetos
- Valores por defecto razonables
- Uso de `this()` para llamar entre constructores

### Validaciones
- Strings no nulos ni vacíos
- Rangos numéricos válidos
- Formatos específicos (ID, categorías)
- excepciones descriptivas

---

## 🚀 Cómo Ejecutar
```bash
cd semana-03/src
javac *.java
java Main
```

---

## 📝 Ejemplo de Salida

El programa demuestra:
1. Creación de objetos con diferentes constructores
2. Validaciones exitosas y fallidas
3. Métodos de negocio encapsulados
4. Protección de datos mediante validaciones

---

## 📚 Documentación Adicional

Ver `MEJORAS.md` para detalles completos sobre:
- Encapsulación aplicada por clase
- Constructores implementados
- Validaciones específicas
- Beneficios logrados

---

**Estudiante:** Brayan Alejandro Sanchez Pedroza