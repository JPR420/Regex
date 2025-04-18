package edu.farmingdale.regex;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * Main application class for the registration form.
 * Loads the initial FXML view and starts the JavaFX application.
 */
public class HelloApplication extends Application {
    /**
     * Starts the JavaFX application and loads the main registration screen.
     *
     * @param stage the primary stage for this application.
     * @throws IOException if the FXML file cannot be loaded.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        scene.getStylesheets().add(String.valueOf(getClass().getResource("style.css")));
        stage.setTitle("Register");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    /**
     * Launches the application.
     *
     * @param args the command-line arguments.
     */
    public static void main(String[] args) {

        launch();
    }
}