package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;
import persistence.DataHandler;

import java.io.IOException;

public class ScoreboardController {


    @FXML
    private TableView Scoreboard;

    @FXML
    private TableColumn player;

    @FXML
    private TableColumn map;

    @FXML
    private TableColumn time;

    @FXML
    private TableColumn date;

    @FXML
    private Button exitButton;

    @FXML
    private DataHandler handler;

    @FXML
    public void exitGame(){
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }


    @FXML
    public void startNewGame(ActionEvent e){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/launch.fxml"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void initialize()throws Exception {

        //handler.getData();
        Scoreboard.getItems().addAll(1,"vmi");


    }
}
