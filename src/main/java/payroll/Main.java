package payroll;

public class Main {

    public static void main(String[] args) {

        PayrollDBService service =
                new PayrollDBService();

        EmployeePayrollData employee =
                service.getEmployeeByName(
                        "Bill"
                );

        System.out.println(employee);
    }
}