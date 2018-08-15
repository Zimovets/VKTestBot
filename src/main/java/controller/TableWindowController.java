package controller;

import domain.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import service.VKService;

import java.net.URL;
import java.util.ResourceBundle;

public class TableWindowController implements Initializable {

    @FXML
    private Button closeButton;

    private ObservableList<User> usersData = FXCollections.observableArrayList();

    @FXML
    private TableView<User> table;

    @FXML
    private TableColumn<User, String> tableFirstName;

    @FXML
    private TableColumn<User, String> tableSecondName;

    @FXML
    private TableColumn<User, String> tableBirthDay;

    @FXML
    private TableColumn<User, String> tableMobile;

    @FXML
    private TableColumn<User, String> tableHomeCity;

    @FXML
    void onClose(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usersData.setAll(VKService.users);
        tableFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tableSecondName.setCellValueFactory(new PropertyValueFactory<>("secondName"));
        tableBirthDay.setCellValueFactory(new PropertyValueFactory<>("birthDay"));
        tableMobile.setCellValueFactory(new PropertyValueFactory<>("mobPhon"));
        tableHomeCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        table.setItems(usersData);
    }
}
