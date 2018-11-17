package database;

/**
 * 176. Second Highest Salary
 * Write a SQL query to get the second highest salary from the Employee table.
 *
 * +----+--------+
 * | Id | Salary |
 * +----+--------+
 * | 1  | 100    |
 * | 2  | 200    |
 * | 3  | 300    |
 * +----+--------+
 * For example, given the above Employee table, the query should return 200 as the second highest salary. If there is no second highest salary, then the query should return null.
 *
 * +---------------------+
 * | SecondHighestSalary |
 * +---------------------+
 * | 200                 |
 * +---------------------+
 */
public class No176SecondHighestSalary {
    /**
     *SELECT  MAX(Salary) SecondHighestSalary //注意这里，修改返回的列名为SecondHighestSalary；
     * FROM Employee
     * WHERE Salary NOT IN (
     *     SELECT MAX(Salary)
     *     FROM Employee)
     */
}
