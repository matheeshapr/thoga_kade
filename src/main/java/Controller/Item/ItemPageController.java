package Controller.Item;

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
import java.sql.*;
import java.util.ResourceBundle;

public class ItemPageController implements Initializable {

    ObservableList<ItemDTO> iteminfoDTOS = FXCollections.observableArrayList();

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


    Stage stage3 = new Stage();

    @FXML
    void custaction(ActionEvent event) {
        try {
            stage3.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/customer_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage3.show();

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


    Stage stage1 = new Stage();

    @FXML
    void empaction(ActionEvent event) {
        try {
            stage1.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/employee_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage1.show();

    }

    @FXML
    void logoutaction(ActionEvent event) {

    }

    Stage stage2 = new Stage();

    @FXML
    void suppaction(ActionEvent event) {
        try {
            stage2.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/supplyier_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage2.show();

    }

    @FXML
    void addaction(ActionEvent event) {
        String code = txtcode.getText();
        String des = txtdes.getText();
        String cate = txtdes.getText();
        String qty = txtqty.getText();
        Double price = Double.valueOf(txtunit.getText());

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/togakademanagement", "root", "1234");
            PreparedStatement pstm = connection.prepareStatement("INSERT INTO Item VALUES (?, ?, ?, ?, ?)");

            pstm.setString(1, code);
            pstm.setString(2, des);
            pstm.setString(3, cate);
            pstm.setString(4, qty);
            pstm.setDouble(5, price);

            pstm.execute();
            loadItem();

        } catch (SQLException e) {
         throw new RuntimeException(e);
        }

    }

    @FXML
    void deleteaction(ActionEvent event) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/togakademanagement", "root", "1234");
            PreparedStatement pstm = connection.prepareStatement("DELETE FROM Item WHERE ItemCode = ?");
            pstm.setString(1, txtcode.getText());
            pstm.execute();
            loadItem();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @FXML
    void updateaction(ActionEvent event) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/togakademanagement", "root", "1234");
            PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET Description = ?, Category = ?, QtyOnHand = ?, UnitPrice = ? WHERE ItemCode = ?");

            pstm.setString(1, txtdes.getText());
            pstm.setString(2, txtcate.getText());
            pstm.setString(3, txtqty.getText());
            pstm.setDouble(4, Double.valueOf(txtunit.getText()));
            pstm.setString(5, txtcode.getText());

            pstm.execute();
            loadItem();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        itemcode.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("itemCode"));
        itemdes.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("itemDes"));
        itemcate.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("itemCate"));
        itemqty.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("itemQty"));
        itemunitp.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("itemPrice"));
        itemtable.setItems(iteminfoDTOS);
        loadItem();

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

    private void loadItem() {
        iteminfoDTOS.clear();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Togakademanagement", "root", "1234");
            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Item");
            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                ItemDTO items = new ItemDTO(
                        resultSet.getString("ItemCode"),
                        resultSet.getString("Description"),
                        resultSet.getString("Category"),
                        resultSet.getString("QtyOnHand"),
                        resultSet.getDouble("UnitPrice")
                );
                iteminfoDTOS.add(items);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
