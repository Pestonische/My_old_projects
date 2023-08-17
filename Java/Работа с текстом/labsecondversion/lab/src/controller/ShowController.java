package controller;

import additionalSystems.Main;
import additionalSystems.WindowApp;
import entity.Vocabulary;
import entity.Word;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import opennlp.tools.lemmatizer.LemmatizerME;
import opennlp.tools.lemmatizer.LemmatizerModel;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.util.Sequence;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Set;

public class ShowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back;

    @FXML
    private Button editButton;

    @FXML
    private TextField fieldText;

    @FXML
    private TableView<Word> table;

    @FXML
    private TableColumn<Word, String> word;

    @FXML
    private TableColumn<Word, Integer> frequency;

    @FXML
    private TableColumn<Word, String> tags;

    @FXML
    private TableColumn<Word, String> canForm;


    @FXML
    private TableColumn<Word, String> canTagsColumn;

    String[] resultTags;
    String[] lemmas;
    String[] resultTagsCan;
    public static ObservableList<Word> data;

    @FXML
    void initialize() {
        back.setOnAction(event -> new WindowApp().getWindow(back, "../forms/MenuForm.fxml"));

        table.setItems(getData());
        word.setCellValueFactory(new PropertyValueFactory<>("word"));
        frequency.setCellValueFactory(new PropertyValueFactory<>("frequency"));
        tags.setCellValueFactory(new PropertyValueFactory<>("tags"));
        canForm.setCellValueFactory(new PropertyValueFactory<>("forms"));
        canTagsColumn.setCellValueFactory(new PropertyValueFactory<>("canonicalTags"));

        editButton.setOnAction(event -> {
            newScene("/forms/EditWordForm.fxml", "Edit word");
        });

        fieldText.setOnMouseClicked(event -> {
            FilteredList<Word> filteredList = new FilteredList<>(getData(), b -> true);
            fieldText.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredList.setPredicate(word -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowerCase = newValue.toLowerCase();
                    return word.getWord().toLowerCase().startsWith(lowerCase);
                });
            });
            SortedList<Word> sortedList = new SortedList<>(filteredList);
            sortedList.comparatorProperty().bind(table.comparatorProperty());
            table.setItems(sortedList);
        });
    }

    private ObservableList<Word> getData() {
        data = FXCollections.observableArrayList();
        Set<String> set = Vocabulary.getInstance().getVocabulary().keySet();
        ArrayList<String> keys = new ArrayList<>(set);
        Integer[] values = Vocabulary.getInstance().getVocabulary().values().toArray(new Integer[0]);
        /*for (Map.Entry<String, Integer> entry : Vocabulary.getInstance().getVocabulary().entrySet()) {
            data.add(new Word(entry.getKey(), entry.getValue()));
        }*/
        color();
        for (int i = 0; i < keys.size(); i++) {
            data.add(new Word(keys.get(i), values[i], resultTags[i], lemmas[i],resultTagsCan[i]));
            //System.out.println(new Word(keys.get(i), values[i], resultTags[i], lemmas[i],resultTagsCan[i]));
        }
        return data;
    }

    private void color() {
        Sequence[] topSequences = null;
        String[] massWord = Vocabulary.getInstance().getVocabulary().keySet().toArray(new String[0]);
        try (FileInputStream modelIn = new FileInputStream("en-pos-maxent.bin")) {
            POSModel model = new POSModel(modelIn);
            POSTaggerME tagger = new POSTaggerME(model);
            topSequences = tagger.topKSequences(massWord);
        } catch (IOException e) {
            e.printStackTrace();
        }
        resultTags = new String[massWord.length];
        assert topSequences != null;
        for (int i = 0; i < resultTags.length; i++) {
            resultTags[i] = "";
            for (Sequence topSequence : topSequences) {
                if (!resultTags[i].contains(topSequence.getOutcomes().get(i) + "/")) {
                    resultTags[i] += topSequence.getOutcomes().get(i) + "/";
                }
            }
        }

        LemmatizerModel model;
        lemmas = null;
        try (InputStream modelIn = new FileInputStream("en-lemmatizer.bin")) {
            model = new LemmatizerModel(modelIn);
            LemmatizerME lemmatizer = new LemmatizerME(model);
            lemmas = lemmatizer.lemmatize(massWord, topSequences[0].getOutcomes().toArray(new String[0]));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Sequence[] topCan = null;
        try (FileInputStream modelInCan = new FileInputStream("en-pos-maxent.bin")) {
            POSModel modelCan = new POSModel(modelInCan);
            POSTaggerME taggerCan = new POSTaggerME(modelCan);
            topCan = taggerCan.topKSequences(lemmas);
        } catch (IOException e) {
            e.printStackTrace();
        }
        resultTagsCan = new String[lemmas.length];
        assert topCan != null;
        for (int i = 0; i < resultTagsCan.length; i++) {
            resultTagsCan[i] = "";
            for (Sequence topCa : topCan) {
                if (!resultTagsCan[i].contains(topCa.getOutcomes().get(i) + " ")) {
                    resultTagsCan[i] += topCa.getOutcomes().get(i) + " ";
                }
            }
        }
    }
    private void newScene(String urlToForm, String nameTitle) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(urlToForm));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle(nameTitle);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(Main.primary);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            dialogStage.showAndWait();
            table.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
