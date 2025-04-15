package ex4;


class EmployeeProcessor {
    public double calculateBonus(Employee employee) {

        switch(employee.getType()) {
            case "REGULAR":
                return employee.getSalary() * 0.1;
            case "MANAGER":
                return employee.getSalary() * 0.2;
            case "DIRECTOR":
                return employee.getSalary() * 0.3;
            default:
                throw new IllegalArgumentException("Unknown employee type");
        }
    }

    public void saveToDatabase(Employee employee) {
        // Логика сохранения в БД
        System.out.println("Сохранено в БД: " + employee.getName());
    }
}

// Класс Employee (анемичная модель)
class Employee {
    private String type;
    private double salary;
    private String name;

    public Employee(String type, double salary, String name) {
        this.type = type;
        this.salary = salary;
        this.name = name;
    }

    // Геттеры
    public String getType() { return type; }
    public double getSalary() { return salary; }
    public String getName() { return name; }
}

// Использование
public class Main {
    public static void main(String[] args) {
        EmployeeProcessor processor = new EmployeeProcessor();

        Employee regular = new Employee("REGULAR", 1000, "Иван");
        Employee manager = new Employee("MANAGER", 2000, "Ольга");

        System.out.println("Бонус регулярного: " + processor.calculateBonus(regular));
        System.out.println("Бонус менеджера: " + processor.calculateBonus(manager));

        processor.saveToDatabase(regular);
    }
}
