# Gestor-de-Presupuesto

## Descripción
Este programa permite a los usuarios gestionar sus ingresos y gastos desde la línea de comandos. Puedes añadir transacciones, visualizar todas las operaciones realizadas y ver un resumen financiero con balance actualizado.

## Cómo ejecutar
1. Compilar todos los archivos `.java` ubicados en la estructura `com/budget/tracker`.
2. Ejecutar el archivo `Main.java`.

```
javac com/budget/tracker/*.java com/budget/tracker/model/*.java
java com.budget.tracker.Main
```

## Funcionalidades
- Añadir nuevo gasto
- Añadir nuevo ingreso
- Ver todas las transacciones
- Ver resumen de balance (ingresos, gastos, balance neto)
- Salir del programa

## Estructura del Proyecto

```
com/budget/tracker/
├── Main.java
├── model/
│   ├── Transaction.java
│   ├── Expense.java
│   └── Income.java
```

## Requisitos Técnicos
- Validación de entradas para montos
- Uso de Scanner para entrada del usuario
- Formato monetario con dos decimales
- Manejo de errores básicos

## Capturas de Pantalla
![image alt](https://github.com/kevin1007-00/Gestor-de-Presupuesto/blob/main/Captura%20de%20pantalla%202025-04-15%20181158.png?raw=true)
