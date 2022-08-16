package Examples.Algorithms.Bloomberg;
/*
Example 1:

Input:
Customers table:
+----+-------+
| id | name  |
+----+-------+
| 1  | Joe   |
| 2  | Henry |
| 3  | Sam   |
| 4  | Max   |
+----+-------+
Orders table:
+----+------------+
| id | customerId |
+----+------------+
| 1  | 3          |
| 2  | 1          |
+----+------------+
Output:
+-----------+
| Customers |
+-----------+
| Henry     |
| Max       |
+-----------+
 */
public class CustomersWhoNeverOrder_SQL {
    /*
SELECT name Customers FROM Customers c LEFT JOIN Orders o
ON c.id = o.customerId
WHERE o.customerId IS NULL;

     */
}
