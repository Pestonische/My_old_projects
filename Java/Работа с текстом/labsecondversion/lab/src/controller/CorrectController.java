package controller;

import additionalSystems.WindowApp;
import entity.Vocabulary;
import entity.Word;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.ResourceBundle;

public class CorrectController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back;

    @FXML
    private Button correct;

    @FXML
    private TextField field;

    @FXML
    private Text text;

    @FXML
    private TableView<Word> table;

    @FXML
    private TableColumn<Word, String> word;

    @FXML
    private TableColumn<Word, Integer> frequency;

    @FXML
    void initialize() {
        back.setOnAction(event -> new WindowApp().getWindow(back, "../forms/MenuForm.fxml"));

        table.setItems(getData());
        word.setCellValueFactory(new PropertyValueFactory<>("word"));
        frequency.setCellValueFactory(new PropertyValueFactory<>("frequency"));

        field.setEditable(false);

        correct.setOnAction(event -> {
            if (table.getSelectionModel().getSelectedIndex() != -1) {
                field.setEditable(true);
                field.setText(table.getSelectionModel().getSelectedItem().getWord());
                text.setText("Correct the word");
                correct.setText("OK");
                correct.setOnAction(event1 -> {
                    changeFile(table.getSelectionModel().getSelectedItem().getWord(), field.getText());
                    int freq1 = Vocabulary.getInstance().getVocabulary()
                            .get(table.getSelectionModel().getSelectedItem().getWord());
                    int freq2 = 0;
                    if (Vocabulary.getInstance().getVocabulary().containsKey(field.getText())) {
                        freq2 = Vocabulary.getInstance().getVocabulary().get(field.getText());
                    }
                    Vocabulary.getInstance().getVocabulary().remove(table.getSelectionModel().getSelectedItem().getWord());
                    Vocabulary.getInstance().getVocabulary().put(field.getText(), freq1 + freq2);
                    table.getItems().remove(table.getSelectionModel().getSelectedIndex());
                    //table.getItems().add(new Word(field.getText(), freq1 + freq2));
                    field.setText("");
                    text.setText("Choose the word");
                    correct.setText("Correct");
                    field.setEditable(true);
                });
            }
            table.refresh();
        });
    }

    private ObservableList<Word> getData() {
        ObservableList<Word> data = FXCollections.observableArrayList();
        for (Map.Entry<String, Integer> entry : Vocabulary.getInstance().getVocabulary().entrySet()) {
            data.add(new Word(entry.getKey(), entry.getValue(),null,null,null));
        }
        return data;
    }

    private void changeFile(String oldWord, String newWord) {
        String fileName = TextController.fileName;
        Charset charset = StandardCharsets.UTF_8;
        Path path = Paths.get(fileName);
        oldWord = " " + oldWord + " ";
        newWord = " " + newWord + " ";
        String oldWord1 = "\"" + oldWord + "\"";
        String newWord1 = "\"" + newWord + "\"";
        String oldWord2 = " " + oldWord + ".";
        String newWord2 = " " + newWord + ".";
        String oldWord3 = " " + oldWord + ",";
        String newWord3 = " " + newWord + ",";
        String oldWord4 = " " + oldWord + "!";
        String newWord4 = " " + newWord + "!";
        String oldWord5 = " " + oldWord + "?";
        String newWord5 = " " + newWord + "?";
        try {

            Files.write(path, new String(Files.readAllBytes(path), charset).replace(oldWord, newWord)
                    .getBytes(charset));
            Files.write(path, new String(Files.readAllBytes(path), charset).replace(oldWord1, newWord1)
                    .getBytes(charset));
            Files.write(path, new String(Files.readAllBytes(path), charset).replace(oldWord2, newWord2)
                    .getBytes(charset));
            Files.write(path, new String(Files.readAllBytes(path), charset).replace(oldWord3, newWord3)
                    .getBytes(charset));
            Files.write(path, new String(Files.readAllBytes(path), charset).replace(oldWord4, newWord4)
                    .getBytes(charset));
            Files.write(path, new String(Files.readAllBytes(path), charset).replace(oldWord5, newWord5)
                    .getBytes(charset));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
