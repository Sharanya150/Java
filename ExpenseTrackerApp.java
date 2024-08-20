package com.expensetracker;

import java.time.LocalDate;
import java.util.List;

public class ExpenseTrackerApp {
    public static void main(String[] args) {
        ExpenseManager manager = new ExpenseManager();
        ExpenseDataStore dataStore = new ExpenseDataStore();

        // Load expenses from file
        List<Expense> expenses = dataStore.loadExpenses();
        if (expenses != null) {
            expenses.forEach(manager::addExpense);
        }

        // Add some expenses for demonstration
        manager.addExpense(new Expense(50, "Food", LocalDate.now(), "Lunch"));
        manager.addExpense(new Expense(100, "Transport", LocalDate.now(), "Bus Fare"));

        // Display all expenses
        System.out.println("All Expenses:");
        manager.getExpenses().forEach(System.out::println);

        // Save expenses to file
        dataStore.saveExpenses(manager.getExpenses());

        // Display total expenses
        System.out.println("\nTotal Expenses: " + manager.getTotalExpenses());

        // Display expenses by category
        System.out.println("\nExpenses in category 'Food':");
        manager.getExpensesByCategory("Food").forEach(System.out::println);

        // Display expenses by date range
        System.out.println("\nExpenses between " + LocalDate.now().minusDays(1) + " and " + LocalDate.now() + ":");
        manager.getExpensesByDateRange(LocalDate.now().minusDays(1), LocalDate.now()).forEach(System.out::println);
    }
}
