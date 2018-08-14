package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import service.VKService;

public class Controller {
    @FXML
    private Button start;

    @FXML
    void onStart(ActionEvent event) {
        VKService vkService = new VKService();
        try {
            vkService.doWork();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
