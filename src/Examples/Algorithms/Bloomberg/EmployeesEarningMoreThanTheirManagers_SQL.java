package Examples.Algorithms.Bloomberg;

/*
Input:
Employee table:
+----+-------+--------+-----------+
| id | name  | salary | managerId |
+----+-------+--------+-----------+
| 1  | Joe   | 70000  | 3         |
| 2  | Henry | 80000  | 4         |
| 3  | Sam   | 60000  | Null      |
| 4  | Max   | 90000  | Null      |
+----+-------+--------+-----------+
Output:
+----------+
| Employee |
+----------+
| Joe      |
+----------+
 */
public class EmployeesEarningMoreThanTheirManagers_SQL {
    /*
SELECT a.name Employee FROM Employee a
LEFT JOIN Employee b
ON a.managerId = b.id
WHERE a.salary > b.salary;

     */
}
