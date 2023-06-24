package org.example.model;

import java.util.List;
import java.util.Map;

public interface Expense {
    void recordTransaction(User payingUser, float amount, List<String> userList, List<Float> amounts, Map<String, User> userMap);
}
