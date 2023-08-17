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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class DeleteController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back;

    @FXML
    private Button delete;

    @FXML
    private Button yes;

    @FXML
    private Button no;

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
        text.setVisible(false);
        yes.setVisible(false);
        no.setVisible(false);
        back.setOnAction(event -> new WindowApp().getWindow(back, "../forms/MenuForm.fxml"));

        table.setItems(getData());
        word.setCellValueFactory(new PropertyValueFactory<>("word"));
        frequency.setCellValueFactory(new PropertyValueFactory<>("frequency"));

        delete.setOnAction(event1 -> {
            if (table.getSelectionModel().getSelectedIndex() != -1) {
                System.out.println(table.getSelectionModel().getSelectedIndex());
                text.setVisible(true);
                yes.setVisible(true);
                no.setVisible(true);
                delete.setVisible(false);
                yes.setOnAction(event2 -> {
                    Vocabulary.getInstance().getVocabulary().remove(table.getSelectionModel().getSelectedItem().getWord());
                    table.getItems().remove(table.getSelectionModel().getSelectedIndex());
                    delete.setVisible(true);
                    text.setVisible(false);
                    yes.setVisible(false);
                    no.setVisible(false);
                });
                no.setOnAction(event2 -> {
                    delete.setVisible(true);
                    text.setVisible(false);
                    yes.setVisible(false);
                    no.setVisible(false);
                });
            }
        });
    }

    private ObservableList<Word> getData() {
        ObservableList<Word> data = FXCollections.observableArrayList();
        for (Map.Entry<String, Integer> entry : Vocabulary.getInstance().getVocabulary().entrySet()) {
            data.add(new Word(entry.getKey(), entry.getValue(),null,null,null));
        }
        return data;
    }
}
