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

    @FXML
    void deleteaction(ActionEvent event) {
        SuppliyDTO selectedSupplier = suptable.getSelectionModel().getSelectedItem();
        if (selectedSupplier != null) {
            suppliyDTOS.remove(selectedSupplier);
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
    void updateaction(ActionEvent event) {
        SuppliyDTO selectedSupplier = suptable.getSelectionModel().getSelectedItem();
        if (selectedSupplier != null) {
            selectedSupplier.setId(txtid.getText());
            selectedSupplier.setName(txtname.getText());
            selectedSupplier.setComname(txtname1.getText());
            selectedSupplier.setAddress(txtaddress.getText());
            selectedSupplier.setCity(txtcity.getText());
            selectedSupplier.setProvince(txtprovince.getText());
            selectedSupplier.setPostcode(txtpost.getText());
            selectedSupplier.setPhno(txtsalary.getText());
            selectedSupplier.setEmail(txttitle.getText());
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

    }

    @FXML
    void viewaction(ActionEvent event) {
        SuppliyDTO selectedSupplier = suptable.getSelectionModel().getSelectedItem();
        if (selectedSupplier != null) {
            txtid.setText(selectedSupplier.getSupid());
            txtname.setText(selectedSupplier.getSupname());
            txtname1.setText(selectedSupplier.getComname());
            txtaddress.setText(selectedSupplier.getAddress());
            txtcity.setText(selectedSupplier.getCity());
            txtprovince.setText(selectedSupplier.getProvince());
            txtpost.setText(selectedSupplier.getPostcode());
            txtsalary.setText(selectedSupplier.getPhno());
            txttitle.setText(selectedSupplier.getEmail());

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
}
