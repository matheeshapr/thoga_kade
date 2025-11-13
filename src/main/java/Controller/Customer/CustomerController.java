package Controller.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerController {

    public void addCustomerDetails(String id, String title, String name, String dob, double salary,String address, String city, String province, String postcode){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/togakademanagement", "root", "1234");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Customer VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, id);
            preparedStatement.setString(2, title);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, dob);
            preparedStatement.setDouble(5, salary);
            preparedStatement.setString(6, address);
            preparedStatement.setString(7, city);
            preparedStatement.setString(8, province);
            preparedStatement.setString(9, postcode);

            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
