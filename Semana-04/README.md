# Semana 04 - Herencia

## 🎯 Objetivos Completados

- ✅ **Ejercicio 1 (25 pts):** Clase padre `Employee` creada
- ✅ **Ejercicio 2 (30 pts):** 3 subclases implementadas (Chef, Waiter3, Manager)
- ✅ **Ejercicio 3 (25 pts):** Uso correcto de `extends`, `super()`, `@Override`, `protected`
- ✅ **Ejercicio 4 (20 pts):** Polimorfismo demostrado con array

**Puntuación Total:** 100/100 puntos

---

## 📦 Clases Implementadas

### Clase Padre: Employee
- **Atributos protected:** name, id, baseSalary, yearsOfService, active
- **Métodos heredables:** calculateSalary(), showInfo(), calculateVacationDays()
- **Constructores:** 2 constructores sobrecargados

### Subclases:

#### 1. Chef (Cocinero)
- **Atributos propios:** specialty, dishesCreated, headChef
- **Métodos sobrescritos:** calculateSalary(), showInfo(), getEmployeeType()
- **Métodos propios:** registerDishPrepared(), getExperienceLevel()
- **Constructores:** 3 constructores

#### 2. Waiter3 (Mesero)
- **Atributos propios:** shift, tablesServed, averageTips
- **Métodos sobrescritos:** calculateSalary(), showInfo(), getEmployeeType()
- **Métodos propios:** registerTableServed(), getServiceLevel(), getTipsPercentage()
- **Constructores:** 3 constructores

#### 3. Manager (Gerente)
- **Atributos propios:** department, teamSize, performanceBonus, seniorManager
- **Métodos sobrescritos:** calculateSalary(), showInfo(), getEmployeeType(), calculateVacationDays()
- **Métodos propios:** getLeadershipLevel(), addTeamMember(), assignPerformanceBonus()
- **Constructores:** 3 constructores

---

## 🌳 Jerarquía
```
       Employee
          |
    +-----+-----+
    |     |     |
  Chef  Waiter3  Manager
```

**Relación "es-un":**
- Chef ES UN Employee
- Waiter3 ES UN Employee
- Manager ES UN Employee

---

## 🚀 Cómo Ejecutar
```bash
cd semana-04/src
javac *.java
java Main4
```

---

## 📊 Funcionalidades Demostradas

1. ✅ Herencia con `extends`
2. ✅ Constructores con `super()`
3. ✅ Sobrescritura con `@Override`
4. ✅ Atributos `protected`
5. ✅ Polimorfismo con arrays
6. ✅ Uso de `instanceof`
7. ✅ Métodos únicos por subclase
8. ✅ Cálculo polimórfico de nómina

---

## 📈 Resultados del Sistema

El programa demuestra:
- 9 empleados (3 chefs, 3 meseros, 3 gerentes)
- Cálculo polimórfico de salarios
- Nómina total del restaurante
- Estadísticas por tipo de empleado

---

## 📚 Documentación Adicional

Ver `JERARQUIA.md` para:
- Diagrama completo de jerarquía
- Justificación de diseño
- Atributos heredados
- Métodos sobrescritos
- Ventajas de la implementación

---

**Estudiante:** Brayan Alejandro Sanchez Pedroza  
**Ficha:** 3228973B

---

## ✅ **Estructura Final**
```
semana-04/
├── src/
│   ├── Employee.java      ✅ Clase padre
│   ├── Chef.java          ✅ Subclase 1
│   ├── Waiter3.java       ✅ Subclase 2
│   ├── Manager.java       ✅ Subclase 3
│   └── Main4.java         ✅ Demostración
├── JERARQUIA.md           ✅ Documentación de jerarquía
└── README.md              ✅ Guía de la semana