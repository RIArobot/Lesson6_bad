package ex8;

import java.util.List;
import java.util.ArrayList;


class EmployeeManager {
    private List<Employee> employees = new ArrayList<>();


    private DatabaseConnection dbConnection = new MySQLConnection();


    public void processEmployeeData(Employee emp) {
        if (emp != null && emp.getName() != null && !emp.getName().isEmpty()) {
            if (emp.getAge() > 18 && emp.getAge() < 65) {
                if (emp.getSalary() > 0) {

                    for (Employee e : employees) {
                        if (e.getId() == emp.getId()) {
                            System.out.println("Employee exists");
                            return;
                        }
                    }


                    if (dbConnection.isConnected()) {
                        dbConnection.save(emp);
                        employees.add(emp);
                        sendNotification(emp);
                        logAction("Added: " + emp.getName());
                    } else {
                        logAction("DB not connected");
                    }
                } else {
                    logAction("Invalid salary");
                }
            } else {
                logAction("Invalid age");
            }
        } else {
            logAction("Invalid name");
        }
    }


    public void generateReport(String type) {
        if (type.equals("PDF")) {

        } else if (type.equals("Excel")) {

        }
    }

    private void sendNotification(Employee emp) {

        if (emp != null && emp.getEmail() != null && !emp.getEmail().isEmpty()) {
            System.out.println("Sending email to " + emp.getEmail());
        }
    }

    private void logAction(String message) {
        System.out.println("[LOG] " + message);
    }
}


class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;
    private String email;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

class Manager extends Employee {

    @Override
    public void setSalary(double salary) {
        if (salary < 5000) {
            throw new IllegalArgumentException("Manager salary too low");
        }
        super.setSalary(salary);
    }
}


class DatabaseConnection {
    boolean isConnected() { return true; }
    void save(Employee emp) {}
}

class MySQLConnection extends DatabaseConnection {
    // реализация
}
