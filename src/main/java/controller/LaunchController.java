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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;

/**
 * The class represents the Main Menu of the game.
 */
public class LaunchController {


    Logger logger = LogManager.getLogger(getClass());

    @FXML
    private TextField username;

    @FXML
    private Label errorLabel;


    /**
     * Event handler to handle input on the main menu.
     * @param actionEvent The event call argument.
     * @throws IOException Exception for file handling.
     */
    public void startAction(ActionEvent actionEvent) throws IOException {
        if ((username.getText().isEmpty() || username.getText().getBytes().length > 25)) {
            errorLabel.setText("Invalid username!");
        }
        else{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/sudoku.fxml"));
            Parent root = fxmlLoader.load();
            fxmlLoader.<SudokuController>getController().initdata(username.getText());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            logger.info("Application has started.");
        }

    }
}