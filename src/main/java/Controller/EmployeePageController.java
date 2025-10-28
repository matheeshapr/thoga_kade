package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.dto.EmployeeDTO;

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

    }

    @FXML
    void custaction(ActionEvent event) {

    }

    @FXML
    void dashaction(ActionEvent event) {

    }

    @FXML
    void deleteaction(ActionEvent event) {

    }

    @FXML
    void itemaction(ActionEvent event) {

    }

    @FXML
    void logoutaction(ActionEvent event) {

    }

    @FXML
    void supaction(ActionEvent event) {

    }

    @FXML
    void updateaction(ActionEvent event) {

    }

    @FXML
    void viewaction(ActionEvent event) {

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
