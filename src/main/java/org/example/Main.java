package org.example;

import org.example.constant.Constants;
import org.example.model.User;
import org.example.service.RecordExpense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Enter the number of Users ");
        int noOfUsers = Integer.parseInt(in.readLine());
        RecordExpense recordExpense = RecordExpense.getInstance();
        for (int i=1;i<=noOfUsers;i++) {
            User user = new User("u"+i, "user"+i);
            recordExpense.addUser(user);
        }

        while (true) {
            System.out.println("Input the expenses now");
            String input[] = in.readLine().split(" ");
            int inputIterator = 0;
            String type = input[inputIterator++];
            if (type.equalsIgnoreCase(Constants.SHOW)) {
                String userId = null;
                if (input.length >= 2) {
                    userId = input[1];
                }
                recordExpense.showBalance(userId);
            } else {
                String payingUser = input[inputIterator++];
                float amount = Float.parseFloat(input[inputIterator++]);
                int noOfUser = Integer.parseInt(input[inputIterator++]);
                List<String> userIds = new LinkedList<>();
                for (int i = 0; i < noOfUser; i++) {
                    String user = input[inputIterator++];
                    userIds.add(user);
                }
                String expenseType = input[inputIterator++];
                List<Float> amounts = null;
                while (inputIterator < input.length) {
                    if (amounts == null)
                        amounts = new LinkedList<>();
                    amounts.add(Float.parseFloat(input[inputIterator++]));
                }
                recordExpense.recordTransaction(expenseType, payingUser, amount, userIds, amounts);
            }
        }
    }
}