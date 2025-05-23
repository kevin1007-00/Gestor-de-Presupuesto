
package com.budget.tracker.model;

import java.util.Date;

public class Expense extends Transaction {
    public Expense(double amount, String category, Date date, String description) {
        super(amount, category, date, description);
    }

    @Override
    public String getType() {
        return "Gasto";
    }
}

