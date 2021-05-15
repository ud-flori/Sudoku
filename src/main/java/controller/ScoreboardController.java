package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import persistence.FinishData;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScoreboardController {

    @FXML
    private Button exitButton;

    @FXML
    private TableView<FinishData> highScoreTable;

    @FXML
    private TableColumn<FinishData, String> player;

    @FXML
    private TableColumn<FinishData, String> map;

    @FXML
    private TableColumn<FinishData, Integer> time;

    @FXML
    private TableColumn<FinishData, Date> date;

    @FXML
    private void initialize() throws IOException {

        DataHandler handler = new DataHandler();

        List<FinishData> list = handler.getData();
        ObservableList<FinishData> scores = FXCollections.observableArrayList();
        scores.addAll(list);

            highScoreTable.setItems(scores);
            player.setCellValueFactory(new PropertyValueFactory<>("player"));
            map.setCellValueFactory(new PropertyValueFactory<>("map"));
            time.setCellValueFactory(new PropertyValueFactory<>("time"));
            date.setCellValueFactory(new PropertyValueFactory<>("date"));



    }

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


}
