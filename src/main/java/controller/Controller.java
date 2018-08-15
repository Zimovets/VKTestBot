package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import service.VKService;
import view.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    private Button start;

    @FXML
    void onStart(ActionEvent event) {
        VKService vkService = new VKService();
        try {
            vkService.init();
            new TableView().init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
