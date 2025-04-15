
package com.budget.tracker;

import com.budget.tracker.model.*;
import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Transaction> transactions = new ArrayList<>();

    public static void main(String[] args) {
        int option;
        do {
            System.out.println("\n=== Gestor de Presupuesto Personal ===");
            System.out.println("1. Añadir nuevo gasto");
            System.out.println("2. Añadir nuevo ingreso");
            System.out.println("3. Ver todas las transacciones");
            System.out.println("4. Ver resumen de balance");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            while (!scanner.hasNextInt()) {
                System.out.print("Por favor, ingrese un número válido: ");
                scanner.next();
            }
            option = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (option) {
                case 1 -> addTransaction("Gasto");
                case 2 -> addTransaction("Ingreso");
                case 3 -> viewTransactions();
                case 4 -> viewBalanceSummary();
                case 5 -> System.out.println("¡Gracias por usar el gestor!");
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (option != 5);
    }

    private static void addTransaction(String type) {
        try {
            System.out.print("Monto: ");
            double amount = Double.parseDouble(scanner.nextLine());

            if (amount <= 0) throw new IllegalArgumentException("El monto debe ser mayor que cero.");

            System.out.print("Categoría: ");
            String category = scanner.nextLine();

            System.out.print("Descripción: ");
            String description = scanner.nextLine();

            Date date = new Date();

            Transaction transaction = type.equals("Gasto")
                ? new Expense(amount, category, date, description)
                : new Income(amount, category, date, description);

            transactions.add(transaction);
            System.out.println("Transacción registrada exitosamente.");
        } catch (NumberFormatException e) {
            System.out.println("Error: El monto debe ser un número válido.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No hay transacciones registradas.");
        } else {
            System.out.println("\n--- Lista de Transacciones ---");
            for (Transaction t : transactions) {
                System.out.println(t);
            }
        }
    }

    private static void viewBalanceSummary() {
        double ingresos = 0;
        double gastos = 0;

        for (Transaction t : transactions) {
            if (t instanceof Income) ingresos += t.getAmount();
            else if (t instanceof Expense) gastos += t.getAmount();
        }

        double balance = ingresos - gastos;

        System.out.printf("\nResumen de Balance:\nIngresos: $%.2f\nGastos: $%.2f\nBalance: $%.2f\n", ingresos, gastos, balance);
    }
}

