package controller;

import additionalSystems.Main;
import additionalSystems.WindowApp;
import entity.Vocabulary;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class MenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ise;

    @FXML
    private Button showButton;

    @FXML
    private Button addButton;

    @FXML
    private Button vocButton;

    @FXML
    private Button colorButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button correctButton;

    @FXML
    private Button fileButton;

    @FXML
    private Button save;

    @FXML
    private Button reset;

    static int checkFile;

    @FXML
    void initialize() {
        fileButton.setOnAction(event -> {
            checkFile = 0;
            new WindowApp().getWindow(showButton, "../forms/TextForm.fxml");
        });
        vocButton.setOnAction(event -> {
            checkFile = 1;
            new WindowApp().getWindow(showButton, "../forms/TextForm.fxml");
        });
        colorButton.setOnAction(event -> {
            checkFile = 2;
            new WindowApp().getWindow(showButton, "../forms/TextForm.fxml");
        });
        showButton.setOnAction(event -> new WindowApp().getWindow(showButton, "../forms/ShowForm.fxml"));
        addButton.setOnAction(event -> new WindowApp().getWindow(showButton, "../forms/AddForm.fxml"));
        deleteButton.setOnAction(event -> new WindowApp().getWindow(showButton, "../forms/DeleteForm.fxml"));
        correctButton.setOnAction(event -> new WindowApp().getWindow(showButton, "../forms/CorrectForm.fxml"));
        save.setOnAction(event -> saveToFile(Vocabulary.getInstance().getVocabulary()));
        reset.setOnAction(event -> {
            Vocabulary.getInstance().getVocabulary().clear();
            ColorController.words.clear();
            ColorController.tags.clear();
            ColorController.obs.clear();
        });
        ise.setOnAction(event -> new WindowApp().getWindow(showButton, "../forms/RelevForm.fxml"));
    }

    private void saveToFile(Map<String, Integer> map) {
        FileChooser fileChooser = new FileChooser();
        try {
            File temp = fileChooser.showSaveDialog(Main.primary);
            if (temp != null) {
                FileWriter file = new FileWriter(temp);
                for (Map.Entry entry : map.entrySet()) {
                    file.write(entry.getKey() + "\t" + entry.getValue() + "\n");
                }
                file.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
