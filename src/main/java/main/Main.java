package main;

import dao.EmployeeDAO;
import entities.Employee;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        while (true) {

            System.out.println("\n=================================");
            System.out.println("    EMPLOYEE MANAGEMENT SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.println("=================================");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    Employee employee = new Employee();

                    System.out.print("Enter Name : ");
                    employee.setName(scanner.nextLine());

                    System.out.print("Enter Role : ");
                    employee.setRole(scanner.nextLine());

                    System.out.print("Enter City : ");
                    employee.setCity(scanner.nextLine());

                    if (dao.insertEmployee(employee)) {
                        System.out.println("Employee Added Successfully.");
                    } else {
                        System.out.println("Failed to Add Employee.");
                    }

                    break;

                case 2:

                    List<Employee> employees = dao.getAllEmployees();

                    if (employees.isEmpty()) {

                        System.out.println("No Employee Found.");

                    } else {

                        System.out.println("\n------ Employee List ------");

                        for (Employee emp : employees) {
                            System.out.println(emp);
                        }
                    }

                    break;

                case 3:

                    System.out.print("Enter Employee ID : ");
                    int id = scanner.nextInt();

                    Employee emp = dao.getEmployeeById(id);

                    if (emp != null) {

                        System.out.println(emp);

                    } else {

                        System.out.println("Employee Not Found.");
                    }

                    break;

                case 4:

                    Employee updateEmployee = new Employee();

                    System.out.print("Enter Employee ID : ");
                    updateEmployee.setId(scanner.nextInt());
                    scanner.nextLine();

                    System.out.print("Enter New Name : ");
                    updateEmployee.setName(scanner.nextLine());

                    System.out.print("Enter New Role : ");
                    updateEmployee.setRole(scanner.nextLine());

                    System.out.print("Enter New City : ");
                    updateEmployee.setCity(scanner.nextLine());

                    if (dao.updateEmployee(updateEmployee)) {

                        System.out.println("Employee Updated Successfully.");

                    } else {

                        System.out.println("Update Failed.");
                    }

                    break;

                case 5:

                    System.out.print("Enter Employee ID : ");

                    int deleteId = scanner.nextInt();

                    if (dao.deleteEmployee(deleteId)) {

                        System.out.println("Employee Deleted Successfully.");

                    } else {

                        System.out.println("Employee Not Found.");
                    }

                    break;

                case 6:

                    System.out.println("Thank You.");
                    scanner.close();
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice.");
            }
        }
    }
}