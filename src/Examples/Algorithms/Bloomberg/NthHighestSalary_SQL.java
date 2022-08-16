package Examples.Algorithms.Bloomberg;
/*
Table: Employee

+-------------+------+
| Column Name | Type |
+-------------+------+
| id          | int  |
| salary      | int  |
+-------------+------+
id is the primary key column for this table.
Each row of this table contains information about the salary of an employee.
Write an SQL query to report the nth highest salary from the Employee table. If there is no nth highest salary, the query should report null.
 */
public class NthHighestSalary_SQL {
    /*
    CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN

DECLARE M INT;
SET M = N - 1;

  RETURN (
      # Write your MySQL query statement below.
      SELECT DISTINCT salary FROM Employee
      ORDER BY salary DESC
      LIMIT M, 1
  );
END

*/
}
