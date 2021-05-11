package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import sudoku.Sudoku;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import sudoku.SudokuMap;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


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

    Sudoku sudoku;

    static Logger log;

    ObjectMapper objectmapper = new ObjectMapper();







    public void initdata(String username) {
        this.username = username;
        usernameLabel.setText("Welcome " + this.username);
    }

    @FXML
    public void initialize() {
        sudoku = new Sudoku();

        dropDownMenu.getItems().add("EASY");
        dropDownMenu.getItems().add("MEDIUM");
        dropDownMenu.getItems().add("HARD");

        Board.setDisable(true);


    }

    @FXML
    public void exitGame() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void showScoreboard() {
        //TODO
        // if(playerWon){
        //  ...
    }

    @FXML
    public void startGame() throws IOException {

        if(dropDownMenu.getSelectionModel().getSelectedItem() == "EASY"){
            SudokuMap easymap = objectmapper.readValue(getClass().getResourceAsStream("/maps/easy.json"),SudokuMap.class);
            initializeTable(easymap);
            Board.setDisable(false);
            //startTimer();
        }



    }

    private void loadMap(String map) {
        // TODO
        // if(map == "EASY") drawMap(easy.json).
    }

    private void startTimer() {

    }

    private void initializeTable(SudokuMap map) {

        String style = "-fx-border-style: solid; -fx-border-style: solid;";
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                TextField temp = new TextField();
                temp.setMaxHeight(60);
                temp.setMaxWidth(60);
                temp.setFont(Font.font("Impact", 18));
                int value = sudoku.setValue(map.getMatrix()[i][j],i+1,j+1);
                if(value!=0){
                    temp.setText(Integer.toString(value));
                    temp.setDisable(true);
                }

                temp.setOnKeyPressed( e -> {

                    for(int h=0;h<9;h++){
                        for(int k=0;k<3;k++){
                            for(int l=0;l<3;l++){
                                //TODO
                            }
                    }

                    int code = e.getCode().getCode() - 96;
                    System.out.println(code);
                    if (code > 0 && code < 10) {
                        int text = sudoku.setValue(code, Board.getRowIndex(temp) + 1, Board.getColumnIndex(temp) + 1);
                        if (text == 0) {
                            temp.setStyle(temp.getStyle().replaceFirst("-fx-text-fill: \\S+","-fx-text-fill: red"));

                        }
                        else{
                            temp.setStyle(temp.getStyle().replaceFirst("-fx-text-fill: \\S+","-fx-text-fill: white"));
                        }

                    }

                    System.out.println(temp.getStyle());
                    System.out.println(temp.getText().length());
                }


                );
                if (((j / 3) % 2) == ((i / 3) % 2) || (((j / 3) % 2 == 0) && ((i / 3) % 2 == 0))) {
                    temp.setStyle(style + "-fx-background-color: #4B4B4B; -fx-text-fill: #D4D4D4");
                } else {
                    temp.setStyle(style + "-fx-background-color: #D4D4D4; -fx-text-fill: #4B4B4B");
                }
                Board.add(temp, j, i);
            }
        }
    }


}

