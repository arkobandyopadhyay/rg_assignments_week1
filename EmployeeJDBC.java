package com.example;

import java.sql.*;
import java.util.*;
class Employee1 {
    private int id;
    private String name;
    private String department;

    public Employee1(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }

    @Override
    public String toString() {
        return "Employee [ID=" + id + ", Name=" + name + ", Department=" + department + "]";
    }
}

public class EmployeeJDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbcdb"; // replace with your DB name
    private static final String USER = "root"; // your DB username
    private static final String PASSWORD = "Give your own password"; // your DB password

    Connection conn;

    public EmployeeJDBC() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Create
    public void addEmployee(Employee1 e) throws SQLException {
        String sql = "INSERT INTO employees (id, name, department) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, e.getId());
        ps.setString(2, e.getName());
        ps.setString(3, e.getDepartment());
        ps.executeUpdate();
        System.out.println("Employee added.");
    }

    // Read
    public void listEmployees() throws SQLException {
        String sql = "SELECT * FROM employees";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("\nEmployee List:");
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String dept = rs.getString("department");
            System.out.println(new Employee1(id, name, dept));
        }
    }

    // Update
    public void updateEmployee(int id, String newName, String newDept) throws SQLException {
        String sql = "UPDATE employees SET name = ?, department = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, newName);
        ps.setString(2, newDept);
        ps.setInt(3, id);

        int rows = ps.executeUpdate();
        if (rows > 0) {
            System.out.println("Employee updated.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    // Delete
    public void deleteEmployee(int id) throws SQLException {
        String sql = "DELETE FROM employees WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        int rows = ps.executeUpdate();
        if (rows > 0) {
            System.out.println("Employee deleted.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    // Close connection
    public void close() throws SQLException {
        if (conn != null) conn.close();
    }

    // Main method to test CRUD
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            EmployeeJDBC db = new EmployeeJDBC();

            // Add
            db.addEmployee(new Employee1(1, "Arko", "IT"));
            db.addEmployee(new Employee1(2, "Arghya", "HR"));

            // List
            db.listEmployees();

            // Update
            db.updateEmployee(1, "Arko Bandyopadhyay", "Engineering");

            // Delete
            db.deleteEmployee(2);

            // List again
            db.listEmployees();

            db.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


