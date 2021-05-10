package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

import java.util.Timer;
import java.util.TimerTask;


@Slf4j
public class SudokuController {

    @FXML
    private String username;

    @FXML
    Label usernameLabel;

    @FXML
    Button exitButton;

    @FXML
    Button scoreBoardButton;

    @FXML
    ChoiceBox dropDownMenu;

    @FXML
    Label timerContent;

    @FXML
    GridPane Board;

    boolean gameIsRunning = false;

    public void initdata(String username){
        this.username = username;
        usernameLabel.setText("Welcome "+ this.username);
    }

    @FXML
    public void initialize(){
        dropDownMenu.getItems().add("EASY");
        dropDownMenu.getItems().add("MEDIUM");
        dropDownMenu.getItems().add("HARD");

    }

    @FXML
    public void exitGame(){
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void showScoreboard(){
        //TODO
        // if(playerWon){
        //  ...
    }

    @FXML
    public void startGame(){
        //loadMap(dropDownMenu.getSelectionModel().getSelectedItem())
        gameIsRunning = true;
        //startTimer();
        initializeTable();

    }

    private void loadMap(String map) {
        // TODO
        // if(map == "EASY") drawMap(easy.json).
    }

     private void startTimer() {

    }

    private void initializeTable(){
        String style = "-fx-border-style: solid; -fx-border-style: solid;";
        for(int i =0; i<9; i++){
            for(int j = 0; j<9;j++){
                TextField temp = new TextField();
                temp.setMaxHeight(60);
                temp.setMaxWidth(60);
                if(((j / 3) % 2) == ((i / 3) % 2) || (((j / 3) % 2 == 0) &&((i/3)%2 == 0))){
                    temp.setStyle(style + "-fx-background-color: #4B4B4B; -fx-text-fill: #D4D4D4");
                }
                else{
                    temp.setStyle(style + "-fx-background-color: #D4D4D4; -fx-text-fill: #4B4B4B");
                }
                Board.add(temp,j,i);

            }
        }


    }

    }
