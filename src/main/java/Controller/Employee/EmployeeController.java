package Controller.Employee;

import javafx.collections.ObservableList;
import model.dto.EmployeeDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeController {

    public void addEmployeeDetails(String id, String name, String nic, String dob, String position, String salary, String conno, String address, String join, String status){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/togakademanagement", "root", "1234");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Employee VALUES (?,?,?,?,?,?,?,?,?,?)");

            preparedStatement.setString(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, nic);
            preparedStatement.setString(4, dob);
            preparedStatement.setString(5, position);
            preparedStatement.setString(6, salary);
            preparedStatement.setString(7, conno);
            preparedStatement.setString(8, address);
            preparedStatement.setString(9, join);
            preparedStatement.setString(10, status);

            preparedStatement.execute();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateEmployeeDetails(String id, String name, String nic, String dob, String position, String salary, String conno, String address, String join, String status){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/togakademanagement", "root", "1234");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Employee SET id = ?, Name = ?, nic = ?, dob = ?, position = ?, salary = ?, conno = ?, join = ?, status = ? WHERE EmployeeID = ?");
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, nic);
            preparedStatement.setString(4, dob);
            preparedStatement.setString(5, position);
            preparedStatement.setString(6, salary);
            preparedStatement.setString(7, conno);
            preparedStatement.setString(8, address);
            preparedStatement.setString(9, join);
            preparedStatement.setString(10, status);
            preparedStatement.executeUpdate();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }

    public void deleteEmployeeDetails(){

    }

    public ObservableList<EmployeeDTO> getAllEmployeeDetails(){
        return null;
    }
}
