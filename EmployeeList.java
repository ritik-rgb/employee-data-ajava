import java.util.*;

class Employee {
    int emp_id;
    String emp_name, emp_gender, emp_email;
    float emp_sal;

    // Constructor with parameters
    Employee(int id, String name, String gender, String email, float salary) {
        emp_id = id;
        emp_name = name;
        emp_gender = gender;
        emp_email = email;
        emp_sal = salary;
    }

    // Default constructor
    public Employee() {
    }

    // Getter and Setter methods
    public void setId(int a) {
        emp_id = a;
    }

    public void setName(String b) {
        emp_name = b;
    }

    public void setGender(String c) {
        emp_gender = c;
    }

    public void setEmail(String d) {
        emp_email = d;
    }

    public void setSalary(float e) {
        emp_sal = e;
    }

    public int getId() {
        return emp_id;
    }

    public String getName() {
        return emp_name;
    }

    public String getGender() {
        return emp_gender;
    }

    public String getEmail() {
        return emp_email;
    }

    public float getSalary() {
        return emp_sal;
    }

    // Method to display employee details
    public void empDetails() {
        System.out.println("Employee id = " + emp_id);
        System.out.println("Employee name = " + emp_name);
        System.out.println("Employee gender = " + emp_gender);
        System.out.println("Employee email = " + emp_email);
        System.out.println("Employee salary = " + emp_sal);
    }
}

class EmployeeDB {
    ArrayList<Employee> al = new ArrayList<Employee>();

    // Add employee
    public boolean addEmp(Employee e) {
        return al.add(e);
    }

    // Remove employee
    public boolean removeEmp(int id) {
        boolean flag = false;
        Iterator<Employee> it = al.iterator();
        while (it.hasNext()) {
            Employee e = it.next();
            if (e.getId() == id) {
                flag = true;
                it.remove();
                break; // Exit loop after removing the employee
            }
        }
        return flag;
    }

    // Get payslip
    public String paySlip(int id) {
        String info = "Invalid Employee id";
        for (Employee e : al) {
            if (e.getId() == id) {
                info = "Pay slip is : " + e.getSalary();
                break; // Exit loop after finding the employee
            }
        }
        return info;
    }

    // List all employees
    public Employee[] listAllEmp() {
        Employee[] e = new Employee[al.size()];
        for (int i = 0; i < al.size(); i++) {
            e[i] = al.get(i);
        }
        return e;
    }

    // Method to display details of all employees
    public void empDetails() {
        for (Employee e : al) {
            e.empDetails();
            System.out.println();
        }
    }
}

public class EmployeeList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeDB ed = new EmployeeDB();

        // Creating employee objects
        Employee e1 = new Employee(100, "abc", "Male", "abc@gmail.com", 30000);
        Employee e2 = new Employee(101, "bcd", "Female", "bcd@gmail.com", 35000);

        // Adding employees to the database
        ed.addEmp(e1);
        ed.addEmp(e2);

        // Display employee details
        System.out.println("Employee details after adding:");
        ed.empDetails();

        // Display payslip for employee with id 101
        System.out.println("Payslip for employee id 101:");
        System.out.println(ed.paySlip(101));

        // Remove employee with id 100
        System.out.println("Removing employee with id 100:");
        System.out.println(ed.removeEmp(100));

        // Display employee details after removal
        System.out.println("Employee details after removal:");
        ed.empDetails();

        sc.close();
    }
}
