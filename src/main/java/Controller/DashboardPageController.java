package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardPageController {

    public void custaction(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/customer_page.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
