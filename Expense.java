package com.expensetracker;
import java.io.Serializable;
import java.time.LocalDate;

public class Expense implements Serializable {
    private final double amount;
    private final String category;
    private final LocalDate date;
    private final String notes;

    public Expense(double amount, String category, LocalDate date, String notes) {
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.notes = notes;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getNotes() {
        return notes;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "amount=" + amount +
                ", category='" + category + '\'' +
                ", date=" + date +
                ", notes='" + notes + '\'' +
                '}';
    }
}
