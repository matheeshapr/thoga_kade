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
import java.util.ResourceBundle;

public class EmployeePageController implements Initializable {

    ObservableList<EmployeeDTO> empDTOS = FXCollections.observableArrayList(
            new EmployeeDTO("E001", "Kamal Perera", "991234567V", "1999-05-14", "Manager", "85000", "0771234567", "Colombo", "2020-03-01", "Active"),
            new EmployeeDTO("E002", "Saman Silva", "981234567V", "1995-08-22", "Cashier", "45000", "0769876543", "Badulla", "2019-07-15", "Active"),
            new EmployeeDTO("E003", "Nimal Fernando", "971234567V", "1990-12-05", "Chef", "60000", "0758765432", "Kandy", "2018-11-20", "Inactive"),
            new EmployeeDTO("E004", "Sunil Jayasuriya", "961234567V", "1985-03-30", "Waiter", "35000", "0747654321", "Negombo", "2021-01-10", "Active")
    );


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
        EmployeeDTO newEmployee = new EmployeeDTO(id, name, nic, dob, position, salary, conno, address, join, status);
        empDTOS.add(newEmployee);
        emptable.refresh();

        txtid.setText("");
        txtname.setText("");
        txtnic.setText("");
        txtdob.setText("");
        txtpostion.setText("");
        txtsalary.setText("");
        txtconno.setText("");
        txtaddress.setText("");
        txtjoind.setText("");
        txtstatus.setText("");


    }

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

    @FXML
    void deleteaction(ActionEvent event) {
        EmployeeDTO selectedEmployee = emptable.getSelectionModel().getSelectedItem();
        if (selectedEmployee != null) {
            empDTOS.remove(selectedEmployee);
            emptable.refresh();
            txtid.setText("");
            txtname.setText("");
            txtnic.setText("");
            txtdob.setText("");
            txtpostion.setText("");
            txtsalary.setText("");
            txtconno.setText("");
            txtaddress.setText("");
            txtjoind.setText("");
            txtstatus.setText("");
        }
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
    void updateaction(ActionEvent event) {
        EmployeeDTO selectedEmployee = emptable.getSelectionModel().getSelectedItem();
        if (selectedEmployee != null) {
            selectedEmployee.setId(txtid.getText());
            selectedEmployee.setName(txtname.getText());
            selectedEmployee.setNic(txtnic.getText());
            selectedEmployee.setDob(txtdob.getText());
            selectedEmployee.setPosition(txtpostion.getText());
            selectedEmployee.setSalary(txtsalary.getText());
            selectedEmployee.setConno(txtconno.getText());
            selectedEmployee.setAddress(txtaddress.getText());
            selectedEmployee.setJoin(txtjoind.getText());
            selectedEmployee.setStatus(txtstatus.getText());
            emptable.refresh();

            txtid.setText("");
            txtname.setText("");
            txtnic.setText("");
            txtdob.setText("");
            txtpostion.setText("");
            txtsalary.setText("");
            txtconno.setText("");
            txtaddress.setText("");
            txtjoind.setText("");
            txtstatus.setText("");
        }

    }

    @FXML
    void viewaction(ActionEvent event) {
        EmployeeDTO selectedEmployee = emptable.getSelectionModel().getSelectedItem();
        if (selectedEmployee != null) {
            txtid.setText(selectedEmployee.getId());
            txtname.setText(selectedEmployee.getName());
            txtnic.setText(selectedEmployee.getNic());
            txtdob.setText(selectedEmployee.getDob());
            txtpostion.setText(selectedEmployee.getPosition());
            txtsalary.setText(selectedEmployee.getSalary());
            txtconno.setText(selectedEmployee.getConno());
            txtaddress.setText(selectedEmployee.getAddress());
            txtjoind.setText(selectedEmployee.getJoin());
            txtstatus.setText(selectedEmployee.getStatus());

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
}
