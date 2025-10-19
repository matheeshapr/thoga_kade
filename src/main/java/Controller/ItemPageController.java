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
import model.dto.ItemDTO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ItemPageController implements Initializable {

    ObservableList<ItemDTO> iteminfoDTOS = FXCollections.observableArrayList(
            new ItemDTO("I001", "Item A", "Education", 50+"", 25.50),
            new ItemDTO("I002", "Item B", "Electronics", 30+"", 99.99),
            new ItemDTO("I003", "Item C", "Groceries", 100+"", 5.75),
            new ItemDTO("I004", "Item D", "Clothing", 20+"", 49.99)

    );

    @FXML
    private TableColumn<?, ?> itemcate;

    @FXML
    private TableColumn<?, ?> itemcode;

    @FXML
    private TableColumn<?, ?> itemdes;

    @FXML
    private TableColumn<?, ?> itemqty;

    @FXML
    private TableView<ItemDTO> itemtable;

    @FXML
    private TableColumn<?, ?> itemunitp;

    @FXML
    private TextField txtcate;

    @FXML
    private TextField txtcode;

    @FXML
    private TextField txtdes;

    @FXML
    private TextField txtqty;

    @FXML
    private TextField txtunit;

    @FXML
    void addaction(ActionEvent event) {

    }

    @FXML
    void custaction(ActionEvent event) {

    }

    Stage stage = new Stage();
    @FXML
    void dashaction(ActionEvent event) {

        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dashboard_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

    }

    @FXML
    void deleteaction(ActionEvent event) {

    }

    @FXML
    void empaction(ActionEvent event) {

    }

    @FXML
    void logoutaction(ActionEvent event) {

    }

    @FXML
    void suppaction(ActionEvent event) {

    }

    @FXML
    void updateaction(ActionEvent event) {

    }

    @FXML
    void viewaction(ActionEvent event) {


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        itemcode.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("itemCode"));
        itemdes.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("itemName"));
        itemcate.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("itemCate"));
        itemqty.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("itemQty"));
        itemunitp.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("itemPrice"));
        itemtable.setItems(iteminfoDTOS);

        itemtable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                txtcode.setText(newValue.getItemCode());
                txtdes.setText(newValue.getItemDes());
                txtcate.setText(newValue.getItemCate());
                txtqty.setText(newValue.getItemQty());
                txtunit.setText(String.valueOf(newValue.getItemPrice()));
            }
        });
    }
}
