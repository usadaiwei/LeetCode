package Examples.Algorithms.Bloomberg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
主要考点OOP
A transaction is possibly invalid if:
the amount exceeds $1000, or;
if it occurs within (and including) 60 minutes of another transaction with the same name in a different city.

You are given an array of strings transaction where transactions[i] consists of comma-separated values representing the name, time (in minutes), amount, and city of the transaction.

Input: transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
Output: ["alice,20,800,mtv","alice,50,100,beijing"]
 */
public class InvalidTransactions {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> invalid = new ArrayList<>();
        Map<String, List<Trans>> map = new HashMap<>();
        for (String transaction : transactions){
            Trans t = new Trans(transaction);
            map.putIfAbsent(t.name, new ArrayList<>());
            map.get(t.name).add(t);
        }

        for (String transaction : transactions){
            Trans t = new Trans(transaction);
            if (!isValid(t, map.get(t.name)))
                invalid.add(transaction);
        }
        return invalid;
    }

    public boolean isValid(Trans t, List<Trans> list){
        if (t.amount > 1000)
            return false;
        for (Trans trans : list){
            if (Math.abs(t.time - trans.time) <= 60 && !t.city.equals(trans.city))
                return false;
        }
        return true;
    }
}

class Trans{
    public String name;
    public int time;
    public int amount;
    public String city;

    public Trans(){}

    public Trans(String transaction){
        String[] s = transaction.split(",");
        name = s[0];
        time = Integer.parseInt(s[1]);
        amount = Integer.parseInt(s[2]);
        city = s[3];
    }
}

