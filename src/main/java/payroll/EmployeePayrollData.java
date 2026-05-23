package payroll;

import java.time.LocalDate;

public class EmployeePayrollData {

    private int id;
    private String name;
    private String gender;
    private double salary;
    private LocalDate startDate;

    public EmployeePayrollData(int id,
                               String name,
                               String gender,
                               double salary,
                               LocalDate startDate) {

        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.startDate = startDate;
    }

    @Override
    public String toString() {

        return "EmployeePayrollData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", startDate=" + startDate +
                '}';
    }
}