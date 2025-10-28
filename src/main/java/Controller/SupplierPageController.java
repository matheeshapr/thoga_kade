package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.dto.SuppliyDTO;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class SupplierPageController implements Initializable {

    ObservableList<SuppliyDTO> suppliyDTOS = FXCollections.observableArrayList();

    @FXML
    private TableView<SuppliyDTO> suptable;

    @FXML
    private TableColumn<?, ?> supaddress;

    @FXML
    private TableColumn<?, ?> supcity;

    @FXML
    private TableColumn<?, ?> supcomname;

    @FXML
    private TableColumn<?, ?> supemail;

    @FXML
    private TableColumn<?, ?> supid;

    @FXML
    private TableColumn<?, ?> supname;

    @FXML
    private TableColumn<?, ?> supphno;

    @FXML
    private TableColumn<?, ?> suppostcode;

    @FXML
    private TableColumn<?, ?> supprvince;

    @FXML
    private TextField txtaddress;

    @FXML
    private TextField txtcity;

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtname1;

    @FXML
    private TextField txtpost;

    @FXML
    private TextField txtprovince;

    @FXML
    private TextField txtsalary;

    @FXML
    private TextField txttitle;

    Stage stage = new Stage();

    @FXML
    void custaction(ActionEvent event) {
        try {
            stage.setScene(new javafx.scene.Scene(javafx.fxml.FXMLLoader.load(getClass().getResource("/view/customer_page.fxml"))));
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

    }

    Stage stage1 = new Stage();

    @FXML
    void dashaction(ActionEvent event) {
        try {
            stage1.setScene(new javafx.scene.Scene(javafx.fxml.FXMLLoader.load(getClass().getResource("/view/dashboard_page.fxml"))));
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
        stage1.show();

    }

    Stage stage2 = new Stage();

    @FXML
    void empaction(ActionEvent event) {
        try {
            stage2.setScene(new javafx.scene.Scene(javafx.fxml.FXMLLoader.load(getClass().getResource("/view/employee_page.fxml"))));
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
        stage2.show();

    }

    Stage stage3 = new Stage();

    @FXML
    void itemaction(ActionEvent event) {
        try {
            stage3.setScene(new javafx.scene.Scene(javafx.fxml.FXMLLoader.load(getClass().getResource("/view/item_page.fxml"))));
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
        stage3.show();

    }

    @FXML
    void logoutaction(ActionEvent event) {

    }

    @FXML
    void addaction(ActionEvent event) {
        String id = txtid.getText();
        String name = txtname.getText();
        String comname = txtname1.getText();
        String address = txtaddress.getText();
        String city = txtcity.getText();
        String province = txtprovince.getText();
        String post = txtpost.getText();
        String phno = txtsalary.getText();
        String email = txttitle.getText();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/togakademanagement", "root", "1234");
            PreparedStatement pstm = connection.prepareStatement("INSERT INTO Supplier VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pstm.setString(1, id);
            pstm.setString(2, name);
            pstm.setString(3, comname);
            pstm.setString(4, address);
            pstm.setString(5, city);
            pstm.setString(6, province);
            pstm.setString(7, post);
            pstm.setString(8, phno);
            pstm.setString(9, email);
            pstm.executeUpdate();
            loadSupplier();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @FXML
    void deleteaction(ActionEvent event) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/togakademanagement", "root", "1234");
            PreparedStatement pstm = connection.prepareStatement("DELETE FROM Supplier WHERE SupplierID = ?");
            pstm.setString(1, txtid.getText());
            pstm.executeUpdate();
            loadSupplier();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void updateaction(ActionEvent event) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/togakademanagement", "root", "1234");
            PreparedStatement pstm = connection.prepareStatement("UPDATE Supplier SET SupplierName = ?, CompanyName = ?, Address = ?, City = ?, Province = ?, PostalCode = ?, PhoneNumber = ?, Email = ? WHERE SupplierID = ?");
            pstm.setString(1, txtname.getText());
            pstm.setString(2, txtname1.getText());
            pstm.setString(3, txtaddress.getText());
            pstm.setString(4, txtcity.getText());
            pstm.setString(5, txtprovince.getText());
            pstm.setString(6, txtpost.getText());
            pstm.setString(7, txtsalary.getText());
            pstm.setString(8, txttitle.getText());
            pstm.setString(9, txtid.getText());
            pstm.executeUpdate();
            loadSupplier();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        supid.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("supid"));
        supname.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("supname"));
        supcomname.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("comname"));
        supaddress.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("address"));
        supcity.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("city"));
        supprvince.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("province"));
        suppostcode.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("postcode"));
        supphno.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("phno"));
        supemail.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("email"));
        suptable.setItems(suppliyDTOS);
        loadSupplier();

        suptable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                txtid.setText(newValue.getSupid());
                txtname.setText(newValue.getSupname());
                txtname1.setText(newValue.getComname());
                txtaddress.setText(newValue.getAddress());
                txtcity.setText(newValue.getCity());
                txtprovince.setText(newValue.getProvince());
                txtpost.setText(newValue.getPostcode());
                txtsalary.setText(newValue.getPhno());
                txttitle.setText(newValue.getEmail());
            }
        });

    }

    private void loadSupplier() {
        suppliyDTOS.clear();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/togakademanagement", "root", "1234");
            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Supplier");
            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                SuppliyDTO supplyer = new SuppliyDTO(
                        resultSet.getString("SupplierID"),
                        resultSet.getString("SupplierName"),
                        resultSet.getString("CompanyName"),
                        resultSet.getString("Address"),
                        resultSet.getString("City"),
                        resultSet.getString("Province"),
                        resultSet.getString("PostalCode"),
                        resultSet.getString("PhoneNumber"),
                        resultSet.getString("Email")
                );
                suppliyDTOS.add(supplyer);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
