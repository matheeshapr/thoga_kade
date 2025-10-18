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


    public void itemaction(ActionEvent actionEvent) {
    }

    public void suppaction(ActionEvent actionEvent) {
    }

    public void empaction(ActionEvent actionEvent) {
    }

    public void logoutaction(ActionEvent actionEvent) {
    }
}
