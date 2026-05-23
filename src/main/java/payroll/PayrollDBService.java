package payroll;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PayrollDBService {

    private Connection getConnection()
            throws SQLException {

        String jdbcURL =
                "jdbc:mysql://localhost:3306/payroll_service";

        String userName = "root";

        String password = "Brandy05";

        return DriverManager.getConnection(
                jdbcURL,
                userName,
                password
        );
    }

    // UC1 CONNECTION
    public void connectToDatabase() {

        try {

            Connection connection =
                    getConnection();

            System.out.println(
                    "Connection Successful");

        } catch (SQLException e) {

            System.out.println(
                    e.getMessage());
        }
    }

    // UC2 READ DATA
    public List<EmployeePayrollData> readData() {

        List<EmployeePayrollData> employeeList =
                new ArrayList<>();

        String sql =
                "SELECT * FROM employee_payroll";

        try (
                Connection connection =
                        getConnection();

                Statement statement =
                        connection.createStatement();

                ResultSet resultSet =
                        statement.executeQuery(sql)
        ) {

            while (resultSet.next()) {

                int id =
                        resultSet.getInt("id");

                String name =
                        resultSet.getString("name");

                String gender =
                        resultSet.getString("gender");

                double salary =
                        resultSet.getDouble("salary");

                LocalDate startDate =
                        resultSet.getDate("start")
                                .toLocalDate();

                EmployeePayrollData employee =
                        new EmployeePayrollData(
                                id,
                                name,
                                gender,
                                salary,
                                startDate
                        );

                employeeList.add(employee);
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }

        return employeeList;
    }

    // UC3 UPDATE SALARY
    public void updateSalary(String name,
                             double salary) {

        String sql =
                "UPDATE employee_payroll " +
                        "SET salary = ? WHERE name = ?";

        try (
                Connection connection =
                        getConnection();

                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql)
        ) {

            preparedStatement.setDouble(1, salary);

            preparedStatement.setString(2, name);

            int rowsAffected =
                    preparedStatement.executeUpdate();

            System.out.println(
                    "Rows Updated : " + rowsAffected);

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
    }

    public EmployeePayrollData getEmployeeByName(
            String employeeName) {

        String sql =
                "SELECT * FROM employee_payroll " +
                        "WHERE name = ?";

        try (
                Connection connection =
                        getConnection();

                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql)
        ) {

            preparedStatement.setString(
                    1,
                    employeeName
            );

            ResultSet resultSet =
                    preparedStatement.executeQuery();

            if (resultSet.next()) {

                int id =
                        resultSet.getInt("id");

                String name =
                        resultSet.getString("name");

                String gender =
                        resultSet.getString("gender");

                double salary =
                        resultSet.getDouble("salary");

                java.time.LocalDate startDate =
                        resultSet.getDate("start")
                                .toLocalDate();

                return new EmployeePayrollData(
                        id,
                        name,
                        gender,
                        salary,
                        startDate
                );
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }

        return null;
    }

}