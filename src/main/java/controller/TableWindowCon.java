package controller;

import domain.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TableWindowCon {

    private ObservableList<User> usersData = FXCollections.observableArrayList();

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
    private TableView<?> table;
}
