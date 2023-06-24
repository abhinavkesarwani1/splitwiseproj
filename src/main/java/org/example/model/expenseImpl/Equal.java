package org.example.model.expenseImpl;

import org.example.model.Expense;
import org.example.model.User;

import java.util.List;
import java.util.Map;

public class Equal implements Expense {
    @Override
    public void recordTransaction(User payingUser, float amount, List<String> userList, List<Float> amounts,
                                  Map<String, User> userMap) {
        amount = amount/userList.size();
        for (String userId : userList) {
            payingUser.setOwingUserAmounts(userId, amount);
            User user = userMap.get(userId);
            user.setOwingUserAmounts(payingUser.getId(), amount * -1);
        }
    }
}
