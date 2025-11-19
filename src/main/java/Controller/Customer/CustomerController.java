package Controller.Customer;

import javafx.collections.ObservableList;
import model.dto.CustomerDTO;

import java.sql.*;

public class CustomerController implements CustomerService{

    @Override
    public void addCustomerDetails(String id, String title, String name, String dob, double salary, String address, String city, String province, String postcode){
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

    @Override
    public void updateCustomerDetails(String id, String title, String name, String dob, double salary,String address, String city, String province, String postcode){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/togakademanagement", "root", "1234");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Customer SET Title = ?, Name = ?, DateOfBirth = ?, Salary = ?, Address = ?, City = ?, Province = ?, PostalCode = ? WHERE CustomerID = ?");

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

    @Override
    public void deleteCustomerDetails(String id){

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/togakademanagement", "root", "1234");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Customer WHERE CustomerID = ?");
            preparedStatement.setString(1, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<CustomerDTO> getAllCustomerDetails() {

        ObservableList<CustomerDTO> customerinfoDTOS = javafx.collections.FXCollections.observableArrayList();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Togakademanagement", "root", "1234");
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Customer");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                CustomerDTO customer = new CustomerDTO(
                        resultSet.getString("CustomerID"),
                        resultSet.getString("Title"),
                        resultSet.getString("Name"),
                        resultSet.getString("DateOfBirth"),
                        resultSet.getString("Salary"),
                        resultSet.getString("Address"),
                        resultSet.getString("City"),
                        resultSet.getString("Province"),
                        resultSet.getString("PostalCode")
                );
                customerinfoDTOS.add(customer);
            }

        } catch (SQLException e) {
        }
        return customerinfoDTOS;
    }


}
