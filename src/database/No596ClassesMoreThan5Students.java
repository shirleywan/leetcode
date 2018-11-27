package database;

/**
 * 596. Classes More Than 5 Students
 * There is a table courses with columns: student and class
 * Please list out all classes which have more than or equal to 5 students.
 * For example, the table:
 *
 * +---------+------------+
 * | student | class      |
 * +---------+------------+
 * | A       | Math       |
 * | B       | English    |
 * | C       | Math       |
 * | D       | Biology    |
 * | E       | Math       |
 * | F       | Computer   |
 * | G       | Math       |
 * | H       | Math       |
 * | I       | Math       |
 * +---------+------------+
 * Should output:
 *
 * +---------+
 * | class   |
 * +---------+
 * | Math    |
 * +---------+
 * Note:
 * The students should not be counted duplicate in each course.
 */
public class No596ClassesMoreThan5Students {
    /**
     * method 1
     */
    /**
     * select class
     * from courses
     * group by class
     * having count(DISTINCT courses.student)>4
     */

    /**
     * SELECT class
     * FROM (SELECT COUNT(Distinct(student)) C, class
     *      FROM courses
     *      GROUP BY class) T
     * WHERE T.C >= 5
     */
}
