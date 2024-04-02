package com.example.jdbc.demo.project.databaseImpl;

import com.example.jdbc.demo.project.connectivity.JdbcConnectivity;
import com.example.jdbc.demo.project.model.Employee;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class EmployeeDao {

    private static final String INSERT_QUERY = "INSERT INTO employee_details (FirstName, LastName, Email, PhoneNumber, HireDate, Salary, Department) VALUES (?, ?, ?, ?, ?, ?, ?)";

    private static final String GET_ALL_EMPLOYEE_DETAILS = "SELECT * FROM employee_details";

    public static boolean insertEmployee(Employee employee) {
        try (
                Connection connection = JdbcConnectivity.getConnection();

                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
        ) {
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getPhoneNumber());
            preparedStatement.setDate(5, employee.getHireDate());
            preparedStatement.setDouble(6, employee.getSalary());
            preparedStatement.setString(7, employee.getDepartment());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Map<Integer, Employee> retrieveAllEmployee() {

        Map<Integer, Employee> employeeMap = new HashMap<>();

        try (
                Connection connection = JdbcConnectivity.getConnection();

                PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_EMPLOYEE_DETAILS);
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                // Retrieve employee details from ResultSet
                int id = resultSet.getInt("EmployeeID");
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String email = resultSet.getString("Email");
                String phoneNumber = resultSet.getString("PhoneNumber");
                Date hireDate = resultSet.getDate("HireDate");
                double salary = resultSet.getDouble("Salary");
                String department = resultSet.getString("Department");

                Employee employee = new Employee(firstName, lastName, email, phoneNumber, hireDate, salary, department);

                employeeMap.put(id, employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeMap;
    }
}
