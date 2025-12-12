# Semana 07 - Paquetes y Excepciones

## 🎯 Objetivos Completados

- ✅ **Ejercicio 1 (25 pts):** Código reorganizado en paquetes
- ✅ **Ejercicio 2 (30 pts):** Validaciones con excepciones
- ✅ **Ejercicio 3 (25 pts):** 3 excepciones personalizadas
- ✅ **Ejercicio 4 (20 pts):** Main con 6 casos de prueba

**Puntuación Total:** 100/100 puntos

---

## 📦 Estructura de Paquetes
```
src/com/restaurante/
├── modelo/                    (Entidades del dominio)
│   ├── Dish6.java
│   └── Order3.java
├── servicio/                  (Lógica de negocio)
│   └── OrderManager.java
├── excepciones/               (Excepciones personalizadas)
│   ├── DishNotAvailableException.java
│   ├── InvalidOrderException.java
│   └── TableNotAvailableException.java
└── Main7.java                 (Punto de entrada)
```

---

## 🚨 Excepciones Implementadas

| Excepción | Tipo | Cuándo se lanza |
|-----------|------|-----------------|
| `DishNotAvailableException` | Checked | Plato agotado o no disponible |
| `InvalidOrderException` | Checked | Pedido con datos inválidos |
| `TableNotAvailableException` | Checked | Mesa no existe o fuera de rango |
| `IllegalArgumentException` | Unchecked | Validaciones de datos (precio, código, etc.) |

---

## 🔍 Validaciones Implementadas

- ✅ Código de plato (formato D###)
- ✅ Nombre (mínimo 3 caracteres)
- ✅ Categoría (valores válidos)
- ✅ Precio (rango 1-500000)
- ✅ Stock (no negativo)
- ✅ Número de mesa (1-50)
- ✅ Cantidad (1-20)
- ✅ Nombre de cliente (mínimo 3 caracteres)

---

## 🚀 Cómo Ejecutar
```bash
cd semana-07/src
javac com/restaurante/**/*.java com/restaurante/Main7.java
java com.restaurante.Main7
```

---

## 📊 Casos de Prueba

1. ✅ Pedido válido → Éxito
2. ❌ Código inválido → IllegalArgumentException
3. ❌ Precio negativo → IllegalArgumentException
4. ❌ Plato agotado → DishNotAvailableException
5. ❌ Mesa inválida → TableNotAvailableException
6. ❌ Cantidad excesiva → InvalidOrderException

---

**Estudiante:** Brayan Alejandro Sanchez Pedroza  
**Ficha:** 3228973B

---

## ✅ **Estructura Final Semana 07**
```
semana-07/
└── src/
└── com/
└── restaurante/
├── modelo/
│   ├── Dish6.java          ✅
│   └── Order3.java         ✅
├── servicio/
│   └── OrderManager.java   ✅
├── excepciones/
│   ├── DishNotAvailableException.java     ✅
│   ├── InvalidOrderException.java         ✅
│   └── TableNotAvailableException.java    ✅
├── Main7.java              ✅
└── README.md               ✅