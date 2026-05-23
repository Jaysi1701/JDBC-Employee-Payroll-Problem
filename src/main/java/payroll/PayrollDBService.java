package payroll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
}