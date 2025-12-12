# 📊 Polimorfismo - Semana 05

**Estudiante:** Brayan Alejandro Sanchez Pedroza  
**Ficha:** 3228973B  
**Dominio:** Restaurante Sabores del Valle

---

## 🔄 1. Sobrecarga de Métodos (Overloading)

La sobrecarga permite tener múltiples métodos con el mismo nombre pero diferentes parámetros.

### Clase: Employee2

| Método | Parámetros | Descripción |
|--------|------------|-------------|
| `increaseSalary(double percentage)` | porcentaje | Aumenta por porcentaje |
| `increaseSalary(double fixedAmount, boolean isFixed)` | monto fijo | Aumenta monto específico |
| `increaseSalary(String evaluation)` | evaluación | Aumenta según evaluación |
| `calculateBonus()` | ninguno | Bono por defecto (10%) |
| `calculateBonus(double percentage)` | porcentaje | Bono con % específico |
| `calculateBonus(int fixedAmount)` | monto fijo | Bono fijo |

**Justificación:**  
Permite aumentar salarios de diferentes formas según el contexto: por evaluación de desempeño, por monto fijo negociado, o por porcentaje general.

---

### Clase: Chef2

| Método | Parámetros | Descripción |
|--------|------------|-------------|
| `registerDish()` | ninguno | Registra 1 plato |
| `registerDish(int quantity)` | cantidad | Registra múltiples platos |
| `registerDish(String dishName, int quantity)` | nombre y cantidad | Registra con detalles |

**Justificación:**  
Chefs preparan platos de diferentes formas: uno a la vez, en lote, o con registro detallado del nombre del plato.

---

### Clase: Waiter4

| Método | Parámetros | Descripción |
|--------|------------|-------------|
| `registerTable()` | ninguno | Registra 1 mesa |
| `registerTable(int quantity)` | cantidad | Registra múltiples mesas |
| `registerTable(double tips)` | propina | Registra mesa con propina |

**Justificación:**  
Meseros pueden registrar mesas simples, múltiples a la vez, o con información de propina incluida.

---

### Clase: Manager2

| Método | Parámetros | Descripción |
|--------|------------|-------------|
| `assignBonus(double amount)` | monto | Asigna bono fijo |
| `assignBonus(double percentage, boolean isPercentage)` | porcentaje | Asigna bono por % |
| `assignBonus(String evaluation)` | evaluación | Asigna según evaluación |

**Justificación:**  
Gerentes reciben bonos de diferentes maneras: monto fijo negociado, porcentaje del salario, o basado en evaluación de desempeño.

---

### Clase: RestaurantHR (Gestora)

| Método | Parámetros | Descripción |
|--------|------------|-------------|
| `findEmployee(String id)` | ID | Busca por identificación única |
| `findEmployee(String name, boolean byName)` | nombre | Busca por nombre (puede haber varios) |
| `findEmployee(Class<?> type)` | tipo de clase | Busca todos de un tipo (Chef2, Waiter4, etc.) |

**Justificación:**  
El sistema necesita buscar empleados de diferentes maneras según el caso de uso: búsqueda exacta por ID, búsqueda parcial por nombre, o filtrar por tipo de empleado.

---

## ✏️ 2. Sobrescritura de Métodos (Overriding)

Cada subclase modifica el comportamiento de los métodos heredados según su naturaleza.

### Tabla Comparativa de Métodos Sobrescritos

| Método | Employee2 (Padre) | Chef2 | Waiter4 | Manager2 |
|--------|-------------------|-------|---------|----------|
| **calculateSalary()** | Base + 2% antigüedad | Base + 15% especialidad + 25% chef principal + productividad | Base + propinas + 20% turno noche + bono | Base + 5% x persona equipo + 30% senior + desempeño |
| **showInfo()** | Info básica | +Especialidad +Platos +Nivel | +Turno +Mesas +Propinas +Nivel | +Departamento +Equipo +Bono +Liderazgo |
| **getDescription()** | "Empleado: nombre" | "Chef: nombre - Especialidad" | "Mesero: nombre - Turno" | "Gerente: nombre - Departamento" |
| **getEmployeeType()** | "Empleado General" | "Chef Principal" o "Chef" | "Mesero - Turno X" | "Gerente Senior" o "Gerente" |
| **calculateBonus()** | 10% | 20% (+ 10% si principal) | 10% propinas | 25% |
| **calculateVacationDays()** | 15 + 1 cada 5 años | Hereda padre | Hereda padre | Hereda + 3-5 días extra |

---

### Detalle de Sobrescritura: calculateSalary()

#### Employee2 (Clase Padre)
```java
public double calculateSalary() {
    double seniorityBonus = baseSalary * 0.02 * yearsOfService;
    return baseSalary + seniorityBonus;
}
```
**Lógica:** Salario base + 2% por cada año de servicio.

---

#### Chef2
```java
@Override
public double calculateSalary() {
    double baseSalary = super.calculateSalary();  // Llama al padre
    double specialtyBonus = this.baseSalary * 0.15;     // + 15% especialidad
    double headChefBonus = headChef ? this.baseSalary * 0.25 : 0;  // + 25% si principal
    double productivityBonus = (dishesCreated / 100) * 50000;  // + por platos
    return baseSalary + specialtyBonus + headChefBonus + productivityBonus;
}
```
**Diferencias:**
- ✅ Mantiene cálculo base (antigüedad)
- ➕ Agrega bono por especialidad (15%)
- ➕ Agrega bono de chef principal (25%)
- ➕ Agrega bono por productividad ($50k cada 100 platos)

---

#### Waiter4
```java
@Override
public double calculateSalary() {
    double baseSalary = super.calculateSalary();
    double totalWithTips = baseSalary + averageTips;    // + propinas
    if (shift.equalsIgnoreCase("Noche")) {              // + 20% turno noche
        totalWithTips += this.baseSalary * 0.20;
    }
    if (tablesServed > 200) {                            // + bono productividad
        totalWithTips += 100000;
    }
    return totalWithTips;
}
```
**Diferencias:**
- ✅ Mantiene cálculo base
- ➕ Agrega propinas mensuales
- ➕ Agrega 20% por turno nocturno
- ➕ Agrega $100k si atendió >200 mesas

---

#### Manager2
```java
@Override
public double calculateSalary() {
    double baseSalary = super.calculateSalary();
    double leadershipBonus = this.baseSalary * 0.05 * teamSize;  // + 5% x persona
    double seniorBonus = seniorManager ? this.baseSalary * 0.30 : 0;  // + 30% senior
    return baseSalary + leadershipBonus + seniorBonus + performanceBonus;
}
```
**Diferencias:**
- ✅ Mantiene cálculo base
- ➕ Agrega 5% por cada miembro del equipo
- ➕ Agrega 30% si es gerente senior
- ➕ Agrega bono de desempeño variable

---

## 🎭 3. Polimorfismo Dinámico (Dynamic Binding)

### Ejemplo de Código
```java
// ArrayList polimórfico
ArrayList<Employee2> employees = new ArrayList<>();
employees.add(new Chef2("Carlos", "CH001", 2500000, "Cocina"));
employees.add(new Waiter4("Laura", "W001", 1500000, "Mañana"));
employees.add(new Manager2("Roberto", "MG001", 4000000, "Operaciones", 15));

// Polimorfismo en acción
for (Employee2 emp : employees) {
    // DYNAMIC BINDING: el método correcto se llama en tiempo de ejecución
    emp.showInfo();              // Llama a Chef2.showInfo(), Waiter4.showInfo(), etc.
    double salary = emp.calculateSalary();  // Llama al método sobrescrito correcto
    System.out.println("Salario: $" + salary);
}
```

### Cómo Funciona

1. **En tiempo de compilación:**
    - Java solo sabe que `emp` es de tipo `Employee2`
    - Puede llamar cualquier método de `Employee2`

2. **En tiempo de ejecución:**
    - Java determina el tipo REAL del objeto (Chef2, Waiter4, Manager2)
    - Llama al método sobrescrito de la subclase correspondiente
    - Esto se llama "enlace dinámico" o "dynamic binding"

### Demostración en el Sistema
```java
// Método polimórfico en RestaurantHR
public void processPayroll(Employee2 employee) {
    System.out.println("Empleado: " + employee.getName());
    double salary = employee.calculateSalary();  // POLIMORFISMO
    System.out.println("Salario: $" + salary);
}

// Funciona con CUALQUIER subclase
hrSystem.processPayroll(chef1);     // Usa Chef2.calculateSalary()
hrSystem.processPayroll(waiter1);   // Usa Waiter4.calculateSalary()
hrSystem.processPayroll(manager1);  // Usa Manager2.calculateSalary()
```

---

## ✅ 4. Beneficios del Polimorfismo

### ¿Qué ventajas obtienes con polimorfismo?

1. **Código más flexible y extensible**
    - Puedo agregar nuevos tipos de empleados sin cambiar código existente
    - Ejemplo: Si agregamos `Bartender` o `Cashier`, todo sigue funcionando

2. **Código más mantenible**
    - Lógica de procesamiento de nómina en UN solo lugar
    - No necesito `if-else` para cada tipo de empleado

3. **Reutilización de código**
    - Métodos como `processPayroll()` funcionan con CUALQUIER empleado
    - No duplicamos código para cada tipo

4. **Interfaz uniforme**
    - Todos los empleados se tratan igual desde el punto de vista del sistema
    - Facilita operaciones masivas (aumentos, reportes, nómina)

5. **Facilita testing**
    - Puedo probar métodos polimórficos con diferentes tipos
    - Más fácil crear mocks y stubs

---

### ¿Qué sería difícil SIN polimorfismo?

#### Sin polimorfismo (código malo):
```java
public void processPayroll(Object employee) {
    if (employee instanceof Chef2) {
        Chef2 chef = (Chef2) employee;
        double salary = chef.getBaseSalary() + 
                       chef.getBaseSalary() * 0.15 + 
                       (chef.isHeadChef() ? chef.getBaseSalary() * 0.25 : 0);
        System.out.println("Salario Chef: $" + salary);
    } 
    else if (employee instanceof Waiter4) {
        Waiter4 waiter = (Waiter4) employee;
        double salary = waiter.getBaseSalary() + 
                       waiter.getAverageTips() + 
                       (waiter.getShift().equals("Noche") ? waiter.getBaseSalary() * 0.20 : 0);
        System.out.println("Salario Mesero: $" + salary);
    }
    // ... y así para cada tipo
}
```

**Problemas:**
- ❌ Código duplicado
- ❌ Difícil mantener (cambio en un tipo afecta este método)
- ❌ Difícil extender (agregar tipo = modificar TODO)
- ❌ Propenso a errores

#### Con polimorfismo (código bueno):
```java
public void processPayroll(Employee2 employee) {
    double salary = employee.calculateSalary();  // ¡Una línea!
    System.out.println("Salario: $" + salary);
}
```

**Ventajas:**
- ✅ Una sola línea
- ✅ Funciona con cualquier tipo actual y futuro
- ✅ Fácil mantener
- ✅ Sin duplicación

---

## 📊 Resumen de Implementación

| Concepto | Cantidad Implementada |
|----------|----------------------|
| **Métodos sobrecargados** | 18 métodos |
| **Métodos sobrescritos** | 18 sobrescrituras |
| **Clases polimórficas** | 4 (Employee2 + 3 subclases) |
| **Métodos polimórficos** | 10 métodos en RestaurantHR |
| **ArrayList polimórfico** | Sí, usado en toda la aplicación |

---

## 🎯 Conclusiones

El polimorfismo en este sistema permite:

1. **Tratar todos los empleados de forma uniforme** manteniendo sus diferencias
2. **Agregar nuevos tipos de empleados** sin romper código existente
3. **Simplificar operaciones masivas** como nómina y reportes
4. **Mejorar la mantenibilidad** centralizando la lógica
5. **Facilitar la extensión** del sistema a futuro

El sistema demuestra los **tres tipos de polimorfismo**:
- ✅ **Ad-hoc** (sobrecarga de métodos)
- ✅ **Paramétrico** (ArrayList<Employee2>)
- ✅ **Inclusión** (sobrescritura y dynamic binding)

