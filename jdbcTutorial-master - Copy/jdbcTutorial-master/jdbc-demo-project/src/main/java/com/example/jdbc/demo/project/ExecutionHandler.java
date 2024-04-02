//package com.example.jdbc.demo.project;
//
//import com.example.jdbc.demo.project.databaseImpl.EmployeeDao;
//import com.example.jdbc.demo.project.model.Employee;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.IOException;
//import java.sql.*;
//import java.util.HashMap;
//import java.util.Map;
//
//public class ExecutionHandler {
//    public static final Logger LOGGER = LoggerFactory.getLogger(ExecutionHandler.class);
//    Map<String, Employee> employeeMap = new HashMap<>();
//
//    public static void executeInsertion() {
//
//        Map<String, Employee> employeeMap = createEmployeeMap();
//
//        for (Map.Entry<String, Employee> entry : employeeMap.entrySet()) {
//            boolean inserted = insertEmployee(entry.getKey(), entry.getValue());
//            if (inserted) {
//                LOGGER.info("Employee '{}' inserted successfully.", entry.getKey());
//            } else {
//                LOGGER.error("Failed to insert employee '{}'", entry.getKey());
//            }
//        }
//    }
//
//    public static void retrieveAllEmployeeDetails() {
//        var map = EmployeeDao.retrieveAllEmployee();
//
//        LOGGER.info("Employee Details:");
//        for (Map.Entry<Integer, Employee> entry : map.entrySet()) {
//            LOGGER.info("Key: {}, Value: {}", entry.getKey(), entry.getValue().toString());
//        }
//    }
//
//    private static Map<String, Employee> createEmployeeMap() {
//        Map<String, Employee> employeeMap = new HashMap<>();
//
//        employeeMap.put("Dilip", new Employee("Dilip", "Bhadiyasar", "dilip.bhadiyasar@sarvika.com",
//                "9876543210", Date.valueOf("2000-06-25"), 100000.00, "Software Engineer"));
//
//        employeeMap.put("Darshika", new Employee("Darshika", "Maheshwari",
//                "darshika.Maheshwari@sarvika.com", "0123456789", Date.valueOf("2024-03-04"),
//                50000.00, "Software Engineer"));
//
////        employeeMap.put("Gunjan", new Employee("Gunjan", "Kanwar", "gunjan.kanwar@sarvika.com",
////                "0123456789", Date.valueOf("2024-03-11"), 50000.00, "Software Engineer"));
//
//        return employeeMap;
//    }
//
//    private static boolean insertEmployee(String employeeName, Employee employee) {
//        return EmployeeDao.insertEmployee(employee);
//    }
//
//}
package com.example.jdbc.demo.project;

import com.example.jdbc.demo.project.databaseImpl.EmployeeDao;
import com.example.jdbc.demo.project.model.Employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

public class ExecutionHandler {
    public static final Logger LOGGER = LoggerFactory.getLogger(ExecutionHandler.class);

    public static void main(String[] args) {
        executeInsertion();
        retrieveAllEmployeeDetails();
    }

    public static void executeInsertion() {
        Map<String, Employee> employeeMap = createEmployeeMap();

        for (Map.Entry<String, Employee> entry : employeeMap.entrySet()) {
            boolean inserted = insertEmployee(entry.getKey(), entry.getValue());
            if (inserted) {
                LOGGER.info("Employee '{}' inserted successfully.", entry.getKey());
            } else {
                LOGGER.error("Failed to insert employee '{}'", entry.getKey());
            }
        }
    }

    public static void retrieveAllEmployeeDetails() {
        Map<Integer, Employee> map = EmployeeDao.retrieveAllEmployee();

        LOGGER.info("Employee Details:");
        for (Map.Entry<Integer, Employee> entry : map.entrySet()) {
            LOGGER.info("Key: {}, Value: {}", entry.getKey(), entry.getValue().toString());
        }
    }

    private static Map<String, Employee> createEmployeeMap() {
        Map<String, Employee> employeeMap = new HashMap<>();

        employeeMap.put("Dilip", new Employee("Dilip", "Bhadiyasar", "dilip.bhadiyasar@sarvika.com",
                "9876543210", Date.valueOf("2000-06-25"), 100000.00, "Software Engineer"));

        employeeMap.put("Darshika", new Employee("Darshika", "Maheshwari",
                "darshika.Maheshwari@sarvika.com", "0123456789", Date.valueOf("2024-03-04"),
                50000.00, "Software Engineer"));

        return employeeMap;
    }

    private static boolean insertEmployee(String employeeName, Employee employee) {
        return EmployeeDao.insertEmployee(employee);
    }

}
