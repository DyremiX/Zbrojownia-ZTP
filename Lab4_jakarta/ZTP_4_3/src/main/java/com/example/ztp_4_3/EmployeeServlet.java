package com.example.ztp_4_3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static Map<Integer, Employee> employeeDatabase = new HashMap<>();
    private static int nextId = 1;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam != null) {
            int id = Integer.parseInt(idParam);
            Employee employee = employeeDatabase.get(id);
            if (employee != null) {
                response.getWriter().println(employee.toString());
            } else {
                response.getWriter().println("Employee not found");
            }
        } else {
            List<Employee> employees = new ArrayList<>(employeeDatabase.values());
            response.getWriter().println(employees.toString());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("action").equals("add")) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String position = request.getParameter("position");

            Employee employee = new Employee(nextId, firstName, lastName, position);
            employeeDatabase.put(nextId, employee);
            nextId++;

            response.getWriter().println("Employee added successfully");
        }
        else{
            String idParam = request.getParameter("id");
            if (idParam != null) {
                int id = Integer.parseInt(idParam);
                Employee employee = employeeDatabase.get(id);
                if (employee != null) {
                    String firstName = request.getParameter("firstName");
                    String lastName = request.getParameter("lastName");
                    String position = request.getParameter("position");

                    employee.setFirstName(firstName);
                    employee.setLastName(lastName);
                    employee.setPosition(position);

                    response.getWriter().println("Employee modified successfully");
                } else {
                    response.getWriter().println("Employee not found");
                }
            } else {
                response.getWriter().println("Invalid request");
            }
        }
    }
}

class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String position;

    public Employee(int id, String firstName, String lastName, String position) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", position=" + position + "]";
    }
}
