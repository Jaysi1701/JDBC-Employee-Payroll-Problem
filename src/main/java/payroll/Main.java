package payroll;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        PayrollDBService service =
                new PayrollDBService();

        List<EmployeePayrollData> employees =
                service.getEmployeesByDateRange(
                        "2018-01-01",
                        "2025-12-31"
                );

        employees.forEach(System.out::println);
    }
}