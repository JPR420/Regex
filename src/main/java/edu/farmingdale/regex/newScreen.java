package edu.farmingdale.regex;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for the second screen that allows navigation back to the main registration screen.
 */
public class newScreen {

    @FXML
    private Button goBackButton;

    /**
     * Handles the "Go Back" button press and navigates to the main registration screen.
     *
     * @throws IOException if the FXML file for the main screen cannot be loaded.
     */
    @FXML
    protected void goBack() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Scene newScene = new Scene(fxmlLoader.load(), 1000, 800);
        Stage currentStage = (Stage) goBackButton.getScene().getWindow();
        currentStage.setScene(newScene);


    }
}
