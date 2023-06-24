package org.example.service;

import org.example.constant.Constants;
import org.example.model.Expense;
import org.example.model.expenseImpl.Equal;
import org.example.model.expenseImpl.Exact;

public class ExpenseType {
    public Expense getExpense(String expenseType) {
        if (expenseType.equalsIgnoreCase(Constants.EQUAL)) {
            return new Equal();
        } else if (expenseType.equalsIgnoreCase(Constants.EXACT)) {
            return new Exact();
        }
        return null;
    }
}
