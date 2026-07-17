package dao;

import entities.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.database_controller;

public class EmployeeDAO {

    // ===================== INSERT =====================

    public boolean insertEmployee(Employee employee) {

        String sql = "INSERT INTO employees(name, role, city) VALUES (?, ?, ?)";

        try (
                Connection connection = database_controller.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setString(1, employee.getName());
            statement.setString(2, employee.getRole());
            statement.setString(3, employee.getCity());

            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }

    // ===================== READ ALL =====================

    public List<Employee> getAllEmployees() {

        List<Employee> employeeList = new ArrayList<>();

        String sql = "SELECT * FROM employees";

        try (
                Connection connection = database_controller.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()
        ) {

            while (resultSet.next()) {

                Employee employee = new Employee();

                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setRole(resultSet.getString("role"));
                employee.setCity(resultSet.getString("city"));

                employeeList.add(employee);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return employeeList;
    }

    // ===================== READ BY ID =====================

    public Employee getEmployeeById(int id) {

        String sql = "SELECT * FROM employees WHERE id = ?";

        try (
                Connection connection = database_controller.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                Employee employee = new Employee();

                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setRole(resultSet.getString("role"));
                employee.setCity(resultSet.getString("city"));

                return employee;
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }

    // ===================== UPDATE =====================

    public boolean updateEmployee(Employee employee) {

        String sql = "UPDATE employees SET name = ?, role = ?, city = ? WHERE id = ?";

        try (
                Connection connection = database_controller.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setString(1, employee.getName());
            statement.setString(2, employee.getRole());
            statement.setString(3, employee.getCity());
            statement.setInt(4, employee.getId());

            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }

    // ===================== DELETE =====================

    public boolean deleteEmployee(int id) {

        String sql = "DELETE FROM employees WHERE id = ?";

        try (
                Connection connection = database_controller.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setInt(1, id);

            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }

}