package org.example.model;

import java.util.HashMap;
import java.util.Map;

public class User {
    String id;
    String name;
    Map<String, Float> owingUserAmounts;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.owingUserAmounts = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Float> getOwingUserAmounts() {
        return owingUserAmounts;
    }

    public void setOwingUserAmounts(Map<String, Float> owingUserAmounts) {
        this.owingUserAmounts = owingUserAmounts;
    }

    public void setOwingUserAmounts(String userId, Float amount) {
        if (owingUserAmounts.containsKey(userId)) {
            float a = owingUserAmounts.get(userId);
            a += amount;
            owingUserAmounts.put(userId, a);
        } else {
            owingUserAmounts.put(userId, amount);
        }
    }

}
