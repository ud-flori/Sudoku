package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class LaunchController {

    @FXML
    private TextField username;

    @FXML
    private Label errorLabel;

    public void startAction(ActionEvent actionEvent) throws IOException {
        if ((username.getText().isEmpty() || username.getText().getBytes().length > 10)) {
            errorLabel.setText("Invalid username!");
        }
        else{

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/sudoku.fxml"));
            Parent root = fxmlLoader.load();
            fxmlLoader.<SudokuController>getController().initdata(username.getText());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }

    }
}