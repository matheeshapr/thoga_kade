package Controller;

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
import java.util.ResourceBundle;

public class   CustomerPageController implements Initializable {

    ObservableList<CustomerDTO> customerinfoDTOS = FXCollections.observableArrayList(
            new CustomerDTO("C001", "Mr", "Jhon Doe", "11/03/2003", "235153.00", "122/3, New York", "New York", "New York", "1234"),
            new CustomerDTO("C002", "Ms", "Jane Smith", "12/04/2004", "253153.00", "456, Los Angeles", "Los Angeles", "Los Angeles", "5678"),
            new CustomerDTO("C003", "Mrs", "Alice Johnson", "13/05/2005", "273153.00", "789, Chicago", "Chicago", "Chicago", "9101"),
            new CustomerDTO("C004", "Dr", "Bob Brown", "14/06/2006", "293153.00", "321, Houston", "Houston", "Houston", "1121")
    );

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

    public void itemaction(ActionEvent actionEvent) {
    }

    public void suppaction(ActionEvent actionEvent) {
    }

    public void empaction(ActionEvent actionEvent) {
    }

    public void logoutaction(ActionEvent actionEvent) {
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

        CustomerDTO customerDTO = new CustomerDTO(id, title, name, dob, String.valueOf(salary), address, city, province, postcode);
        customerinfoDTOS.add(customerDTO);
        custtable.refresh();

        txtid.setText("");
        txttitle.setText("");
        txtname.setText("");
        txtdate.setValue(null);
        txtsalary.setText("");
        txtaddress.setText("");
        txtcity.setText("");
        txtprovince.setText("");
        txtpost.setText("");
    }

    public void viewaction(ActionEvent actionEvent) {
        CustomerDTO selectedCustomer = custtable.getSelectionModel().getSelectedItem();
        if (selectedCustomer != null) {
            txtid.setText(selectedCustomer.getCustid());
            txttitle.setText(selectedCustomer.getCusttitle());
            txtname.setText(selectedCustomer.getCustname());
            txtdate.setValue(java.time.LocalDate.parse(selectedCustomer.getCustdob()));
            txtsalary.setText(String.valueOf(selectedCustomer.getCustsalary()));
            txtaddress.setText(selectedCustomer.getCustaddress());
            txtcity.setText(selectedCustomer.getCustcity());
            txtprovince.setText(selectedCustomer.getCustprovince());
            txtpost.setText(selectedCustomer.getCustpostalcode());

        }
    }

    public void updateaction(ActionEvent actionEvent) {
    }

    public void deleteaction(ActionEvent actionEvent) {
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
            ;
        });

    }
}
