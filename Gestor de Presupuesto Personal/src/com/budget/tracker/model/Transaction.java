
package com.budget.tracker.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Transaction {
    protected double amount;
    protected String category;
    protected Date date;
    protected String description;

    public Transaction(double amount, String category, Date date, String description) {
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getFormattedDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }

    public abstract String getType();

    @Override
    public String toString() {
        return "[" + getType() + "] $" + String.format("%.2f", amount) + " - " + category + " - " + getFormattedDate() + " - " + description;
    }
}

