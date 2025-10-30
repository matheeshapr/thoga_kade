package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.dto.EmployeeDTO;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class EmployeePageController implements Initializable {

    ObservableList<EmployeeDTO> empDTOS = FXCollections.observableArrayList();


    @FXML
    private TableColumn<?, ?> empaddress;

    @FXML
    private TableColumn<?, ?> empconno;

    @FXML
    private TableColumn<?, ?> empdob;

    @FXML
    private TableColumn<?, ?> empid;

    @FXML
    private TableColumn<?, ?> empjoin;

    @FXML
    private TableColumn<?, ?> empname;

    @FXML
    private TableColumn<?, ?> empnic;

    @FXML
    private TableColumn<?, ?> empposi;

    @FXML
    private TableColumn<?, ?> empsal;

    @FXML
    private TableColumn<?, ?> empstatus;

    @FXML
    private TableView<EmployeeDTO> emptable;

    @FXML
    private TextField txtaddress;

    @FXML
    private TextField txtconno;

    @FXML
    private TextField txtdob;

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtjoind;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtnic;

    @FXML
    private TextField txtpostion;

    @FXML
    private TextField txtsalary;

    @FXML
    private TextField txtstatus;


    Stage stage = new Stage();

    @FXML
    void custaction(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/customer_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

    }

    Stage stage1 = new Stage();

    @FXML
    void dashaction(ActionEvent event) {
        try {
            stage1.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dashboard_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage1.show();

    }

    Stage stage2 = new Stage();

    @FXML
    void itemaction(ActionEvent event) {
        try {
            stage2.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/item_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage2.show();

    }

    Stage stage3 = new Stage();

    @FXML
    void logoutaction(ActionEvent event) {
        try {
            stage3.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/login_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage3.show();

    }

    Stage stage4 = new Stage();

    @FXML
    void supaction(ActionEvent event) {
        try {
            stage4.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/supplyier_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage4.show();

    }

    @FXML
    void addaction(ActionEvent event) {
        String id = txtid.getText();
        String name = txtname.getText();
        String nic = txtnic.getText();
        String dob = txtdob.getText();
        String position = txtpostion.getText();
        String salary = txtsalary.getText();
        String conno = txtconno.getText();
        String address = txtaddress.getText();
        String join = txtjoind.getText();
        String status = txtstatus.getText();

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
            loadEmployee();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    void deleteaction(ActionEvent event) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/togakademanagement", "root", "1234");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Customer WHERE CustomerID = ?");
            preparedStatement.setString(1, txtid.getText());
            preparedStatement.execute();
            loadEmployee();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void updateaction(ActionEvent event) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/togakademanagement", "root", "1234");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Customer SET Title = ?, Name = ?, DateOfBirth = ?, Salary = ?, Address = ?, City = ?, Province = ?, PostalCode = ? WHERE CustomerID = ?");
                    preparedStatement.setString(1,txtid.getText());
                    preparedStatement.setString(2,txtname.getText());
                    preparedStatement.setString(3,txtnic.getText());
                    preparedStatement.setString(4,txtdob.getText());
                    preparedStatement.setString(5,txtpostion.getText());
                    preparedStatement.setString(6,txtsalary.getText());
                    preparedStatement.setString(7,txtconno.getText());
                    preparedStatement.setString(8,txtjoind.getText());
                    preparedStatement.setString(9,txtstatus.getText());
                    preparedStatement.execute();
                    loadEmployee();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        empid.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("empid"));
        empname.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("empname"));
        empnic.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("empnic"));
        empdob.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("empdob"));
        empposi.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("empposi"));
        empsal.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("empsal"));
        empconno.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("empconno"));
        empaddress.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("empaddress"));
        empjoin.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("empjoin"));
        empstatus.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("empstatus"));
        emptable.setItems(empDTOS);
        loadEmployee();

        emptable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                txtid.setText(newValue.getId());
                txtname.setText(newValue.getName());
                txtnic.setText(newValue.getNic());
                txtdob.setText(newValue.getDob());
                txtpostion.setText(newValue.getPosition());
                txtsalary.setText(newValue.getSalary());
                txtconno.setText(newValue.getConno());
                txtaddress.setText(newValue.getAddress());
                txtjoind.setText(newValue.getJoin());
                txtstatus.setText(newValue.getStatus());
            }
        });
    }

    public void loadEmployee() {
        empDTOS.clear();

        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/togakademanagement", "root", "1234");
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Employee");
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                EmployeeDTO employee = new EmployeeDTO(
                        resultSet.getString("EmployeeID"),
                        resultSet.getString("Name"),
                        resultSet.getString("NIC"),
                        resultSet.getString("DateOfBirth"),
                        resultSet.getString("Position"),
                        resultSet.getString("Salary"),
                        resultSet.getString("ContactNumber"),
                        resultSet.getString("Address"),
                        resultSet.getString("JoinedDate"),
                        resultSet.getString("Status")
                );
                empDTOS.add(employee);
            }

        } catch (SQLException e) {
        }
    }
}
