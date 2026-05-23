package payroll;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        PayrollDBService service =
                new PayrollDBService();

        // UPDATE SALARY
        service.updateSalary(
                "Bill",
                5000000.00
        );

        // READ DATA
        List<EmployeePayrollData> employees =
                service.readData();

        employees.forEach(System.out::println);
    }
}