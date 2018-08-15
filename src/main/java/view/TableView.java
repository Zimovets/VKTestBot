package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TableView {

    public void init() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/table3.fxml"));
        stage.setTitle("Table");
        stage.setScene(new Scene(root, 700, 400));
        stage.show();
    }
}
