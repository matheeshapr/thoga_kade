package Controller.Customer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.dto.CustomerDTO;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class CustomerPageController implements Initializable {

    CustomerController customercontroller = new CustomerController();

    ObservableList<CustomerDTO> customerinfoDTOS = FXCollections.observableArrayList();

    @FXML
    private TableColumn<?, ?> custaddress;

    @FXML
    private TableColumn<?, ?> custcity;

    @FXML
    private TableColumn<?, ?> custdob;

    @FXML
    private TableColumn<?, ?> custid;

    @FXML
    private TableColumn<?, ?> custname;

    @FXML
    private TableColumn<?, ?> custpostcode;

    @FXML
    private TableColumn<?, ?> custprovince;

    @FXML
    private TableColumn<?, ?> custsalary;

    @FXML
    private TableView<CustomerDTO> custtable;

    @FXML
    private TableColumn<?, ?> custtitle;

    @FXML
    private TextField txtaddress;

    @FXML
    private TextField txtcity;

    @FXML
    private DatePicker txtdate;

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtpost;

    @FXML
    private TextField txtprovince;

    @FXML
    private TextField txtsalary;

    @FXML
    private TextField txttitle;


    Stage stage = new Stage();

    public void dashaction(ActionEvent actionEvent) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dashboard_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }

    Stage stage1 = new Stage();

    public void itemaction(ActionEvent actionEvent) {
        try {
            stage1.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/item_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage1.show();
    }

    Stage stage2 = new Stage();

    public void suppaction(ActionEvent actionEvent) {
        try {
            stage2.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/supplyier_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage2.show();
    }

    Stage stage3 = new Stage();

    public void empaction(ActionEvent actionEvent) {
        try {
            stage3.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/employee_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage3.show();
    }

    public void logoutaction(ActionEvent actionEvent) {
        Stage stage4 = new Stage();
    }

    public void addaction(ActionEvent actionEvent) {
        String id = txtid.getText();
        String title = txttitle.getText();
        String name = txtname.getText();
        String dob = txtdate.getValue().toString();
        double salary = Double.parseDouble(txtsalary.getText());
        String address = txtaddress.getText();
        String city = txtcity.getText();
        String province = txtprovince.getText();
        String postcode = txtpost.getText();

        customercontroller.addCustomerDetails(id, title, name, dob, salary, address, city, province, postcode);

        loadCustomer();
    }

    public void updateaction(ActionEvent actionEvent) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/togakademanagement", "root", "1234");
            PreparedStatement pstm = connection.prepareStatement("UPDATE Customer SET Title = ?, Name = ?, DateOfBirth = ?, Salary = ?, Address = ?, City = ?, Province = ?, PostalCode = ? WHERE CustomerID = ?");
            pstm.setString(1, txttitle.getText());
            pstm.setString(2, txtname.getText());
            pstm.setString(3, txtdate.getValue().toString());
            pstm.setDouble(4, Double.parseDouble(txtsalary.getText()));
            pstm.setString(5, txtaddress.getText());
            pstm.setString(6, txtcity.getText());
            pstm.setString(7, txtprovince.getText());
            pstm.setString(8, txtpost.getText());
            pstm.setString(9, txtid.getText());
            pstm.executeUpdate();
            loadCustomer();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void deleteaction(ActionEvent actionEvent) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/togakademanagement", "root", "1234");
            PreparedStatement pstm = connection.prepareStatement("DELETE FROM Customer WHERE CustomerID = ?");
            pstm.setString(1, txtid.getText());
            pstm.executeUpdate();
            loadCustomer();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        custid.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("custid"));
        custtitle.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("custtitle"));
        custname.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("custname"));
        custdob.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("custdob"));
        custsalary.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("custsalary"));
        custaddress.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("custaddress"));
        custcity.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("custcity"));
        custprovince.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("custprovince"));
        custpostcode.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("custpostcode"));

        custtable.setItems(customerinfoDTOS);
        loadCustomer();

        custtable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                txtid.setText(newValue.getCustid());
                txttitle.setText(newValue.getCusttitle());
                txtname.setText(newValue.getCustname());
                txtdate.setValue(java.time.LocalDate.parse(newValue.getCustdob()));
                txtsalary.setText(String.valueOf(newValue.getCustsalary()));
                txtaddress.setText(newValue.getCustaddress());
                txtcity.setText(newValue.getCustcity());
                txtprovince.setText(newValue.getCustprovince());
                txtpost.setText(newValue.getCustpostalcode());
            }
        });


    }

    private void loadCustomer() {
        customerinfoDTOS.clear();

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

    }
}