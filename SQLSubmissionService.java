package com.student.submission;

import org.springframework.stereotype.Service;

@Service
public class SQLSubmissionService {

    public void displayQuery() {

        // Answer for Question 1
        String query1 = "SELECT " +
                "p.AMOUNT AS SALARY, " +
                "CONCAT(e.FIRST_NAME, ' ', e.LAST_NAME) AS NAME, " +
                "TIMESTAMPDIFF(YEAR, e.DOB, CURDATE()) AS AGE, " +
                "d.DEPARTMENT_NAME " +
                "FROM PAYMENTS p " +
                "JOIN EMPLOYEE e ON p.EMP_ID = e.EMP_ID " +
                "JOIN DEPARTMENT d ON e.DEPARTMENT = d.DEPARTMENT_ID " +
                "WHERE DAY(p.PAYMENT_TIME) != 1 " +
                "ORDER BY p.AMOUNT DESC " +
                "LIMIT 1;";

        // Answer for Question 2
        String query2 = "SELECT " +
                "e1.EMP_ID, e1.FIRST_NAME, e1.LAST_NAME, d.DEPARTMENT_NAME, " +
                "COUNT(e2.EMP_ID) AS YOUNGER_EMPLOYEES_COUNT " +
                "FROM EMPLOYEE e1 " +
                "JOIN DEPARTMENT d ON e1.DEPARTMENT = d.DEPARTMENT_ID " +
                "LEFT JOIN EMPLOYEE e2 ON e1.DEPARTMENT = e2.DEPARTMENT " +
                "AND e2.DOB > e1.DOB " +
                "GROUP BY e1.EMP_ID, e1.FIRST_NAME, e1.LAST_NAME, d.DEPARTMENT_NAME " +
                "ORDER BY e1.EMP_ID DESC;";

        System.out.println("----- QUESTION 1 SQL QUERY -----");
        System.out.println(query1);
        System.out.println();

        System.out.println("----- QUESTION 2 SQL QUERY -----");
        System.out.println(query2);
        System.out.println();
    }
}
