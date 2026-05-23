package payroll;

public class Main {

    public static void main(String[] args) {

        PayrollDBService service =
                new PayrollDBService();

        service.connectToDatabase();
    }
}