package org.example.model.expenseImpl;

import org.example.model.Expense;
import org.example.model.User;

import java.util.List;
import java.util.Map;

public class Exact implements Expense {
    @Override
    public void recordTransaction(User payingUser, float amount, List<String> userList, List<Float> amounts,
                                  Map<String, User> userMap) {
        for (int i = 0; i < userList.size(); i++) {
            User user = userMap.get(userList.get(i));
            payingUser.setOwingUserAmounts(user.getId(), amounts.get(i));
            user.setOwingUserAmounts(payingUser.getId(), amounts.get(i) * -1);
        }
    }
}
