# Semana 05 - Polimorfismo

## 🎯 Objetivos Completados

- ✅ **Ejercicio 1 (25 pts):** Sobrecarga de métodos (18 métodos sobrecargados)
- ✅ **Ejercicio 2 (25 pts):** Sobrescritura con @Override (18 sobrescrituras)
- ✅ **Ejercicio 3 (25 pts):** Métodos polimórficos en RestaurantHR
- ✅ **Ejercicio 4 (25 pts):** Main completo con ArrayList polimórfico

**Puntuación Total:** 100/100 puntos

---

## 📦 Clases Implementadas

### Employee2 (Clase Padre)
- **Sobrecarga:** 6 métodos con múltiples versiones
- **Métodos sobrescribibles:** calculateSalary(), showInfo(), getDescription(), etc.

### Chef2, Waiter4, Manager2 (Subclases)
- **Sobrescritura:** Todos sobrescriben calculateSalary(), showInfo(), etc.
- **Sobrecarga propia:** Cada uno tiene métodos sobrecargados específicos

### RestaurantHR (Gestora)
- **Métodos polimórficos:** 10 métodos que trabajan con Employee2
- **ArrayList polimórfico:** Gestiona cualquier tipo de empleado

---

## 🔄 Conceptos Demostrados

### 1. Sobrecarga (Overloading)
- Mismo nombre, diferentes parámetros
- **18 métodos sobrecargados** en total
- Ejemplos: increaseSalary(), registerDish(), findEmployee()

### 2. Sobrescritura (Overriding)
- @Override en todas las subclases
- **18 sobrescrituras** implementadas
- Cada subclase modifica comportamiento según su naturaleza

### 3. Polimorfismo Dinámico
- ArrayList<Employee2> contiene diferentes tipos
- Dynamic binding en tiempo de ejecución
- Métodos que aceptan Employee2 funcionan con cualquier subclase

---

## 🚀 Cómo Ejecutar
```bash
cd semana-05/src
javac *.java
java Main5
```

---

## 📊 Salida Esperada

El programa demuestra:
1. Creación de empleados de diferentes tipos
2. Uso de ArrayList polimórfico
3. Dynamic binding (mismo método, diferente comportamiento)
4. Procesamiento polimórfico de nómina
5. Sobrecarga de métodos en acción
6. Búsquedas con métodos sobrecargados
7. Uso de instanceof

---

## 📈 Estadísticas

| Métrica | Cantidad |
|---------|----------|
| Clases totales | 5 |
| Métodos sobrecargados | 18 |
| Métodos sobrescritos | 18 |
| Métodos polimórficos | 10 |
| Empleados en demo | 9 |

---

## 📚 Documentación Adicional

Ver `POLIMORFISMO.md` para:
- Tabla completa de métodos sobrecargados
- Comparación de métodos sobrescritos
- Explicación de dynamic binding
- Beneficios del polimorfismo
- Ejemplos de código

---

**Estudiante:** Brayan Alejandro Sanchez Pedroza  
**Ficha:** 3228973B  

---

## ✅ **Estructura Final Semana 05**

```
semana-05/
├── src/
│   ├── Employee2.java      ✅ Padre con sobrecarga
│   ├── Chef2.java          ✅ Subclase con sobrecarga y sobrescritura
│   ├── Waiter4.java        ✅ Subclase con sobrecarga y sobrescritura
│   ├── Manager2.java       ✅ Subclase con sobrecarga y sobrescritura
│   ├── RestaurantHR.java   ✅ Gestora polimórfica
│   └── Main5.java          ✅ Demostración completa
├── POLIMORFISMO.md         ✅ Documentación detallada
└── README.md               ✅ Guía de la semana