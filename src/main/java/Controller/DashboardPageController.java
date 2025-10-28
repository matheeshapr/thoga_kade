package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardPageController {

    Stage stage = new Stage();

    public void custaction(ActionEvent actionEvent) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/customer_page.fxml"))));
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

    }
}
