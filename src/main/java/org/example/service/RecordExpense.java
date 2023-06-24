package org.example.service;

import org.example.model.Expense;
import org.example.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecordExpense {
    private static Map<String, User> userMap;
    private static RecordExpense recordExpense;

    private RecordExpense() { }

    public static synchronized RecordExpense getInstance() {
        if (recordExpense == null) {
            synchronized (RecordExpense.class) {
                if (recordExpense == null) {
                    userMap = new HashMap<>();
                    return new RecordExpense();
                }
            }
        }
        return recordExpense;
    }

    public void recordTransaction(String expenseType, String userId, float amount,
                                  List<String> userIds, List<Float> amounts) {
        ExpenseType expenseType1 = new ExpenseType();
        Expense expense = expenseType1.getExpense(expenseType);
        expense.recordTransaction(userMap.get(userId), amount, userIds, amounts, userMap);
    }

    public void showBalance() {
        showBalance(null);
    }

    public void showBalance(String userId) {
        if (userId == null) {
            for (User user : userMap.values()) {
                printOwingMoney(user);
            }
        } else {
            printOwingMoney(userMap.get(userId));
        }
    }

    private static void printOwingMoney(User user) {
        Map<String, Float> getOwingAmounts = user.getOwingUserAmounts();
        System.out.println("User " + user.getName() + " owes following amounts : ");
        for (Map.Entry<String, Float> entry : getOwingAmounts.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    public void addUser(User user) {
        userMap.put(user.getId(), user);
    }
}
