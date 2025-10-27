package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.dto.SuppliyDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class SupplierPageController implements Initializable {

    ObservableList<SuppliyDTO> suppliyDTOS = FXCollections.observableArrayList(
            new SuppliyDTO("S001", "Amara", "ABC Company", "101/A,Panadura", "Panadura", "Colombo", "20526", "0768789463", "amara@gmail.com"),
            new SuppliyDTO("S002", "Nimal", "XYZ Corporation", "45/B, Galle Road", "Moratuwa", "Colombo", "10400", "0771234567", "nimal@yahoo.com"),
            new SuppliyDTO("S003", "Kavya", "PQR Enterprises", "12, Main Street", "Dehiwala", "Colombo", "10350", "0762345678", "kavya@gmail.com"),
            new SuppliyDTO("S004", "Sunil", "LMN Ltd", "78, High Level Road", "Nugegoda", "Colombo", "10250", "0713456789", "sunil@outlook.com")
    );

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

    @FXML
    void addaction(ActionEvent event) {
        String id = txtid.getText();
        String name = txtname.getText();
        String comname = txtname1.getText();
        String address = txtaddress.getText();
        String city = txtcity.getText();
        String province = txtprovince.getText();
        String postcode = txtpost.getText();
        String phno = txtsalary.getText();
        String email = txttitle.getText();

        SuppliyDTO newSupplier = new SuppliyDTO(id, name, comname, address, city, province, postcode, phno, email);
        suppliyDTOS.add(newSupplier);
        suptable.refresh();

        txtid.setText("");
        txtname.setText("");
        txtname1.setText("");
        txtaddress.setText("");
        txtcity.setText("");
        txtprovince.setText("");
        txtpost.setText("");
        txtsalary.setText("");
        txttitle.setText("");


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
    void empaction(ActionEvent event) {

    }

    @FXML
    void itemaction(ActionEvent event) {

    }

    @FXML
    void logoutaction(ActionEvent event) {

    }

    @FXML
    void updateaction(ActionEvent event) {

    }

    @FXML
    void viewaction(ActionEvent event) {

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

        suptable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            SuppliyDTO selectedSupplier = suptable.getSelectionModel().getSelectedItem();
            if (selectedSupplier != null) {
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
}
