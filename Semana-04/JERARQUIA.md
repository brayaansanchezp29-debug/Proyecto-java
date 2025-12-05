# 📊 Jerarquía de Clases - Semana 04

**Estudiante:** Brayan Alejandro Sanchez Pedroza  
**Ficha:** 3228973B  
**Dominio:** Restaurante Sabores del Valle

---

## 🌳 Diagrama de Jerarquía
```
                    Employee (Clase Padre)
                          |
              +-----------+-----------+
              |           |           |
            Chef      Waiter3      Manager
         (Cocinero)   (Mesero)    (Gerente)
```

---

## 💡 Justificación de la Jerarquía

### ¿Por qué esta jerarquía?

La jerarquía **Employee → Chef/Waiter3/Manager** fue elegida porque:

1. **Relación "es-un" clara:**
    - Un Chef **ES UN** Employee
    - Un Waiter3 **ES UN** Employee
    - Un Manager **ES UN** Employee

2. **Atributos comunes:**
    - Todos tienen: nombre, ID, salario base, años de servicio
    - Todos necesitan: calcular salario, mostrar información, gestionar vacaciones

3. **Comportamientos compartidos:**
    - Todos los empleados calculan salario (aunque de forma diferente)
    - Todos muestran información básica
    - Todos tienen días de vacaciones

4. **Especialización lógica:**
    - Cada subclase agrega atributos específicos de su rol
    - Cada subclase modifica el cálculo de salario según bonos específicos
    - Cada subclase tiene métodos únicos de su función

---

## 🔐 Atributos Heredados (Protected)

Todos estos atributos son accesibles desde las subclases:

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `name` | String | Nombre del empleado |
| `id` | String | Identificación única |
| `baseSalary` | double | Salario base mensual |
| `yearsOfService` | int | Años trabajando en el restaurante |
| `active` | boolean | Estado activo/inactivo |

**¿Por qué protected?**
- Permite que las subclases accedan directamente
- Mantiene encapsulación fuera de la jerarquía
- Facilita sobrescritura de métodos

---

## 🔄 Métodos Sobrescritos

### 1. `calculateSalary()`

**Clase Padre (Employee):**
```java
public double calculateSalary() {
    double seniorityBonus = baseSalary * 0.02 * yearsOfService;
    return baseSalary + seniorityBonus;
}
```

**Chef:**
```java
@Override
public double calculateSalary() {
    double baseSalary = super.calculateSalary(); // Hereda cálculo base
    double specialtyBonus = this.baseSalary * 0.15;
    double headChefBonus = headChef ? this.baseSalary * 0.25 : 0;
    double productivityBonus = (dishesCreated / 100) * 50000;
    return baseSalary + specialtyBonus + headChefBonus + productivityBonus;
}
```
**Diferencia:** Agrega bonos por especialidad, posición de chef principal y productividad.

**Waiter3:**
```java
@Override
public double calculateSalary() {
    double baseSalary = super.calculateSalary();
    double totalWithTips = baseSalary + averageTips;
    if (shift.equalsIgnoreCase("Noche")) {
        totalWithTips += this.baseSalary * 0.20;
    }
    if (tablesServed > 200) {
        totalWithTips += 100000;
    }
    return totalWithTips;
}
```
**Diferencia:** Agrega propinas, bono por turno nocturno y bono por productividad.

**Manager:**
```java
@Override
public double calculateSalary() {
    double baseSalary = super.calculateSalary();
    double leadershipBonus = this.baseSalary * 0.05 * teamSize;
    double seniorBonus = seniorManager ? this.baseSalary * 0.30 : 0;
    return baseSalary + leadershipBonus + seniorBonus + performanceBonus;
}
```
**Diferencia:** Agrega bonos por liderazgo, posición senior y desempeño.

---

### 2. `showInfo()`

**Clase Padre:** Muestra información básica (nombre, ID, salario)

**Subclases:** Cada una agrega información específica:
- **Chef:** Especialidad, posición, platos preparados
- **Waiter3:** Turno, mesas atendidas, propinas
- **Manager:** Departamento, tamaño de equipo, bonos

---

### 3. `getEmployeeType()`

**Clase Padre:** Retorna "Empleado General"

**Subclases:**
- **Chef:** "Chef Principal" o "Chef"
- **Waiter3:** "Mesero - Turno X"
- **Manager:** "Gerente Senior - Departamento" o "Gerente - Departamento"

---

### 4. `calculateVacationDays()` (solo Manager lo sobrescribe)

**Clase Padre:** 15 días base + 1 día cada 5 años

**Manager:**
```java
@Override
public int calculateVacationDays() {
    int baseDays = super.calculateVacationDays();
    int managerBonus = seniorManager ? 5 : 3;
    return baseDays + managerBonus;
}
```
**Diferencia:** Gerentes tienen 3-5 días adicionales.

---

## 🎯 Métodos Únicos por Subclase

### Chef
- `registerDishPrepared()` - Registra plato preparado
- `getExperienceLevel()` - Nivel de experiencia
- `calculateMonthlyBonus()` - Calcula bono mensual

### Waiter3
- `registerTableServed()` - Registra mesa atendida
- `updateTipsAverage()` - Actualiza promedio de propinas
- `getServiceLevel()` - Nivel de servicio
- `getTipsPercentage()` - % de propinas vs salario
- `isEligibleForProductivityBonus()` - Elegible para bono

### Manager
- `getLeadershipLevel()` - Nivel de liderazgo
- `calculateLeadershipBonus()` - Bono de liderazgo
- `addTeamMember()` - Agregar miembro al equipo
- `removeTeamMember()` - Remover miembro
- `assignPerformanceBonus()` - Asignar bono
- `calculateTotalBonuses()` - Total de bonos

---

## ✅ Ventajas de Esta Jerarquía

1. **Reutilización de código**
    - Atributos y métodos comunes definidos una sola vez
    - Cambios en Employee afectan a todas las subclases

2. **Mantenibilidad**
    - Lógica compartida en un solo lugar
    - Fácil agregar nuevos tipos de empleados

3. **Polimorfismo**
    - Array de Employee puede contener cualquier tipo
    - Mismo método, diferente comportamiento

4. **Extensibilidad**
    - Fácil agregar nuevas subclases (ej: Cajero, Bartender)
    - Cada subclase puede especializarse sin afectar otras

5. **Organización lógica**
    - Refleja la estructura real del restaurante
    - Código intuitivo y fácil de entender

---

## 📈 Posibles Extensiones Futuras
```
                    Employee
                        |
    +-------------------+-------------------+
    |           |           |           |           |
  Chef      Waiter3    Manager     Cashier     Bartender
                                  (Nuevo)      (Nuevo)
```

Nuevas subclases podrían ser:
- **Cashier** (Cajero)
- **Bartender** (Bartender)
- **Cleaner** (Personal de limpieza)
- **DeliveryPerson** (Repartidor)

---

## 🎓 Conceptos Aplicados

✅ **Herencia** - `extends Employee`  
✅ **super()** - Llamada a constructor padre  
✅ **@Override** - Sobrescritura de métodos  
✅ **protected** - Acceso a atributos heredados  
✅ **Polimorfismo** - Array de Employee con subclases  
✅ **instanceof** - Verificación de tipo en tiempo de ejecución

