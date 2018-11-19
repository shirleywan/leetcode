package database;

/**
 * 183. Customers Who Never Order
 * Suppose that a website contains two tables, the Customers table and the Orders table. Write a SQL query to find all customers who never order anything.
 *
 * Table: Customers.
 *
 * +----+-------+
 * | Id | Name  |
 * +----+-------+
 * | 1  | Joe   |
 * | 2  | Henry |
 * | 3  | Sam   |
 * | 4  | Max   |
 * +----+-------+
 * Table: Orders.
 *
 * +----+------------+
 * | Id | CustomerId |
 * +----+------------+
 * | 1  | 3          |
 * | 2  | 1          |
 * +----+------------+
 * Using the above tables as example, return the following:
 *
 * +-----------+
 * | Customers |
 * +-----------+
 * | Henry     |
 * | Max       |
 * +-----------+
 */
public class No183CustomersWhoNeverOrder {
    /**
     * select c.Name as Customers
     * from Customers c
     * left join Orders o
     * on c.Id = o.CustomerId
     * where CustomerId is null
     */
}
