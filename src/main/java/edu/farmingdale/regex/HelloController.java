package edu.farmingdale.regex;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
/**
 * Controller for the registration form UI.
 * Handles form validation, dynamic styling, and screen transitions.
 */
public class HelloController {

    @FXML
    private Label warningLabel,firstNameLabel,lastNameLabel,emailLabel,dobLabel,zipCodeLabel;
    @FXML
    private TextField firstNameField,lastNameField,emailField,dobField,zipCodeField;
    @FXML
    private Button registerButton;
    @FXML
    private AnchorPane screenPane,registerForm;

    //this will help to enable the button when all the TextFields are properly completed
    private boolean isFirstNameValid = false;
    private boolean isLastNameValid = false;
    private boolean isEmailValid = false;
    private boolean isDobValid = false;
    private boolean isZipValid = false;

    /**
     * Initializes the controller after the FXML fields are injected.
     * Sets up the UI and enables validation logic.
     */
    @FXML
    public  void initialize() {
        setUP();
        validation();

    }
    /**
     * Sets up the initial visual state of the form,
     * including background colors and button state.
     */
    public void setUP(){

        warningLabel.setVisible(false);

        screenPane.setBackground(new Background(new BackgroundFill(Color.rgb(100,190,255), null, null)));

        registerForm.setBackground(new Background(new BackgroundFill(Color.web("#E2F1FD"), new CornerRadii(40), null)));

        registerButton.setDisable(true);
    }
    /**
     * Adds focus listeners to all input fields for validation.
     * Displays warning messages and updates form state accordingly.
     */
    public void validation() {

        //Listener logic for the Name textField
        firstNameField.focusedProperty().addListener((_, _, newVal) -> {
            if (!newVal) {
                String input = firstNameField.getText();
                if (!input.matches("^[A-Za-z]{2,25}$")) {
                    warningLabel.setText("First name must be 2–25 letters.");
                    warningLabel.setVisible(true);
                    firstNameLabel.setTextFill(Color.RED);
                    isFirstNameValid = false;
                } else {
                    warningLabel.setVisible(false);
                    firstNameLabel.setTextFill(Color.BLACK);
                    isFirstNameValid = true;
                }
                enableButton();
            }

        });

        //Listener logic for the Last name textField
        lastNameField.focusedProperty().addListener((_, _, newVal) -> {
            if (!newVal) {
                String input = lastNameField.getText();
                if (!input.matches("^[A-Za-z]{2,25}$")) {
                    warningLabel.setText("Last name must be 2–25 letters.");
                    warningLabel.setVisible(true);
                    lastNameLabel.setTextFill(Color.RED);
                    isLastNameValid = false;
                } else {
                    warningLabel.setVisible(false);
                    lastNameLabel.setTextFill(Color.BLACK);
                    isLastNameValid = true;
                }
                enableButton();
            }

        });

        //Listener logic for the email textField
        emailField.focusedProperty().addListener((_, _, newVal) -> {
            if (!newVal) {
                String input = emailField.getText();
                if (!input.matches("^[\\w.-]+@farmingdale\\.edu$")) {
                    warningLabel.setText("Enter a valid FSC email.");
                    warningLabel.setVisible(true);
                    emailLabel.setTextFill(Color.RED);
                    isEmailValid = false;
                } else {
                    warningLabel.setVisible(false);
                    emailLabel.setTextFill(Color.BLACK);
                    isEmailValid = true;
                }
                enableButton();
            }

        });

        //Listener logic for the Date of Birth textField
        dobField.focusedProperty().addListener((_, _, newVal) -> {
            if (!newVal) {
                String input = dobField.getText();
                // The following regex still have somes flaws but it is a pretty good one for DoB Validation
                if (!input.matches("^(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/((19|20)\\d{2})$")) {
                    warningLabel.setText("DOB must be in MM/DD/YYYY format.");
                    warningLabel.setVisible(true);
                    dobLabel.setTextFill(Color.RED);
                    isDobValid = false;
                } else {
                    warningLabel.setVisible(false);
                    dobLabel.setTextFill(Color.BLACK);
                    isDobValid = true;
                }
                enableButton();
            }

        });

        //Listener logic for the Zipcode textField
        zipCodeField.focusedProperty().addListener((_, _, newVal) -> {
            if (!newVal) {
                String input = zipCodeField.getText();
                if (!input.matches("^\\d{5}$")) {
                    warningLabel.setText("Zip code must be 5 digits.");
                    warningLabel.setVisible(true);
                    zipCodeLabel.setTextFill(Color.RED);
                    isZipValid = false;
                } else {
                    warningLabel.setVisible(false);
                    zipCodeLabel.setTextFill(Color.BLACK);
                    isZipValid = true;
                }
                enableButton();
            }

        });


    }
    /**
     * Enables the register button only if all input fields are valid.
     */
    private void enableButton(){
       if(isFirstNameValid&&isLastNameValid&&isEmailValid&&isDobValid&&isZipValid){
        registerButton.setDisable(false);
       }else {
           registerButton.setDisable(true);
       }
    }
    /**
     * Handles switching to a new screen when the register button is pressed.
     *
     * @throws IOException if the FXML file for the new screen cannot be loaded.
     */
    @FXML
    public void changeScreenButton() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("newScreen.fxml"));
        Scene newScene = new Scene(fxmlLoader.load(), 1000, 800);
        Stage currentStage = (Stage) registerButton.getScene().getWindow();
        currentStage.setScene(newScene);

    }


}