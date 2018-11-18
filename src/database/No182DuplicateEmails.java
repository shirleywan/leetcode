package database;

/**
 * 182. Duplicate Emails
 * Write a SQL query to find all duplicate emails in a table named Person.
 *
 * +----+---------+
 * | Id | Email   |
 * +----+---------+
 * | 1  | a@b.com |
 * | 2  | c@d.com |
 * | 3  | a@b.com |
 * +----+---------+
 * For example, your query should return the following for the above table:
 *
 * +---------+
 * | Email   |
 * +---------+
 * | a@b.com |
 * +---------+
 * Note: All emails are in lowercase.
 */
public class No182DuplicateEmails {
    /**
     * select DISTINCT p.Email Email
     * from Person p , Person c
     * where p.Id <> c.Id and p.Email = c.Email
     */
}
