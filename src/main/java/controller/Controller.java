package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import service.VKService;
import view.TableView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    private Button start;

    @FXML
    private Button showUsersButton;

    @FXML
    void onStart(ActionEvent event) {
        VKService vkService = new VKService();
        try {
            vkService.init();
            showUsersButton.disableProperty().set(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onShowUsers(ActionEvent event) {
        try {
            new TableView().init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
