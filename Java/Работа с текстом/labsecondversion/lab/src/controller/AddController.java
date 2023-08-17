package controller;

import entity.Vocabulary;
import additionalSystems.WindowApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class AddController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button add;

    @FXML
    private Button back;

    @FXML
    private Text text;

    @FXML
    private TextField field;

    @FXML
    void initialize() {
        text.setVisible(false);
        back.setOnAction(event -> new WindowApp().getWindow(back, "../forms/MenuForm.fxml"));

        add.setOnAction(event -> {
            if (Vocabulary.getInstance().getVocabulary().containsKey(field.getText())) {
                text.setStyle("-fx-fill: red;");
                text.setVisible(true);
            } else {
                Vocabulary.getInstance().getVocabulary().put(field.getText(), 0);
                text.setText("The word was added successfully!");
                text.setStyle("-fx-fill: green;");
                text.setVisible(true);
            }
        });
    }
}
